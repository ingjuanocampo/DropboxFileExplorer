package juanocampo.test.domain.di

import dagger.Module
import dagger.Provides
import juanocampo.test.domain.repository.FileRepository
import juanocampo.test.domain.repository.UserRepository
import juanocampo.test.domain.usecase.DownLoadFileUseCase
import juanocampo.test.domain.usecase.LoadFileListUseCase
import juanocampo.test.domain.usecase.LoadUserInformationUseCase
import juanocampo.test.domain.usecase.LoginUseCase

@Module
class DomainModule {

    @Provides
    fun providesLoginUseCase(userRepository: UserRepository) = LoginUseCase(userRepository)

    @Provides
    fun providesLoadUserInformationUseCase(userRepository: UserRepository) = LoadUserInformationUseCase(userRepository)

    @Provides
    fun providesLoadFileListUseCase(fileRepository: FileRepository) = LoadFileListUseCase(fileRepository)

    @Provides
    fun providesDownLoadFileUseCase(fileRepository: FileRepository) = DownLoadFileUseCase(fileRepository)
}