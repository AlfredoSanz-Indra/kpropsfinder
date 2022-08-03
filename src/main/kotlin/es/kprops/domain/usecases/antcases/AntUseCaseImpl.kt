package es.kprops.domain.usecases.antcases

import es.kprops.core.di.RepoFactory
import es.kprops.domain.api.antcases.AntUseCase
import es.kprops.domain.model.git.GitAction
import es.kprops.domain.repository.git.GitCommand

class AntUseCaseImpl : AntUseCase {

    private val gitCommand: GitCommand = RepoFactory.getGitCommandRepo()

    override fun gitPullAllKenobi() {
        println("gitPullAllKenobi")
        this.gitCommand.pullAll(GitAction("pull All Kenobi"))
    }
}