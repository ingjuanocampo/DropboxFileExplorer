package juanocampo.test.presentation.model

import juanocampo.test.domain.entity.status.DownloadFileStatus
import juanocampo.test.domain.entity.status.LoadFileDetailsStatus
import juanocampo.test.domain.entity.status.LoadFileListStatus
import juanocampo.test.domain.entity.usecase.LoadFileListUseCase

class FileExplorerModelImpl(private val loadFileListUseCase: LoadFileListUseCase): FileExplorerModel {

    override suspend fun loadFileList(path: String): LoadFileListStatus {
        return loadFileListUseCase(path)
    }

    override suspend fun lookFileDetailsById(id: String): LoadFileDetailsStatus {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun downloadFile(id: String): DownloadFileStatus {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}