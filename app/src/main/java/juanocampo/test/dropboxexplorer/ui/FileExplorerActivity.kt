package juanocampo.test.dropboxexplorer.ui

import android.Manifest
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.AndroidInjection
import juanocampo.test.dropboxexplorer.R
import juanocampo.test.dropboxexplorer.ui.FileExplorerActivity.Factory.EXTERNAL_REQUEST_ACCESS
import juanocampo.test.dropboxexplorer.ui.FileExplorerActivity.Factory.EXTRA_PATH
import juanocampo.test.dropboxexplorer.ui.adapter.FileAdapter
import juanocampo.test.presentation.entitiy.FileViewType
import juanocampo.test.presentation.presenter.FileExplorerPresenter
import juanocampo.test.presentation.view.FileExplorerView
import kotlinx.android.synthetic.main.file_list_activity.*
import javax.inject.Inject

class FileExplorerActivity: AppCompatActivity(), FileExplorerView {

    object Factory {
        const val EXTRA_PATH = "path"
        const val EXTERNAL_REQUEST_ACCESS: Int = 100
        fun build(context: Context, path: String = ""): Intent {
            val filesIntent = Intent(context, FileExplorerActivity::class.java)
            filesIntent.putExtra(EXTRA_PATH, path)
            return filesIntent
        }
    }

    @Inject
    lateinit var presenter: FileExplorerPresenter

    private lateinit var path: String

    private val adapter = FileAdapter {
        onFolderSelected(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.file_list_activity)
        val pathIntent = intent.getStringExtra(EXTRA_PATH)
        path = pathIntent ?: ""
        recyclerFileExplorer.layoutManager = LinearLayoutManager(this)
        recyclerFileExplorer.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        presenter.bind(this)
        presenter.loadList(path)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unBind()
    }

    private fun onFolderSelected(file: FileViewType) {
        presenter.processSelectedItem(file)
    }

    override fun setName(title: String) {
        this.title = title
    }

    override fun showLoader() {
        fileExplorerProgress.visibility = View.VISIBLE
    }

    override fun hideLoader() {
        fileExplorerProgress.visibility = View.GONE
    }

    override fun loadFiles(files: List<FileViewType>) {
        adapter.addItems(files)
    }

    override fun showFileDetails(file: FileViewType) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun openExternalFile(intent: Intent) {
    }

    override fun navigateToFolder(path: String) {
        startActivityForResult(Factory.build(this, path), 0)
    }

    override fun generalError() {
        Toast.makeText(this, "Something when wrong", Toast.LENGTH_SHORT).show()
    }

    override fun requestExternalAccess() {
        AlertDialog.Builder(this)
            .setMessage("This app requires storage access to download and upload files.")
            .setPositiveButton("OK"
            ) { _, _ ->
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    EXTERNAL_REQUEST_ACCESS
                )                }
            .setNegativeButton("Cancel", null)
            .create()
            .show()
    }

    override fun onRequestPermissionsResult(actionCode: Int, @NonNull permissions: Array<String>, @NonNull grantResults: IntArray) {
        for (i in grantResults.indices) {
            if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                presenter.downLoadFile()
                break
            }
        }
    }

}