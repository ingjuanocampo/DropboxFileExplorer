package juanocampo.test.file_explorer_sdk.service.sdk

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Environment
import android.webkit.MimeTypeMap
import com.dropbox.core.v2.files.ListFolderResult
import com.dropbox.core.v2.users.FullAccount
import juanocampo.test.file_explorer_sdk.service.Client
import juanocampo.test.file_explorer_sdk.service.DropboxClientFactory
import juanocampo.test.file_explorer_sdk.service.PicassoClient
import java.io.File
import java.io.FileOutputStream

class ClientImp(private val context: Context) : Client {

    override fun downLoadFile(id: String, name: String, rev: String): Pair<String, File>? {

        val path = Environment.getExternalStoragePublicDirectory(
            Environment.DIRECTORY_DOWNLOADS
        )
        val file = File(path, name)

        // Make sure the Downloads directory exists.
        if (!path.exists()) {
            if (!path.mkdirs()) {
                throw RuntimeException("Unable to create directory: $path")
            }
        } else check(path.isDirectory) { "Download path is not a directory: $path" }

        // Download the file.
        FileOutputStream(file).use { outputStream ->
            DropboxClientFactory.getClient().files().download(id, rev)
                .download(outputStream)
        }

        // Tell android about the file
        val intent = Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE)
        intent.data = Uri.fromFile(file)
        context.sendBroadcast(intent)


        val mime = MimeTypeMap.getSingleton()
        val ext = file.getName().substring(file.getName().indexOf(".") + 1)
        val type = mime.getMimeTypeFromExtension(ext)

        return Pair(type,file)
    }

    override fun getListFolderResults(path: String): ListFolderResult? {
        return DropboxClientFactory.getClient().files().listFolder(path)
    }

    override fun init(token: String) {
        DropboxClientFactory.init(token)
        PicassoClient.init(context, DropboxClientFactory.getClient())
    }

    override fun getUser(): FullAccount? {
        return DropboxClientFactory.getClient().users()?.currentAccount
    }
}