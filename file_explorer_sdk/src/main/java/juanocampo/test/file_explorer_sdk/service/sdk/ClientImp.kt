package juanocampo.test.file_explorer_sdk.service.sdk

import android.content.Context
import com.dropbox.core.v2.DbxClientV2
import com.dropbox.core.v2.files.ListFolderResult
import com.dropbox.core.v2.users.FullAccount
import juanocampo.test.file_explorer_sdk.service.Client
import juanocampo.test.file_explorer_sdk.service.DropboxClientFactory
import juanocampo.test.file_explorer_sdk.service.PicassoClient

class ClientImp(private val context: Context): Client {

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