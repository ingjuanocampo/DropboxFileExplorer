package juanocampo.test.presentation.di

import dagger.Module
import dagger.Provides
import juanocampo.test.domain.entity.usecase.LoadUserInformationUseCase
import juanocampo.test.domain.entity.usecase.LoginUseCase
import juanocampo.test.presentation.model.FileExplorerModel
import juanocampo.test.presentation.model.FileExplorerModelImpl
import juanocampo.test.presentation.model.LoginModel
import juanocampo.test.presentation.model.LoginModelImpl

@Module
class PresentationModelModule {

    @Provides
    fun providesFileExplorerModel(): FileExplorerModel  = FileExplorerModelImpl()

    @Provides
    fun providesLoginModel(loginUseCase: LoginUseCase, loadUserInformationUseCase: LoadUserInformationUseCase): LoginModel = LoginModelImpl(loginUseCase, loadUserInformationUseCase)

}