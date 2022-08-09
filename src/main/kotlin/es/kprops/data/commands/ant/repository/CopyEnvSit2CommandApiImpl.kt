package es.kprops.data.commands.ant.repository

import es.kprops.core.Constants
import es.kprops.data.commands.ant.api.CopyEnvSit2CommandApi

/**
 * @author Alfredo Sanz
 * @time 2022
 */
class CopyEnvSit2CommandApiImpl : CopyEnvSit2CommandApi {

    override fun doAction() {
        println("doAction")

        val route: String =   Constants.BAT_FILE_SOURCE + Constants.BAT_FILE_gotokenobi
        println("doAction route: $route ")

        val command = "cmd /c start $route"
        println("doAction executing command: $command")
        Runtime.getRuntime().exec(command)
    }
}