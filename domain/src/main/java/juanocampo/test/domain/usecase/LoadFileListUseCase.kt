package juanocampo.test.domain.usecase

import juanocampo.test.domain.repository.FileRepository
import juanocampo.test.domain.status.ListError
import juanocampo.test.domain.status.ListSuccess
import juanocampo.test.domain.status.LoadFileListStatus

class LoadFileListUseCase(private val repository: FileRepository) {

    operator fun invoke(path: String): LoadFileListStatus {
        return try {
            val fileList = repository.loadFiles(path)
            if (fileList != null && fileList.isNotEmpty()) {
                ListSuccess(fileList)
            } else {
                ListError
            }

        } catch (e: Exception) {
            ListError
        }
    }

}