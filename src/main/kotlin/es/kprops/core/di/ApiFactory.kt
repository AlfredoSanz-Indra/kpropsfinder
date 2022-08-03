package es.kprops.core.di

import es.kprops.data.commands.git.repository.GitPullCommandApiImpl

object  ApiFactory {

    private lateinit var pullCommand: GitPullCommandApiImpl

    fun getPullCommandApi(): GitPullCommandApiImpl {
        if (!this::pullCommand.isInitialized) {
            this.pullCommand = GitPullCommandApiImpl()
        }
        return return this.pullCommand
    }
}