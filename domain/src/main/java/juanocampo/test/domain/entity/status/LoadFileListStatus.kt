package juanocampo.test.domain.entity.status

import juanocampo.test.domain.entity.entity.FileD

sealed class LoadFileListStatus
class ListSuccess(val list: List<FileD>): LoadFileListStatus()
object ListError: LoadFileListStatus()

