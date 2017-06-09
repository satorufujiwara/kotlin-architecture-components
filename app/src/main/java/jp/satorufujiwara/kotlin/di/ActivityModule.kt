package jp.satorufujiwara.kotlin.di

import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import jp.satorufujiwara.kotlin.ui.main.MainActivity
import jp.satorufujiwara.kotlin.ui.main.di.MainModule

@Module
internal abstract class ActivityModule {

  @Binds
  abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

  @ContributesAndroidInjector(modules = arrayOf(MainModule::class))
  internal abstract fun contributeMainActivity(): MainActivity

}