package juanocampo.test.domain.entity.di

import dagger.Module
import dagger.Provides
import juanocampo.test.domain.entity.repository.FileRepository
import juanocampo.test.domain.entity.repository.UserRepository
import juanocampo.test.domain.entity.usecase.DownLoadFileUseCase
import juanocampo.test.domain.entity.usecase.LoadFileListUseCase
import juanocampo.test.domain.entity.usecase.LoadUserInformationUseCase
import juanocampo.test.domain.entity.usecase.LoginUseCase

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