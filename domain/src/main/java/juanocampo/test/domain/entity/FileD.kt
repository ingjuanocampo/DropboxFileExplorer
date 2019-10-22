package juanocampo.test.domain.entity

data class FileD(
    val fileType: FileType,
    val extType: String = "",
    val imagePath: String,
    val name: String,
    val id: String,
    val previewImageUrl: String = "",
    val rev: String
)