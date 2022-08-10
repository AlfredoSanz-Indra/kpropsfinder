package es.kprops.data.commands.ant.repository

import es.kprops.core.Constants
import es.kprops.data.commands.ant.api.GitPullCommandApi

/**
 * @author Alfredo Sanz
 * @time 2022
 */
class GitPullCommandApiImpl : GitPullCommandApi {

    override fun doAction() {
        val route: String =   Constants.BAT_FILE_SOURCE + Constants.BAT_FILE_gotopull
        val command = "cmd /c start $route"
        Runtime.getRuntime().exec(command)
    }
}