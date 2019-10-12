package juanocampo.test.cache.di

import dagger.Module
import dagger.Provides
import juanocampo.test.cache.UserLocalDataSourceImpl
import juanocampo.test.data.sources.UserLocalDataSource
import javax.inject.Singleton

@Module
class LocalModule {

    @Singleton
    @Provides
    fun providesLocalDataSource(): UserLocalDataSource = UserLocalDataSourceImpl()

}