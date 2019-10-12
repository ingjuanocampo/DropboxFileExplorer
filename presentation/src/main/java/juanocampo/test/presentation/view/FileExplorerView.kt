package juanocampo.test.presentation.view

import android.content.Intent
import juanocampo.test.presentation.entitiy.FileViewType

interface FileExplorerView {

    fun loadFiles(files: List<FileViewType>)

    fun showFileDetails(file: FileViewType)

    fun openExternalFile(intent: Intent)

    fun navigateToFolder(path: String)

    fun generalError()

    fun showLoader()

    fun hideLoader()

    fun setName(title: String)

    fun requestExternalAccess()

    fun showDownloading()
}