package juanocampo.test.domain.entity.di

import dagger.Module
import dagger.Provides
import juanocampo.test.domain.entity.repository.UserRepository
import juanocampo.test.domain.entity.usecase.LoadUserInformationUseCase
import juanocampo.test.domain.entity.usecase.LoginUseCase

@Module
class DomainModule {

    @Provides
    fun providesLoginUseCase(userRepository: UserRepository) = LoginUseCase(userRepository)

    @Provides
    fun providesLoadUserInformationUseCase(userRepository: UserRepository) = LoadUserInformationUseCase(userRepository)
}