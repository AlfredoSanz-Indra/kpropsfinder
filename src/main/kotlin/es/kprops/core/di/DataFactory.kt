package es.kprops.core.di

import es.kprops.data.commands.api.CommandApi
import es.kprops.data.commands.exec.RunCommandApiImpl
import es.kprops.data.datasource.api.PropDS
import es.kprops.data.datasource.db.PropDSImpl

/**
 * @author Alfredo Sanz
 * @time 2022
 */
object  DataFactory {

    private lateinit var runCommandApi: CommandApi
    private lateinit var propDS: PropDS

    fun getRunCommandApi(): CommandApi {
        if (!this::runCommandApi.isInitialized) {
            this.runCommandApi = RunCommandApiImpl()
        }
        return this.runCommandApi
    }

    fun getPropDS(): PropDS {
        if (!this::propDS.isInitialized) {
            this.propDS = PropDSImpl()
        }
        return this.propDS
    }
}