package juanocampo.test.domain.entity.status

import juanocampo.test.domain.entity.entity.FileIntent

sealed class DownloadFileStatus
class DownloadSuccess(val fileIntent: FileIntent): DownloadFileStatus()
object RequestPermission: DownloadFileStatus()
object DownloadError: DownloadFileStatus()
