package juanocampo.test.data.sources

import juanocampo.test.data.entity.FileBoxRepo

interface FileRemoteDataSource {
    fun loadList(path: String): List<FileBoxRepo>?
    fun loadFileImage(function: (Any) -> Unit)

}