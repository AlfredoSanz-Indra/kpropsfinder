package es.kprops.domain.usecases.antcases

import es.kprops.core.di.RepoFactory
import es.kprops.domain.api.antcases.AntUseCase
import es.kprops.domain.model.ant.AntAction
import es.kprops.domain.model.ant.AntResult
import es.kprops.domain.repository.ant.GitCommand
import es.kprops.domain.repository.ant.KenobiCommand

/**
 * @author Alfredo Sanz
 * @time 2022
 */
class AntUseCaseImpl : AntUseCase {

    private val gitCommand: GitCommand = RepoFactory.getGitCommandRepo()
    private val kenobiCommand: KenobiCommand = RepoFactory.getKenobiCommandRepo()

    override fun gitPullAll() {
        println("gitPullAllKenobi")
        val r: AntResult =  this.gitCommand.pullAll(AntAction("pull All Kenobi"))
        println(r.result)
    }


    override fun openKenobiCmd() {
        println("openKenobiCmd")
        val r: AntResult = this.kenobiCommand.openKenobiCmd(AntAction("Open console Kenoby path"))
        println("openKenobiCmd result=${r.result}")

    }
}