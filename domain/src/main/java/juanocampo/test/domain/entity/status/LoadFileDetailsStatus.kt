package juanocampo.test.domain.entity.status

import juanocampo.test.domain.entity.entity.FileDropbox

sealed class LoadFileDetailsStatus
class DetailSuccess(val file: FileDropbox): LoadFileDetailsStatus()
class DetailError(val e: String): LoadFileDetailsStatus()