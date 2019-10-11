package juanocampo.test.dropboxexplorer.ui.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import juanocampo.test.dropboxexplorer.ui.FileExplorerActivity
import juanocampo.test.dropboxexplorer.ui.LoginActivity
import juanocampo.test.presentation.di.FileExplorerScope
import juanocampo.test.presentation.di.LoginScope
import juanocampo.test.presentation.di.PresentationModule

@Module
abstract class ActivityModule {

    @LoginScope
    @ContributesAndroidInjector(modules = [PresentationModule::class])
    abstract fun loginActivty(): LoginActivity

    @FileExplorerScope
    @ContributesAndroidInjector(modules = [PresentationModule::class])
    abstract fun fileExplorerActivity(): FileExplorerActivity


}