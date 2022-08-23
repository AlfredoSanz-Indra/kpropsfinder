package es.kprops.data.commands.ant.repository

import es.kprops.core.Constants
import es.kprops.data.commands.ant.api.CommandApi
import es.kprops.data.commands.ant.api.Commands

/**
 * @author Alfredo Sanz
 * @time 2022
 */
class RunCommandApiImpl: CommandApi {

    override fun doAction(commandAction: Commands) {

        val route: String = getRoute(commandAction)
        val command = "cmd /c start $route"
        Runtime.getRuntime().exec(command)
    }


    private fun getRoute(command: Commands): String {

        var result = Constants.BAT_FILE_SOURCE

        when(command.name) {
            Commands.OPEN_KENOBI_CMD.name -> result += Constants.BAT_FILE_gotokenobi
            Commands.START_KENOBI_SERVER.name -> result += Constants.BAT_FILE_kenobiserver
            Commands.BUILD_PROD.name -> result += Constants.BAT_FILE_gotokenobi_build
            Commands.GIT_LOG.name -> result += Constants.BAT_FILE_gotolog
            Commands.COPY_ENV_PPRD1.name -> result += Constants.BAT_FILE_gotopprd1
            Commands.COPY_ENV_SIT2.name -> result += Constants.BAT_FILE_gotosit2
            Commands.GIT_PULL_ALL.name -> result += Constants.BAT_FILE_gotopull
            Commands.LAUNCH_TESTS.name -> result += Constants.BAT_FILE_gototest
            Commands.MAKE_INSTALL.name -> result += Constants.BAT_FILE_gotoinstall
        }

        return result
    }
}