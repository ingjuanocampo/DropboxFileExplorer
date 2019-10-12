package juanocampo.test.dropboxexplorer.delegate


import androidx.collection.SparseArrayCompat
import androidx.recyclerview.widget.RecyclerView
import juanocampo.test.presentation.entitiy.RecyclerViewType

@Suppress("UNCHECKED_CAST")
fun <E : DelegateAdapter<RecyclerView.ViewHolder, RecyclerViewType>> SparseArrayCompat<E>.appendDelegate(
    delegateId: Int,
    delegate: DelegateAdapter<out RecyclerView.ViewHolder, out RecyclerViewType>
) {
    this.append(delegateId, delegate as E)
}