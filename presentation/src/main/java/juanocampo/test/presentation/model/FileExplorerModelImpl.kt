package juanocampo.test.presentation.model

import juanocampo.test.domain.entity.status.DownloadFileStatus
import juanocampo.test.domain.entity.status.LoadFileDetailsStatus
import juanocampo.test.domain.entity.status.LoadFileListStatus

class FileExplorerModelImpl: FileExplorerModel {

    override suspend fun loadFileList(): LoadFileListStatus {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun lookFileDetailsById(id: String): LoadFileDetailsStatus {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun downloadFile(id: String): DownloadFileStatus {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}