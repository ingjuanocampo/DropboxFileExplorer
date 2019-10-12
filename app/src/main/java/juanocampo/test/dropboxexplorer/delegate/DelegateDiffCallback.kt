package juanocampo.test.dropboxexplorer.delegate

import androidx.recyclerview.widget.DiffUtil
import juanocampo.test.presentation.entitiy.RecyclerViewType

class DelegateDiffCallback(
    private val oldItems: List<RecyclerViewType>,
    private val newItems: List<RecyclerViewType>
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition].getDelegateId() == newItems[newItemPosition].getDelegateId()
    }

    override fun getOldListSize() = oldItems.size

    override fun getNewListSize() = newItems.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition] == newItems[newItemPosition]
    }
}