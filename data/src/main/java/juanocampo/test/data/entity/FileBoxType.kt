package juanocampo.test.data.entity

sealed class FileBoxType
object FolderBox: FileBoxType()
object ImageBox: FileBoxType()
object DocumentBox: FileBoxType()