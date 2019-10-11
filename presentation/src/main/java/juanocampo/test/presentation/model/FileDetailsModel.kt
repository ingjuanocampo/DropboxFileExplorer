package juanocampo.test.presentation.model

import juanocampo.test.domain.entity.entity.FileDropbox

interface FileDetailsModel {

    suspend fun lookFileDetail(): FileDropbox

}