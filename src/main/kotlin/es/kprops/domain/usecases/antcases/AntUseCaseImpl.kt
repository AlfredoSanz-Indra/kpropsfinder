package es.kprops.domain.usecases.antcases

import es.kprops.core.di.RepoFactory
import es.kprops.domain.api.antcases.AntUseCase
import es.kprops.domain.model.git.GitAction
import es.kprops.domain.model.git.GitResult
import es.kprops.domain.repository.git.GitCommand

/**
 * @author Alfredo Sanz
 * @time 2022
 */
class AntUseCaseImpl : AntUseCase {

    private val gitCommand: GitCommand = RepoFactory.getGitCommandRepo()

    override fun gitPullAll() {
        println("gitPullAllKenobi")
        val r: GitResult =  this.gitCommand.pullAll(GitAction("pull All Kenobi"))
        println(r.result)
    }
}