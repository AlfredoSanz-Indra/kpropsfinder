package es.kprops.data.repository.git

import es.kprops.core.di.ApiFactory
import es.kprops.data.commands.git.api.GitPullCommandApi
import es.kprops.data.commands.git.entity.GitResultEntity
import es.kprops.data.commands.git.entity.toGitResult
import es.kprops.domain.model.git.GitAction
import es.kprops.domain.model.git.GitResult
import es.kprops.domain.repository.git.GitCommand

/**
 * @author Alfredo Sanz
 * @time 2022
 */
class GitCommandImpl: GitCommand {

    private val pullCommandApi: GitPullCommandApi = ApiFactory.getPullCommandApi()

    override fun pullAll(action: GitAction): GitResult {
        println("pullAll")
        try {
            this.pullCommandApi.doAction()
        }
        catch(e: Exception) {
            return GitResultEntity("KO").toGitResult()
        }
        return GitResultEntity("OK").toGitResult()
    }
}