package jp.satorufujiwara.kotlin

import dagger.android.support.DaggerApplication
import jp.satorufujiwara.kotlin.di.DaggerAppComponent
import jp.satorufujiwara.kotlin.di.applyAutoInjector
import javax.inject.Inject

class App : DaggerApplication() {

  @Inject lateinit var appLifecycleCallbacks: AppLifecycleCallbacks

  override fun applicationInjector() = DaggerAppComponent.builder()
      .application(this)
      .build()

  override fun onCreate() {
    super.onCreate()
    applyAutoInjector()
    appLifecycleCallbacks.onCreate(this)
  }

  override fun onTerminate() {
    appLifecycleCallbacks.onTerminate(this)
    super.onTerminate()
  }

}