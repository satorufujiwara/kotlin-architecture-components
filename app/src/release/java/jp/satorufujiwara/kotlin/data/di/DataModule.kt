package jp.satorufujiwara.kotlin.data.di

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import jp.satorufujiwara.kotlin.data.api.GitHubService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class DataModule {

  @Singleton @Provides
  fun provideMoshi() = Moshi.Builder()
      .add(KotlinJsonAdapterFactory())
      .build()


  @Singleton @Provides
  fun providesOkHttp(): OkHttpClient = OkHttpClient.Builder()
      .build()

  @Singleton @Provides
  fun provideRetrofit(oktHttpClient: OkHttpClient, moshi: Moshi): Retrofit
      = Retrofit.Builder()
      .client(oktHttpClient)
      .baseUrl("https://api.github.com")
      .addConverterFactory(MoshiConverterFactory.create(moshi))
      .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
      .build()

  @Singleton @Provides
  fun provideGitHubService(retrofit: Retrofit): GitHubService
      = retrofit.create(GitHubService::class.java)

}