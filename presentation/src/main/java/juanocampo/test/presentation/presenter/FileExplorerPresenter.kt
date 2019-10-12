package juanocampo.test.presentation.presenter

import android.content.Context
import juanocampo.test.domain.entity.entity.Folder
import juanocampo.test.domain.entity.status.*
import juanocampo.test.presentation.entitiy.FileViewType
import juanocampo.test.presentation.model.FileExplorerModel
import juanocampo.test.presentation.mapper.UIMapper
import juanocampo.test.presentation.view.FileExplorerView
import kotlinx.coroutines.launch

class FileExplorerPresenter(private val context: Context, private val fileExplorerModel: FileExplorerModel, private val fileMapper: UIMapper):
    BasePresenter<FileExplorerView>() {

    private var requestToDownload: String? = null

    fun loadList(path: String) = launch {
        publishResults { view?.showLoader() }
        setTitle(path)
        when(val status = fileExplorerModel.loadFileList(path)) {
            is ListSuccess -> {
                val list = status.list
                val uiElements = list.map { fileMapper.mapToUIFile(it) }
                publishResults {
                    view?.hideLoader()
                    view?.loadFiles(uiElements) }
            }
            is ListError -> publishResults { view?.generalError() }
        }

    }

    private suspend fun setTitle(path: String) {
        var title = "Home"
        if (path.isNotEmpty()) {
            title = path
        }
        publishResults { view?.setName(title) }
    }

    fun downLoadFile(id: String = "") = launch {
        if (id.isEmpty()) return@launch

        publishResults { view?.showDownloading() }
        requestToDownload = id
        when (val downloadStatus = fileExplorerModel.downloadFile(id)) {
            is DownloadSuccess -> {
                val intent = fileMapper.mapFileIntent(downloadStatus.fileIntent, context)
                publishResults { view?.openExternalFile(intent) }
            }
            is DownloadError -> {
                publishResults { view?.generalError() }
            }
            is RequestPermission -> {
                publishResults { view?.requestExternalAccess() }
            }
        }
    }

    fun seeFileDetails(id: String) = launch {
        when(val loadFileStatus = fileExplorerModel.lookFileDetailsById(id)) {
            is DetailSuccess -> {
                val fileViewType = fileMapper.mapToUIFile(loadFileStatus.file)
                publishResults { view?.showFileDetails(fileViewType) }
            }
            is DetailError -> publishResults { view?.generalError() }
        }
    }

    fun processSelectedItem(file: FileViewType) {
        when (file.fileViewType) {
            is Folder -> view?.navigateToFolder(file.path)
            else -> downLoadFile(file.path)
        }

    }


}