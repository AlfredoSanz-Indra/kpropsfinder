package es.kprops.data.commands.ant.repository

import es.kprops.core.Constants
import es.kprops.data.commands.ant.api.GitPullCommandApi

/**
 * @author Alfredo Sanz
 * @time 2022
 */
class GitPullCommandApiImpl : GitPullCommandApi {

    override fun doAction() {
        println("GitPullCommandApiImpl - doAction")

        val route: String =   Constants.BAT_FILE_SOURCE + Constants.BAT_FILE_gotopull
        println("GitPullCommandApiImpl - doAction route: $route ")

        val command = "cmd /c start $route"
        println("GitPullCommandApiImpl - doAction executing command: $command")
        Runtime.getRuntime().exec(command)
    }
}