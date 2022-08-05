package es.kprops.core.di

import es.kprops.data.repository.ant.GitCommandImpl
import es.kprops.data.repository.ant.KenobiCommandImpl

/**
 * @author Alfredo Sanz
 * @time 2022
 */
object  RepoFactory {

    private lateinit var gitCommand: GitCommandImpl
    private lateinit var kenobiCommand: KenobiCommandImpl

    fun getGitCommandRepo(): GitCommandImpl {
        if (!this::gitCommand.isInitialized) {
            this.gitCommand = GitCommandImpl()
        }
        return this.gitCommand
    }

    fun getKenobiCommandRepo(): KenobiCommandImpl {
        if (!this::kenobiCommand.isInitialized) {
            this.kenobiCommand = KenobiCommandImpl()
        }
        return this.kenobiCommand
    }
}