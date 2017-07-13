package jp.satorufujiwara.kotlin

import dagger.android.support.DaggerApplication
import jp.satorufujiwara.kotlin.di.DaggerAppComponent
import jp.satorufujiwara.kotlin.di.applyAutoInjector
import jp.satorufujiwara.kotlin.ui.app.UserViewModel
import javax.inject.Inject

class App : DaggerApplication() {

  @Inject lateinit var appLifecycleCallbacks: AppLifecycleCallbacks
  @Inject lateinit var userViewModel: UserViewModel

  override fun applicationInjector() = DaggerAppComponent.builder()
      .application(this)
      .build()

  override fun onCreate() {
    super.onCreate()
    applyAutoInjector()
    appLifecycleCallbacks.onCreate(this)
    userViewModel.loginUserId.value = "satorufujiwara"
  }

  override fun onTerminate() {
    appLifecycleCallbacks.onTerminate(this)
    super.onTerminate()
  }

}