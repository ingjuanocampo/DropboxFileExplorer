package juanocampo.test.presentation.model

import juanocampo.test.domain.entity.status.*
import juanocampo.test.domain.entity.usecase.DownLoadFileUseCase
import juanocampo.test.domain.entity.usecase.LoadFileListUseCase
import juanocampo.test.presentation.util.PermissionHelper

class FileExplorerModelImpl(private val loadFileListUseCase: LoadFileListUseCase,
                            private val permission: PermissionHelper,
                            private val downLoadFileUseCase: DownLoadFileUseCase
): FileExplorerModel {

    override suspend fun loadFileList(path: String): LoadFileListStatus {
        return loadFileListUseCase(path)
    }

    override suspend fun downloadFile(id: String): DownloadFileStatus {
        return if (permission.hasWriteExternalStoragePermission()) {
            downLoadFileUseCase(id)
        } else {
            RequestPermission
        }
    }
}