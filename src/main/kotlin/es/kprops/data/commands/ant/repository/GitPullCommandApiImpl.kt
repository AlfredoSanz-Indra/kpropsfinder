package es.kprops.data.commands.ant.repository

import es.kprops.core.Constants
import es.kprops.data.commands.ant.api.GitPullCommandApi

/**
 * @author Alfredo Sanz
 * @time 2022
 */
class GitPullCommandApiImpl : GitPullCommandApi {

    override fun doAction() {
        println("doAction")

        val route: String =   Constants.BAT_FILE_SOURCE + Constants.BAT_FILE_gotopull
        println("doAction route: $route ")

        val command: String = "cmd /c start $route"
        println("doAction executing command: $command")
        Runtime.getRuntime().exec(command)
    }
}