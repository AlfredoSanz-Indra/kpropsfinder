package es.kprops.data.repository.ant

import es.kprops.core.Constants
import es.kprops.core.di.ApiFactory
import es.kprops.data.commands.ant.api.CommandApi
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

    private val runCommandApi: CommandApi = ApiFactory.getRunCommandApi()

    override fun pullAll(action: AntAction): AntResult {
        println("GitCommandImpl - pullAll")
        try {
            val route: String =   Constants.BAT_FILE_SOURCE + Constants.BAT_FILE_gotopull
            val command = "cmd /c start $route"
            this.runCommandApi.doAction(command)
        }
        catch(e: Exception) {
            return GitResultEntity("KO").toGitResult()
        }
        return GitResultEntity("OK").toGitResult()
    }

    override fun gitLog(action: AntAction): AntResult {
        println("GitCommandImpl - Log")
        try {
            val route: String =   Constants.BAT_FILE_SOURCE + Constants.BAT_FILE_gotolog
            val command = "cmd /c start $route"
            this.runCommandApi.doAction(command)
        }
        catch(e: Exception) {
            return GitResultEntity("KO").toGitResult()
        }
        return GitResultEntity("OK").toGitResult()
    }
}