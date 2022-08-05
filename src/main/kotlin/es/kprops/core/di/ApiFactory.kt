package es.kprops.core.di

import es.kprops.data.commands.ant.repository.GitPullCommandApiImpl
import es.kprops.data.commands.ant.repository.OpenKenobiCommandApiImpl

/**
 * @author Alfredo Sanz
 * @time 2022
 */
object  ApiFactory {

    private lateinit var pullCommand: GitPullCommandApiImpl
    private lateinit var openKenobiCommandApi: OpenKenobiCommandApiImpl

    fun getPullCommandApi(): GitPullCommandApiImpl {
        if (!this::pullCommand.isInitialized) {
            this.pullCommand = GitPullCommandApiImpl()
        }
         return this.pullCommand
    }

    fun getOpenKenobiCommandApi(): OpenKenobiCommandApiImpl {
        if (!this::openKenobiCommandApi.isInitialized) {
            this.openKenobiCommandApi = OpenKenobiCommandApiImpl()
        }
        return this.openKenobiCommandApi
    }
}