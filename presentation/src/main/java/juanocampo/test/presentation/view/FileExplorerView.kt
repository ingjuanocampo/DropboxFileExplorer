package juanocampo.test.presentation.view

import android.content.Intent
import juanocampo.test.presentation.entitiy.FileViewType

interface FileExplorerView {

    fun loadFiles(files: List<FileViewType>)

    fun showFileDetails(file: FileViewType)

    fun navigateToFile(intent: Intent)

    fun navigateToFolder(intent: Intent)

    fun generalError()
}