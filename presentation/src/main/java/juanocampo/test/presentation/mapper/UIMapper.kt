package juanocampo.test.presentation.mapper

import android.content.Context
import android.content.Intent
import juanocampo.test.domain.entity.entity.FileD
import juanocampo.test.domain.entity.entity.FileIntent

import juanocampo.test.presentation.entitiy.FileViewType

interface UIMapper {

    fun mapToUIFile(file: FileD): FileViewType

    fun mapFileIntent(fileIntent: FileIntent, context: Context): Intent
}

