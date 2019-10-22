package juanocampo.test.domain.entity

sealed class FileType
object Folder: FileType()
object Image: FileType()
object Document: FileType()