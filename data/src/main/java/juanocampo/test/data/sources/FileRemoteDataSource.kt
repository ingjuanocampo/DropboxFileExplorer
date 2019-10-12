package juanocampo.test.data.sources

import juanocampo.test.data.entity.FileBoxRepo
import java.io.File

interface FileRemoteDataSource {
    fun loadList(path: String): List<FileBoxRepo>?
    fun loadFileImage(function: (Any) -> Unit)
    fun downLoadFile(id: String, name: String, rev: String): Pair<String, File>?

}