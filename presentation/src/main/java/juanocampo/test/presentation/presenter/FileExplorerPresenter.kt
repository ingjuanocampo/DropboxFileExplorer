package juanocampo.test.presentation.presenter

import android.content.Context
import juanocampo.test.domain.entity.status.*
import juanocampo.test.presentation.model.FileExplorerModel
import juanocampo.test.presentation.mapper.UIMapper
import juanocampo.test.presentation.view.FileExplorerView
import kotlinx.coroutines.launch

class FileExplorerPresenter(private val fileExplorerModel: FileExplorerModel, private val fileMapper: UIMapper):
    BasePresenter<FileExplorerView>() {

    fun loadList() = launch {

        when(val status = fileExplorerModel.loadFileList()) {
            is ListSuccess -> {
                val list = status.list
                val uiElements = list.map { fileMapper.mapToUIFile(it) }
                publishResults { view?.loadFiles(uiElements) }
            }
            is ListError -> publishResults { view?.generalError() }
        }

    }

    fun goToFile(id: String, context: Context) = launch {
        when (val downloadStatus = fileExplorerModel.downloadFile(id)) {
            is DownloadSuccess -> {
                val intent = fileMapper.mapFileIntent(downloadStatus.fileIntent, context)
                publishResults { view?.navigateToFile(intent) }
            }
            is DownloadError -> {
                publishResults { view?.generalError() }
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


}