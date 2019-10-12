package juanocampo.test.file_explorer_sdk.service.mapper

import android.webkit.MimeTypeMap
import com.dropbox.core.v2.files.FileMetadata
import com.dropbox.core.v2.files.FolderMetadata
import com.dropbox.core.v2.files.Metadata
import juanocampo.test.data.entity.*
import juanocampo.test.file_explorer_sdk.Mapper

class MapperImpl: Mapper {

    override fun map(it: Metadata): FileBoxRepo {
        var ext: String? = null
        var fileBoxRepo: FileBoxType = FolderBox
        var imagePath = ""
        var id = ""
        if (it is FileMetadata) {
            val mime = MimeTypeMap.getSingleton()
            ext = it.getName().substring(it.getName().indexOf(".") + 1)
            var type = mime.getMimeTypeFromExtension(ext)
            if (type != null && type.startsWith("image/")) run {
                fileBoxRepo = ImageBox
                imagePath = it.pathLower
            } else {
                fileBoxRepo = DocumentBox
            }
            id = it.id
        } else if (it is FolderMetadata) {
            fileBoxRepo = FolderBox
            id = it.id
        }
        return FileBoxRepo(name = it.name, type = fileBoxRepo, imagePath = imagePath, id = id)
    }
}