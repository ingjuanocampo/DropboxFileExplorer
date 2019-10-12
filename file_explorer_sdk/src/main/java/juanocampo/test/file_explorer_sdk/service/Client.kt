package juanocampo.test.file_explorer_sdk.service

import com.dropbox.core.v2.files.ListFolderResult
import com.dropbox.core.v2.users.FullAccount
import java.io.File

interface Client {

    fun init(token: String)

    fun getUser(): FullAccount?

    fun getListFolderResults(path: String): ListFolderResult?

    fun downLoadFile(id: String, name: String, rev: String): Pair<String, File>?

}