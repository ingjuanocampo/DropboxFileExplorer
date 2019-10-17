package juanocampo.test.file_explorer_sdk

import com.dropbox.core.v2.files.Metadata
import juanocampo.test.data.entity.FileBoxRepo

interface Mapper {

    fun map(entry: Metadata): FileBoxRepo
}