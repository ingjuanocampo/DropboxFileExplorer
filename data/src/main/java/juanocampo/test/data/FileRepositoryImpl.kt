package juanocampo.test.data

import juanocampo.test.data.entity.FileBoxRepo
import juanocampo.test.data.mapper.RepositoryMapper
import juanocampo.test.data.sources.FileRemoteDataSource
import juanocampo.test.domain.entity.entity.FileD
import juanocampo.test.domain.entity.entity.FileIntent
import juanocampo.test.domain.entity.repository.FileRepository

class FileRepositoryImpl(private val localDataSource: FileRemoteDataSource,
                         private val mapper: RepositoryMapper): FileRepository {


    private var response: List<FileBoxRepo>? = null

    override fun getFileByPath(id: String): FileD? {
        val foundItem = response?.findLast { it.pathLower == id }
        return if (foundItem != null) {
            mapper.map(foundItem)
        } else {
            null
        }
    }


    override fun downLoadFile(id: String, name: String, rev: String): FileIntent? {
        val result = localDataSource.downLoadFile(id, name, rev)
        return if (result != null) {
            mapper.map(result)
        } else {
            null
        }
    }


    override fun loadFiles(path: String): List<FileD>? {
        response = localDataSource.loadList(path)
        return if (response != null) {
            response?.map { mapper.map(it) }
        } else {
            null
        }
    }
}