package juanocampo.test.presentation.entitiy

import androidx.annotation.IntegerRes

data class FileViewType(@IntegerRes val type: Int,
                        val name: String,
                        val id: String,
                        val previewImageUrl: String): RecyclerViewType {

    override fun getDelegateId() = id.toInt()

    override fun getViewType() = 1

}