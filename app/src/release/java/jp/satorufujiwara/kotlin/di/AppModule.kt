package jp.satorufujiwara.kotlin.di

import dagger.Module
import dagger.Provides
import jp.satorufujiwara.kotlin.AppLifecycleCallbacks
import jp.satorufujiwara.kotlin.data.di.DataModule
import javax.inject.Singleton

@Module(includes = arrayOf(DataModule::class))
class AppModule {

    @Singleton @Provides
    fun provideAppLifecycleCallbacks(): AppLifecycleCallbacks = ReleaseAppLifecycleCallbacks()

}