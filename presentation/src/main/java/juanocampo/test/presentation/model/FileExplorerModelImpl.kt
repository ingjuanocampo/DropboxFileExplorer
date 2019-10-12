package juanocampo.test.presentation.model

import juanocampo.test.domain.entity.status.*
import juanocampo.test.domain.entity.usecase.LoadFileListUseCase
import juanocampo.test.presentation.util.PermissionHelper

class FileExplorerModelImpl(private val loadFileListUseCase: LoadFileListUseCase,
                            private val permission: PermissionHelper): FileExplorerModel {

    override suspend fun loadFileList(path: String): LoadFileListStatus {
        return loadFileListUseCase(path)
    }

    override suspend fun lookFileDetailsById(id: String): LoadFileDetailsStatus {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun downloadFile(id: String): DownloadFileStatus {
        return if (permission.hasWriteExternalStoragePermission()) {
            DownloadError
        } else {
            RequestPermission

        }
    }
}