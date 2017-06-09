package jp.satorufujiwara.kotlin.data.api

import io.reactivex.Flowable
import jp.satorufujiwara.kotlin.data.model.Repo
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {

  @GET("/users/{user}/repos")
  fun listRepos(@Path("user") user: String): Flowable<List<Repo>>

}