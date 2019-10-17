package juanocampo.test.file_explorer_sdk.service.mapper

import android.webkit.MimeTypeMap
import com.dropbox.core.v2.files.FileMetadata
import com.dropbox.core.v2.files.FolderMetadata
import com.dropbox.core.v2.files.Metadata
import juanocampo.test.data.entity.*
import juanocampo.test.file_explorer_sdk.Mapper

class MapperImpl: Mapper {

    override fun map(entry: Metadata): FileBoxRepo {
        var ext: String? = null
        var fileBoxRepo: FileBoxType = FolderBox
        var pathLower = ""
        var id = ""
        var rev = ""
        if (entry is FileMetadata) {
            val mime = MimeTypeMap.getSingleton()
            ext = entry.getName().substring(entry.getName().indexOf(".") + 1)
            var type = mime.getMimeTypeFromExtension(ext)
            if (type != null && type.startsWith("image/")) run {
                fileBoxRepo = ImageBox
                pathLower = entry.pathLower
            } else {
                fileBoxRepo = DocumentBox
                pathLower = entry.pathLower
            }
            id = entry.id
            rev = entry.rev
        } else if (entry is FolderMetadata) {
            fileBoxRepo = FolderBox
            id = entry.id
            pathLower = entry.pathLower
        }
        return FileBoxRepo(name = entry.name, type = fileBoxRepo, pathLower = pathLower, id = id, rev = rev)
    }
}