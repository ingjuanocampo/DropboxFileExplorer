package juanocampo.test.domain.entity.status

import juanocampo.test.domain.entity.entity.FileDropbox

sealed class LoadFileListStatus
class ListSuccess(val list: List<FileDropbox>): LoadFileListStatus()
class ListError(val e: String): LoadFileListStatus()

