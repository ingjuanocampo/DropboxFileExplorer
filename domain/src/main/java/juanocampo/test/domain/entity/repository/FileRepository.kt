package juanocampo.test.domain.entity.repository

import juanocampo.test.domain.entity.entity.FileD
import juanocampo.test.domain.entity.entity.FileIntent

interface FileRepository {

    fun loadFiles(path: String): List<FileD>?

    fun downLoadFile(id: String, name: String, rev: String): FileIntent?

    fun getFileByPath(id: String): FileD?
}