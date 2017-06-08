package jp.satorufujiwara.kotlin.data.repository

import jp.satorufujiwara.kotlin.data.api.GitHubService
import javax.inject.Inject

class GitHubRepository @Inject constructor(private val gitHubService: GitHubService) {

    fun loadRepos(owner: String) = gitHubService.listRepos(owner)

}
