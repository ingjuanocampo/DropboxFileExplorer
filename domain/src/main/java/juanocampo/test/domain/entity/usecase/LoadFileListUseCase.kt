package juanocampo.test.domain.entity.usecase

import juanocampo.test.domain.entity.repository.FileRepository
import juanocampo.test.domain.entity.status.ListError
import juanocampo.test.domain.entity.status.ListSuccess
import juanocampo.test.domain.entity.status.LoadFileListStatus

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