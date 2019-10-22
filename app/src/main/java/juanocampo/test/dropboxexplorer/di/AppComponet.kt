package juanocampo.test.dropboxexplorer.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import juanocampo.test.cache.di.LocalModule
import juanocampo.test.data.di.DataModule
import juanocampo.test.domain.di.DomainModule
import juanocampo.test.dropboxexplorer.App
import juanocampo.test.dropboxexplorer.ui.di.ActivityModule
import juanocampo.test.file_explorer_sdk.di.RemoteModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    ActivityModule::class,
    DomainModule::class,
    DataModule::class,
    RemoteModule::class,
    LocalModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    /**
     * Do not expose any provides here from another layer.
     *
     */

    fun inject(app: App)
}