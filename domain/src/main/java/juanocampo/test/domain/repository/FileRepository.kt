package juanocampo.test.domain.repository

import juanocampo.test.domain.entity.FileD
import juanocampo.test.domain.entity.FileIntent

interface FileRepository {

    fun loadFiles(path: String): List<FileD>?

    fun downLoadFile(id: String, name: String, rev: String): FileIntent?

    fun getFileByPath(id: String): FileD?
}