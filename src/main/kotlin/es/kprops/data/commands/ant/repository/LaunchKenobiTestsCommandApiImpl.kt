package es.kprops.data.commands.ant.repository

import es.kprops.core.Constants
import es.kprops.data.commands.ant.api.LaunchKenobiTestsCommandApi

/**
 * @author Alfredo Sanz
 * @time 2022
 */
class LaunchKenobiTestsCommandApiImpl : LaunchKenobiTestsCommandApi {

    override fun doAction() {
        val route: String =   Constants.BAT_FILE_SOURCE + Constants.BAT_FILE_gototest
        val command = "cmd /c start $route"
        Runtime.getRuntime().exec(command)
    }
}