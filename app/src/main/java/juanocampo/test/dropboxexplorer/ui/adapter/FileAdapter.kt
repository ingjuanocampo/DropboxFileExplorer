package juanocampo.test.dropboxexplorer.ui.adapter

import androidx.collection.SparseArrayCompat
import juanocampo.test.dropboxexplorer.delegate.BaseAdapter
import juanocampo.test.dropboxexplorer.delegate.appendDelegate

class FileAdapter : BaseAdapter() {

    init {
        delegateAdapters = SparseArrayCompat(1)
        delegateAdapters.appendDelegate(1, FileDelegateAdapter())
    }
}