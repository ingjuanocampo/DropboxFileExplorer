package juanocampo.test.dropboxexplorer.delegate

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import juanocampo.test.presentation.entitiy.RecyclerViewType

interface DelegateAdapter<VH : RecyclerView.ViewHolder, VT : RecyclerViewType> {

    fun onCreateViewHolder(parent: ViewGroup): VH

    fun onBindViewHolder(viewHolder: VH, viewType: VT)
}