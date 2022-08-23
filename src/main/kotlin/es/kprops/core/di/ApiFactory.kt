package es.kprops.core.di

import es.kprops.data.commands.ant.repository.*

/**
 * @author Alfredo Sanz
 * @time 2022
 */
object  ApiFactory {

    private lateinit var runCommandApi: RunCommandApiImpl

    fun getRunCommandApi(): RunCommandApiImpl {
        if (!this::runCommandApi.isInitialized) {
            this.runCommandApi = RunCommandApiImpl()
        }
         return this.runCommandApi
    }
}