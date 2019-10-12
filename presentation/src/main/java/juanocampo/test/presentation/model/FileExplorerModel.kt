package juanocampo.test.presentation.model

import juanocampo.test.domain.entity.status.DownloadFileStatus
import juanocampo.test.domain.entity.status.LoadFileDetailsStatus
import juanocampo.test.domain.entity.status.LoadFileListStatus

interface FileExplorerModel {

    suspend fun loadFileList(path: String): LoadFileListStatus

    suspend fun lookFileDetailsById(id: String): LoadFileDetailsStatus

    suspend fun downloadFile(id: String): DownloadFileStatus

}