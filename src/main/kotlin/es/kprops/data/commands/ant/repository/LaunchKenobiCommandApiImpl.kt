package es.kprops.data.commands.ant.repository

import es.kprops.core.Constants
import es.kprops.data.commands.ant.api.LaunchKenobiCommandApi

/**
 * @author Alfredo Sanz
 * @time 2022
 */
class LaunchKenobiCommandApiImpl : LaunchKenobiCommandApi {

    override fun doAction() {
        val route: String =   Constants.BAT_FILE_SOURCE + Constants.BAT_FILE_kenobiserver
        val command = "cmd /c start $route"
        Runtime.getRuntime().exec(command)
    }
}