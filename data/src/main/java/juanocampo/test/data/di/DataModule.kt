package juanocampo.test.data.di

import dagger.Module
import dagger.Provides
import juanocampo.test.data.FileRepositoryImpl
import juanocampo.test.data.UserRepositoryImpl
import juanocampo.test.data.mapper.RepositoryMapper
import juanocampo.test.data.mapper.RepositoryMapperImpl
import juanocampo.test.data.sources.FileRemoteDataSource
import juanocampo.test.data.sources.UserLocalDataSource
import juanocampo.test.data.sources.UserRemoteDataSource
import juanocampo.test.domain.entity.repository.FileRepository
import juanocampo.test.domain.entity.repository.UserRepository

@Module
class DataModule {

    @Provides
    fun providesUserRepository(localDataSource: UserLocalDataSource,
                               remoteDataSource: UserRemoteDataSource,
                               mapper: RepositoryMapper
    ): UserRepository = UserRepositoryImpl(localDataSource, remoteDataSource, mapper)

    @Provides
    fun providesRepositoryMapper(): RepositoryMapper = RepositoryMapperImpl()

    @Provides
    fun providesFileRepository(localDataSource: FileRemoteDataSource,
                               mapper: RepositoryMapper): FileRepository = FileRepositoryImpl(localDataSource, mapper)

}