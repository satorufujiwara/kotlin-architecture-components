package jp.satorufujiwara.kotlin.di

import dagger.Module
import dagger.Provides
import jp.satorufujiwara.kotlin.AppLifecycleCallbacks
import jp.satorufujiwara.kotlin.data.di.DataModule
import javax.inject.Singleton

@Module(includes = [DataModule::class])
internal object AppModule {

    @Singleton
    @Provides
    @JvmStatic
    fun provideAppLifecycleCallbacks(): AppLifecycleCallbacks = ReleaseAppLifecycleCallbacks()

}