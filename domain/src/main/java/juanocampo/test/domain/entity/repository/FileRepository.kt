package juanocampo.test.domain.entity.repository

import juanocampo.test.domain.entity.entity.FileD

interface FileRepository {

    fun loadFiles(path: String): List<FileD>?

}