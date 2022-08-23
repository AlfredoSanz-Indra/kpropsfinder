package es.kprops.data.commands.ant.repository

import es.kprops.data.commands.ant.api.CommandApi

/**
 * @author Alfredo Sanz
 * @time 2022
 */
class RunCommandApiImpl: CommandApi {

    override fun doAction(command: String) {

        Runtime.getRuntime().exec(command)
    }
}