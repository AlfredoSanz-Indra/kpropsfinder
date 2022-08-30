package es.kprops.core.di

import es.kprops.data.commands.ant.api.CommandApi
import es.kprops.data.commands.ant.repository.RunCommandApiImpl

/**
 * @author Alfredo Sanz
 * @time 2022
 */
object  ApiFactory {

    private lateinit var runCommandApi: CommandApi

    fun getRunCommandApi(): CommandApi {
        if (!this::runCommandApi.isInitialized) {
            this.runCommandApi = RunCommandApiImpl()
        }
         return this.runCommandApi
    }
}