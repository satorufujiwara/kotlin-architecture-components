package jp.satorufujiwara.kotlin.di.module

import android.arch.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import jp.satorufujiwara.kotlin.di.ViewModelKey
import jp.satorufujiwara.kotlin.ui.main.MainFragment
import jp.satorufujiwara.kotlin.ui.main.MainViewModel

@Module
internal abstract class MainModule {

  @Binds
  @IntoMap
  @ViewModelKey(MainViewModel::class)
  abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

  @ContributesAndroidInjector
  abstract fun contributeMainFragment(): MainFragment

}