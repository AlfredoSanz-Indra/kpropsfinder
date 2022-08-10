package es.kprops.data.commands.ant.repository

import es.kprops.core.Constants
import es.kprops.data.commands.ant.api.BuildProKenobiCommandApi

/**
 * @author Alfredo Sanz
 * @time 2022
 */
class BuildProKenobiCommandApiImpl : BuildProKenobiCommandApi {

    override fun doAction() {
        val route: String =   Constants.BAT_FILE_SOURCE + Constants.BAT_FILE_gotokenobi_build
        val command = "cmd /c start $route"
        Runtime.getRuntime().exec(command)
    }
}