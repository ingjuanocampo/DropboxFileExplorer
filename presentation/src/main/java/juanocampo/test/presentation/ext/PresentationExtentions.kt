package juanocampo.test.presentation.ext

import juanocampo.test.domain.entity.entity.Document
import juanocampo.test.domain.entity.entity.FileD
import juanocampo.test.domain.entity.entity.Folder
import juanocampo.test.domain.entity.entity.Image
import juanocampo.test.presentation.R
import juanocampo.test.presentation.entitiy.FileViewType

fun FileD.toUIModel(): FileViewType {

    val resourcePreview = when (this.fileType) {
        is Folder -> R.drawable.ic_folder_blue_36dp
        is Document -> R.drawable.ic_insert_drive_file_blue_36dp
        is Image ->  R.drawable.ic_photo_grey_600_36dp
    }

    return FileViewType(type = resourcePreview,
        previewImageUrl = imagePath,
        id = this.id,
        name = this.name)
}