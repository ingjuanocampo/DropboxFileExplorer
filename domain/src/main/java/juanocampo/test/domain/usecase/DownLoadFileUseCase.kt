package juanocampo.test.domain.usecase

import juanocampo.test.domain.entity.FileIntent
import juanocampo.test.domain.repository.FileRepository
import juanocampo.test.domain.status.DownloadError
import juanocampo.test.domain.status.DownloadFileStatus
import juanocampo.test.domain.status.DownloadSuccess
import java.lang.Exception

class DownLoadFileUseCase(private val fileRepository: FileRepository) {

    operator fun invoke(path: String): DownloadFileStatus {
        return try {
            val file = fileRepository.getFileByPath(path)
            if (file == null) {
                DownloadError
            }
            var result: FileIntent? = null
            if (file != null) {
                result = fileRepository.downLoadFile(path, file.name, file.rev)
            }
            if (result != null) {
                DownloadSuccess(result)
            } else {
                DownloadError
            }
        } catch (e: Exception) {
          DownloadError
        }

    }
}