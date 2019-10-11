package juanocampo.test.presentation.entitiy

import androidx.annotation.IntegerRes

data class FileViewType(@IntegerRes private val type: Int,
                        private val name: String,
                        private val id: String,
                        private val previewImageUrl: String): RecyclerViewType {

    override fun getDelegateId() = id.toInt()

    override fun getViewType() = 1

}