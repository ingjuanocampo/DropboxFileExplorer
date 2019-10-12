package juanocampo.test.data

import juanocampo.test.data.mapper.RepositoryMapper
import juanocampo.test.data.sources.FileRemoteDataSource
import juanocampo.test.domain.entity.entity.FileD
import juanocampo.test.domain.entity.repository.FileRepository

class FileRepositoryImpl(private val localDataSource: FileRemoteDataSource,
                         private val mapper: RepositoryMapper): FileRepository {


    override fun loadFiles(path: String): List<FileD>? {
        val response = localDataSource.loadList(path)
        return if (response != null) {
            mapper.map(response)
        } else {
            null
        }
    }
}