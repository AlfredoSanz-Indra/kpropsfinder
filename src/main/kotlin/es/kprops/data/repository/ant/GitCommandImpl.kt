package es.kprops.data.repository.ant

import es.kprops.core.di.DataFactory
import es.kprops.data.commands.api.CommandApi
import es.kprops.data.commands.api.Commands
import es.kprops.data.commands.entity.GitResultEntity
import es.kprops.data.commands.entity.toGitResult
import es.kprops.domain.model.ant.AntAction
import es.kprops.domain.model.ant.AntResult
import es.kprops.domain.repository.ant.GitCommand

/**
 * @author Alfredo Sanz
 * @time 2022
 */
class GitCommandImpl: GitCommand {

    private val runCommandApi: CommandApi = DataFactory.getRunCommandApi()

    override fun pullAll(action: AntAction): AntResult {
        println("GitCommandImpl - pullAll")
        try {
            this.runCommandApi.doAction(Commands.GIT_PULL_ALL)
        }
        catch(e: Exception) {
            return GitResultEntity("KO").toGitResult()
        }
        return GitResultEntity("OK").toGitResult()
    }

    override fun gitLog(action: AntAction): AntResult {
        println("GitCommandImpl - Log")
        try {
            this.runCommandApi.doAction(Commands.GIT_LOG)
        }
        catch(e: Exception) {
            return GitResultEntity("KO").toGitResult()
        }
        return GitResultEntity("OK").toGitResult()
    }
}