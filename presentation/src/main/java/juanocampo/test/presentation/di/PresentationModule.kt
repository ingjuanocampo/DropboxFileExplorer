package juanocampo.test.presentation.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.Reusable
import juanocampo.test.presentation.mapper.UIMapper
import juanocampo.test.presentation.model.FileExplorerModel
import juanocampo.test.presentation.model.LoginModel
import juanocampo.test.presentation.presenter.FileExplorerPresenter
import juanocampo.test.presentation.presenter.LoginPresenter
import juanocampo.test.presentation.presenter.mapper.UIMapperImpl

@Module(includes = [PresentationModelModule::class])
class PresentationModule {

    @Provides
    @ActivityScope
    fun providesLoginPresenter(loginModel: LoginModel) = LoginPresenter(loginModel)

    @Provides
    @ActivityScope
    fun providesFileExplorerPresenter(context: Context, fileExplorerModel: FileExplorerModel, uiMapper: UIMapper) =
        FileExplorerPresenter(context, fileExplorerModel, uiMapper)

    @Provides
    @Reusable
    fun providesUIMapper(): UIMapper = UIMapperImpl()

}