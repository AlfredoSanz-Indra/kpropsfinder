package es.kprops.data.repository.ant

import es.kprops.core.di.ApiFactory
import es.kprops.data.commands.ant.api.GitLogCommandApi
import es.kprops.data.commands.ant.api.GitPullCommandApi
import es.kprops.data.commands.ant.entity.GitResultEntity
import es.kprops.data.commands.ant.entity.toGitResult
import es.kprops.domain.model.ant.AntAction
import es.kprops.domain.model.ant.AntResult
import es.kprops.domain.repository.ant.GitCommand

/**
 * @author Alfredo Sanz
 * @time 2022
 */
class GitCommandImpl: GitCommand {

    private val pullCommandApi: GitPullCommandApi = ApiFactory.getPullCommandApi()
    private val GitLogCommandApi: GitLogCommandApi = ApiFactory.getGitLogCommandApi()

    override fun pullAll(action: AntAction): AntResult {
        println("GitCommandImpl - pullAll")
        try {
            this.pullCommandApi.doAction()
        }
        catch(e: Exception) {
            return GitResultEntity("KO").toGitResult()
        }
        return GitResultEntity("OK").toGitResult()
    }

    override fun gitLog(action: AntAction): AntResult {
        return GitResultEntity("Not Implemented yet").toGitResult()
    }
}