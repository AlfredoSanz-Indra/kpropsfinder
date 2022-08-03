package es.kprops.core.di

import es.kprops.data.commands.git.repository.GitPullCommandApiImpl
import es.kprops.data.repository.git.GitCommandImpl

object  RepoFactory {

    private lateinit var gitCommand: GitCommandImpl

    fun getGitCommandRepo(): GitCommandImpl {
        if (!this::gitCommand.isInitialized) {
            this.gitCommand = GitCommandImpl()
        }
        return return this.gitCommand
    }
}