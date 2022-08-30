package es.kprops.core.di

import es.kprops.data.repository.ant.GitCommandImpl
import es.kprops.data.repository.ant.KenobiCommandImpl
import es.kprops.data.repository.system.SystemCommandImpl
import es.kprops.domain.repository.ant.GitCommand
import es.kprops.domain.repository.ant.KenobiCommand
import es.kprops.domain.repository.system.SystemCommand

/**
 * @author Alfredo Sanz
 * @time 2022
 */
object  RepoFactory {

    private lateinit var gitCommand: GitCommand
    private lateinit var kenobiCommand: KenobiCommand
    private lateinit var SystemCommand: SystemCommand

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

    fun getSystemCommandRepo(): SystemCommand {
        if (!this::SystemCommand.isInitialized) {
            this.SystemCommand = SystemCommandImpl()
        }
        return this.SystemCommand
    }
}