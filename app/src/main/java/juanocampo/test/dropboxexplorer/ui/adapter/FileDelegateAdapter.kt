package juanocampo.test.dropboxexplorer.ui.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import juanocampo.test.dropboxexplorer.R
import juanocampo.test.dropboxexplorer.delegate.DelegateAdapter
import juanocampo.test.presentation.entitiy.FileViewType

class FileDelegateAdapter: DelegateAdapter<FileDelegateAdapter.ViewHolder, FileViewType> {
    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder = ViewHolder(parent)

    override fun onBindViewHolder(viewHolder: ViewHolder, viewType: FileViewType) = viewHolder.bind(viewType)

    class ViewHolder(viewGroup: ViewGroup):
        RecyclerView.ViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.folder_item, viewGroup, false)) {

        private val filePreview: ImageView = itemView.findViewById(R.id.filePreview)
        private val name: TextView = itemView.findViewById(R.id.fileDescription)

        fun bind(file: FileViewType) {
            loadImage{ uri ->
                if (uri is Uri) {

                }
            }
            name.text = file.name
        }

        private fun loadImage(function: (Any) -> Unit) {

        }
    }
}