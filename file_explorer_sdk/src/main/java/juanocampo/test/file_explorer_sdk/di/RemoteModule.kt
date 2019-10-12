package juanocampo.test.file_explorer_sdk.di

import android.content.Context
import dagger.Module
import dagger.Provides
import juanocampo.test.data.sources.RemoteDataSource
import juanocampo.test.file_explorer_sdk.RemoteDataSourceImp

@Module
class RemoteModule {

    @Provides
    fun providesRemoteDataSourceImp(context: Context): RemoteDataSource = RemoteDataSourceImp(context)
}