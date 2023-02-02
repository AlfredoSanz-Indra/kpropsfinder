package es.kprops.domain.usecases.antcases

import es.kprops.core.di.RepoFactory
import es.kprops.core.model.CommandBuildType
import es.kprops.core.model.CommandFrontTrasLaunchType
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

    suspend override fun gitPullAll() {
        val r: AntResult =  this.gitCommand.pullAll(AntAction("pull All"))
        println("\"AntUseCase - gitPullAll  result=${r.result}")
    }

    suspend override  fun gitPullKenobi() {
        val r: AntResult =  this.gitCommand.pullKenobi(AntAction("pull Kenobi"))
        println("\"AntUseCase - gitPullKenobi  result=${r.result}")
    }

    suspend override fun openKenobiCmd(): AntResult {
        val r: AntResult = this.kenobiCommand.openKenobiCmd(AntAction("Open console Kenoby path"))
        println("AntUseCase - openKenobiCmd result=${r.result}")

        return r
    }

   suspend override fun gitLog() {
        val r: AntResult = this.gitCommand.gitLog(AntAction("List the last commits log"))
        println("AntUseCase - gitLog result=${r.result}")
    }

    suspend override fun launchKenobi(): AntResult {
        val r: AntResult = this.kenobiCommand.launchKenobiServer(AntAction("Launch kenobi server in a new console"))
        println("\"AntUseCase - launchKenobi result=${r.result}")

        return r
    }

   suspend override fun launchKenobiTest(): AntResult {
        val r: AntResult = this.kenobiCommand.launchKenobiTest(AntAction("Launch kenobi tests in a new console"))
        println("\"AntUseCase - launchKenobiTest result=${r.result}")

       return r
    }

    suspend override fun copyEnvPPRD1(): AntResult {
        val r: AntResult = this.kenobiCommand.copyEnvPPRD1(AntAction("Copy files to setup pprd1 env"))
        println("\"AntUseCase - copyEnvPPRD1 result=${r.result}")

        return r
    }

    suspend override fun copyEnvSit2(): AntResult{
        val r: AntResult = this.kenobiCommand.copyEnvSit2(AntAction("Copy files to setup sit2 env"))
        println("\"AntUseCase - copyEnvSit2 result=${r.result}")

        return r
    }

    suspend override  fun copyEnvLocal(): AntResult {
        val r: AntResult = this.kenobiCommand.copyEnvLocal(AntAction("Copy files to setup local env"))
        println("\"AntUseCase - copyEnvLocal result=${r.result}")

        return r
    }

    suspend override fun copyEnvHid(): AntResult {
        val r: AntResult = this.kenobiCommand.copyEnvHid(AntAction("Copy files to setup Hid env"))
        println("\"AntUseCase - copyEnvHid result=${r.result}")

        return r
    }

    suspend override fun launchKenobiInstall(): AntResult {
        val r: AntResult = this.kenobiCommand.launchKenobiInstall(AntAction("Launchs the install kenobi command"))
        println("\"AntUseCase - launchKenobiInstall result=${r.result}")

        return r
    }

    suspend override fun buildProKenobi(): AntResult {
        val r: AntResult = this.kenobiCommand.buildProKenobi(AntAction("Make a prod compilation"))
        println("\"AntUseCase - buildProKenobi result=${r.result}")

        return r
    }

    suspend override fun backBuild(buildType: CommandBuildType): AntResult {
        val r: AntResult = this.kenobiCommand.backBuildAll(AntAction("Make a back compilation", buildType))
        println("\"AntUseCase - backBuildAll result=${r.result}")

        return r
    }

    suspend override fun launchFrontTrastServer(launchType: CommandFrontTrasLaunchType): AntResult {
        println("launchFrontTrastServer launchType $launchType ")
        val r: AntResult = this.kenobiCommand.launchFrontTrastServer(AntAction("Launch Front Trastienda Server", launchType = launchType))
        println("\"AntUseCase - launchFrontTrastServer result=${r.result}")

        return r
    }
}