package juanocampo.test.cache.di

import dagger.Module
import dagger.Provides
import juanocampo.test.cache.LocalDataSourceImpl
import juanocampo.test.data.sources.LocalDataSource
import javax.inject.Singleton

@Module
class LocalModule {

    @Singleton
    @Provides
    fun providesLocalDataSource(): LocalDataSource = LocalDataSourceImpl()

}