package es.kprops.core.di

import es.kprops.data.repository.git.GitCommandImpl

/**
 * @author Alfredo Sanz
 * @time 2022
 */
object  RepoFactory {

    private lateinit var gitCommand: GitCommandImpl

    fun getGitCommandRepo(): GitCommandImpl {
        if (!this::gitCommand.isInitialized) {
            this.gitCommand = GitCommandImpl()
        }
        return this.gitCommand
    }
}