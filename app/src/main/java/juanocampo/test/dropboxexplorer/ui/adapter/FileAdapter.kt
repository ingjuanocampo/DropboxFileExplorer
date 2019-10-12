package juanocampo.test.dropboxexplorer.ui.adapter

import androidx.collection.SparseArrayCompat
import juanocampo.test.dropboxexplorer.delegate.BaseAdapter
import juanocampo.test.dropboxexplorer.delegate.appendDelegate
import juanocampo.test.presentation.entitiy.FileViewType

class FileAdapter(onFolderSelected: (FileViewType) -> Unit, onDetailSelected: (FileViewType) -> Unit) : BaseAdapter() {

    init {
        delegateAdapters = SparseArrayCompat(1)
        delegateAdapters.appendDelegate(1, FileDelegateAdapter(onFolderSelected, onDetailSelected))
    }
}