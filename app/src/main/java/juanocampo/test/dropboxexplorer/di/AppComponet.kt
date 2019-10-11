package juanocampo.test.dropboxexplorer.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import juanocampo.test.dropboxexplorer.App


@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class])
interface AppComponent {


    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)

}