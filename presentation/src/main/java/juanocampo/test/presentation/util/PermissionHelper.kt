package juanocampo.test.presentation.util

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat

class PermissionHelper(private val context: Context) {

    fun hasWriteExternalStoragePermission(): Boolean {
        val result = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        if (result == PackageManager.PERMISSION_DENIED) {
            return false
        }
        return true
    }

}