package es.kprops.data.commands.ant.repository

import es.kprops.core.Constants
import es.kprops.data.commands.ant.api.LaunchKenobiInstallCommandApi

/**
 * @author Alfredo Sanz
 * @time 2022
 */
class LaunchKenobiInstallCommandApiImpl : LaunchKenobiInstallCommandApi {

    override fun doAction() {
        val route: String =   Constants.BAT_FILE_SOURCE + Constants.BAT_FILE_gotoinstall
        val command = "cmd /c start $route"
        Runtime.getRuntime().exec(command)
    }
}