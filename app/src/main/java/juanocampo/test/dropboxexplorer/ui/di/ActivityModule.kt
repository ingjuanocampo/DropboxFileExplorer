package juanocampo.test.dropboxexplorer.ui.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import juanocampo.test.dropboxexplorer.ui.FileExplorerActivity
import juanocampo.test.dropboxexplorer.ui.LoginActivity
import juanocampo.test.presentation.di.ActivityScope
import juanocampo.test.presentation.di.PresentationModule

@Module
abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [PresentationModule::class])
    abstract fun loginActivty(): LoginActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [PresentationModule::class])
    abstract fun fileExplorerActivity(): FileExplorerActivity


}