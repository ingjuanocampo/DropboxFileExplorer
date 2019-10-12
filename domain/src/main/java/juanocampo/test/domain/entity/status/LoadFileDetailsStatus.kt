package juanocampo.test.domain.entity.status

import juanocampo.test.domain.entity.entity.FileD

sealed class LoadFileDetailsStatus
class DetailSuccess(val file: FileD): LoadFileDetailsStatus()
class DetailError(val e: String): LoadFileDetailsStatus()