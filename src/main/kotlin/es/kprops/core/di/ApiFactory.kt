package es.kprops.core.di

import es.kprops.data.commands.git.repository.GitPullCommandApiImpl

/**
 * @author Alfredo Sanz
 * @time 2022
 */
object  ApiFactory {

    private lateinit var pullCommand: GitPullCommandApiImpl

    fun getPullCommandApi(): GitPullCommandApiImpl {
        if (!this::pullCommand.isInitialized) {
            this.pullCommand = GitPullCommandApiImpl()
        }
         return this.pullCommand
    }
}