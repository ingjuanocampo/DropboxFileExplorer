package juanocampo.test.file_explorer_sdk.service.di

import android.content.Context
import dagger.Module
import dagger.Provides
import juanocampo.test.file_explorer_sdk.service.AuthSdk
import juanocampo.test.file_explorer_sdk.service.Client
import juanocampo.test.file_explorer_sdk.service.DropboxClientFactory
import juanocampo.test.file_explorer_sdk.service.sdk.AuthSdkImp
import juanocampo.test.file_explorer_sdk.service.sdk.ClientImp
import javax.inject.Singleton

@Module
class FileSdkModule {

    @Singleton
    @Provides
    fun providesAuthSdk(context: Context): AuthSdk = AuthSdkImp(context)

    @Provides
    fun providesClient(context: Context): Client = ClientImp(context)
}