package juanocampo.test.presentation.di

import dagger.Module
import dagger.Provides
import dagger.Reusable
import juanocampo.test.presentation.mapper.UIMapper
import juanocampo.test.presentation.model.FileExplorerModel
import juanocampo.test.presentation.model.LoginModel
import juanocampo.test.presentation.presenter.FileExplorerPresenter
import juanocampo.test.presentation.presenter.LoginPresenter
import juanocampo.test.presentation.presenter.mapper.UIMapperImpl

@Module
class PresentationModule {

    @Provides
    @LoginScope
    fun providesLoginPresenter(loginModel: LoginModel) = LoginPresenter(loginModel)

    @Provides
    @FileExplorerScope
    fun providesFileExplorerPresenter(fileExplorerModel: FileExplorerModel, uiMapper: UIMapper) =
        FileExplorerPresenter(fileExplorerModel, uiMapper)

    @Provides
    @Reusable
    fun providesUIMapper(): UIMapper = UIMapperImpl()

}