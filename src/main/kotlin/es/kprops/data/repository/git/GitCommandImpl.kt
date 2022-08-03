package es.kprops.data.repository.git

import es.kprops.core.di.ApiFactory
import es.kprops.data.commands.git.api.GitPullCommandApi
import es.kprops.data.commands.git.entity.GitResultEntity
import es.kprops.data.commands.git.entity.toGitResult
import es.kprops.data.commands.git.repository.GitPullCommandApiImpl
import es.kprops.domain.model.git.GitAction
import es.kprops.domain.model.git.GitResult
import es.kprops.domain.repository.git.GitCommand

class GitCommandImpl: GitCommand {

    private val pullCommandApi: GitPullCommandApi = ApiFactory.getPullCommandApi()

    override fun pullAll(action: GitAction): GitResult {

       // this.pullCommandApi.doAction()
        println("pullAll")
        return GitResultEntity("OK").toGitResult()
    }
}