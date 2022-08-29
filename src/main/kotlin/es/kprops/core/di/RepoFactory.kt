package es.kprops.core.di

import es.kprops.data.repository.ant.GitCommandImpl
import es.kprops.data.repository.ant.KenobiCommandImpl
import es.kprops.domain.repository.ant.GitCommand
import es.kprops.domain.repository.ant.KenobiCommand

/**
 * @author Alfredo Sanz
 * @time 2022
 */
object  RepoFactory {

    private lateinit var gitCommand: GitCommandImpl
    private lateinit var kenobiCommand: KenobiCommandImpl

    fun getGitCommandRepo(): GitCommand {
        if (!this::gitCommand.isInitialized) {
            this.gitCommand = GitCommandImpl()
        }
        return this.gitCommand
    }

    fun getKenobiCommandRepo(): KenobiCommand {
        if (!this::kenobiCommand.isInitialized) {
            this.kenobiCommand = KenobiCommandImpl()
        }
        return this.kenobiCommand
    }
}