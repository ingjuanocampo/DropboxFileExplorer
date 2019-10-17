package juanocampo.test.domain.status

import juanocampo.test.domain.entity.FileD

sealed class LoadFileListStatus
class ListSuccess(val list: List<FileD>): LoadFileListStatus()
object ListError: LoadFileListStatus()

