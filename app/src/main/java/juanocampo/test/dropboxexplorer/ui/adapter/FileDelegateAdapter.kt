package juanocampo.test.dropboxexplorer.ui.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import juanocampo.test.domain.entity.entity.Image
import juanocampo.test.dropboxexplorer.R
import juanocampo.test.dropboxexplorer.delegate.DelegateAdapter
import juanocampo.test.presentation.entitiy.FileViewType

class FileDelegateAdapter(private val onFileSelected: (FileViewType) -> Unit) : DelegateAdapter<FileDelegateAdapter.ViewHolder, FileViewType> {
    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder = ViewHolder(parent, onFileSelected)

    override fun onBindViewHolder(viewHolder: ViewHolder, viewType: FileViewType) = viewHolder.bind(viewType)

    class ViewHolder(
        viewGroup: ViewGroup,
        private val onFileSelected: (FileViewType) -> Unit
    ):
        RecyclerView.ViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.folder_item, viewGroup, false)) {

        private val filePreview: ImageView = itemView.findViewById(R.id.filePreview)
        private val name: TextView = itemView.findViewById(R.id.fileDescription)

        fun bind(file: FileViewType) {
            if (file.fileViewType is Image) {
                loadImage{ uri ->
                    if (uri is Uri) {

                    }
                }
            } else {
                Picasso.get().load(file.type).into(filePreview)
            }

            itemView.setOnClickListener{ onFileSelected(file) }

            name.text = file.name
        }

        private fun loadImage(function: (Any) -> Unit) {

        }
    }
}