package juanocampo.test.domain.status

import juanocampo.test.domain.entity.FileIntent

sealed class DownloadFileStatus
class DownloadSuccess(val fileIntent: FileIntent): DownloadFileStatus()
object RequestPermission: DownloadFileStatus()
object DownloadError: DownloadFileStatus()
object DownloadInProgress: DownloadFileStatus()
