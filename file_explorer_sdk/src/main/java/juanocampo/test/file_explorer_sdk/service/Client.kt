package juanocampo.test.file_explorer_sdk.service

import com.dropbox.core.v2.files.ListFolderResult
import com.dropbox.core.v2.users.FullAccount

interface Client {

    fun init(token: String)

    fun getUser(): FullAccount?

    fun getListFolderResults(path: String): ListFolderResult?

}