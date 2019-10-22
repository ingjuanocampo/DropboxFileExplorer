package juanocampo.test.presentation.entitiy

import androidx.annotation.DrawableRes
import juanocampo.test.domain.entity.FileType

data class FileViewType(@DrawableRes val type: Int,
                        val fileViewType: FileType,
                        val name: String,
                        val id: String,
                        val path: String): RecyclerViewType {

    override fun getDelegateId() = id.hashCode()

    override fun getViewType() = 1

}