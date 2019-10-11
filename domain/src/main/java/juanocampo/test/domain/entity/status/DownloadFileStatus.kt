package juanocampo.test.domain.entity.status

import juanocampo.test.domain.entity.entity.FileIntent

sealed class DownloadFileStatus
class DownloadSuccess(val fileIntent: FileIntent): DownloadFileStatus()
class DownloadError(val e: String): DownloadFileStatus()
