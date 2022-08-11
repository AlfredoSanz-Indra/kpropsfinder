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
        println("AntUseCase - gitPullAllKenobi")
        val r: AntResult =  this.gitCommand.pullAll(AntAction("pull All Kenobi"))
        println("\"AntUseCase - gitPullAllKenobi  result=${r.result}")
    }


    override fun openKenobiCmd() {
        println("AntUseCase - openKenobiCmd")
        val r: AntResult = this.kenobiCommand.openKenobiCmd(AntAction("Open console Kenoby path"))
        println("AntUseCase - openKenobiCmd result=${r.result}")

    }

    override fun gitLog() {
        println("AntUseCase - gitLog")
        val r: AntResult = this.gitCommand.gitLog(AntAction("List the last commits log"))
        println("AntUseCase - gitLog result=${r.result}")
    }

    override fun launchKenobi(){
        println("AntUseCase - launchKenobi ")
        val r: AntResult = this.kenobiCommand.launchKenobiServer(AntAction("Launch kenobi server in a new console"))
        println("\"AntUseCase - launchKenobi result=${r.result}")
    }

    override fun launchKenobiTest(){
        println("AntUseCase - launchKenobiTest ")
        val r: AntResult = this.kenobiCommand.launchKenobiTest(AntAction("Launch kenobi tests in a new console"))
        println("\"AntUseCase - launchKenobiTest result=${r.result}")
    }

    override fun copyEnvPPRD1(){
        println("AntUseCase - copyEnvPPRD1 ")
        val r: AntResult = this.kenobiCommand.copyEnvPPRD1(AntAction("Copy files to setup pprd1 env"))
        println("\"AntUseCase - copyEnvPPRD1 result=${r.result}")
    }

    override fun copyEnvSit2(){
        println("AntUseCase - copyEnvSit2 ")
        val r: AntResult = this.kenobiCommand.copyEnvSit2(AntAction("Copy files to setup sit2 env"))
        println("\"AntUseCase - copyEnvSit2 result=${r.result}")
    }

    override fun launchKenobiInstall(){
        println("AntUseCase - launchKenobiInstall ")
        val r: AntResult = this.kenobiCommand.launchKenobiInstall(AntAction("Launchs the install kenobi command"))
        println("\"AntUseCase - launchKenobiInstall result=${r.result}")
    }

    override fun buildProKenobi(){
        println("AntUseCase - buildProKenobi ")
        val r: AntResult = this.kenobiCommand.buildProKenobi(AntAction("Make a prod compilation"))
        println("\"AntUseCase - buildProKenobi result=${r.result}")
    }
}