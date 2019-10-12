package juanocampo.test.file_explorer_sdk


import juanocampo.test.data.entity.*
import juanocampo.test.data.sources.FileRemoteDataSource
import juanocampo.test.file_explorer_sdk.service.Client
import java.io.File

class FileRemoteDataSourceImpl(private val client: Client, private val mapper: Mapper) : FileRemoteDataSource {

    override fun downLoadFile(id: String, name: String, rev: String): Pair<String, File>? =
        client.downLoadFile(id, name, rev )


    override fun loadList(path: String): List<FileBoxRepo>? {
        val folderResult = client.getListFolderResults(path)
        val files = folderResult?.entries
        return files?.map { mapper.map(it) }
    }

    override fun loadFileImage(function: (Any) -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}