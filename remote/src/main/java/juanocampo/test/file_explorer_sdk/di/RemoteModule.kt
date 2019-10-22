package juanocampo.test.file_explorer_sdk.di

import dagger.Module
import dagger.Provides
import juanocampo.test.data.sources.FileRemoteDataSource
import juanocampo.test.data.sources.UserRemoteDataSource
import juanocampo.test.file_explorer_sdk.FileRemoteDataSourceImpl
import juanocampo.test.file_explorer_sdk.Mapper
import juanocampo.test.file_explorer_sdk.UserRemoteDataSourceImp
import juanocampo.test.file_explorer_sdk.service.AuthSdk
import juanocampo.test.file_explorer_sdk.service.Client
import juanocampo.test.file_explorer_sdk.service.di.FileSdkModule
import juanocampo.test.file_explorer_sdk.service.mapper.MapperImpl

@Module(includes = [FileSdkModule::class])
class RemoteModule {

    @Provides
    fun providesRemoteDataSourceImp(authSdk: AuthSdk, client: Client): UserRemoteDataSource = UserRemoteDataSourceImp(authSdk, client)

    @Provides
    fun providesMapper(): Mapper = MapperImpl()

    @Provides
    fun providesFileRemoteDataSource(client: Client, mapper: Mapper): FileRemoteDataSource = FileRemoteDataSourceImpl(client, mapper)

}