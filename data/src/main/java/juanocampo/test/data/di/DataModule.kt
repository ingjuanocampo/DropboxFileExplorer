package juanocampo.test.data.di

import dagger.Module
import dagger.Provides
import juanocampo.test.data.UserRepositoryImpl
import juanocampo.test.data.mapper.RepositoryMapper
import juanocampo.test.data.mapper.RepositoryMapperImpl
import juanocampo.test.data.sources.LocalDataSource
import juanocampo.test.data.sources.RemoteDataSource
import juanocampo.test.domain.entity.repository.UserRepository

@Module
class DataModule {

    @Provides
    fun providesUserRepository(localDataSource: LocalDataSource,
                               remoteDataSource: RemoteDataSource,
                               mapper: RepositoryMapper
    ): UserRepository = UserRepositoryImpl(localDataSource, remoteDataSource, mapper)

    @Provides
    fun providesRepositoryMapper(): RepositoryMapper = RepositoryMapperImpl()

}