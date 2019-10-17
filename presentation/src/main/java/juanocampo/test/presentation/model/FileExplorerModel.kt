package juanocampo.test.presentation.model

import juanocampo.test.domain.status.DownloadFileStatus
import juanocampo.test.domain.status.LoadFileListStatus

interface FileExplorerModel {

    suspend fun loadFileList(path: String): LoadFileListStatus

    suspend fun downloadFile(id: String): DownloadFileStatus

}