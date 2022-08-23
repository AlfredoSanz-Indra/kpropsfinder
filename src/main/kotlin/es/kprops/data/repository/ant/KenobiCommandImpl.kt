package es.kprops.data.repository.ant

import es.kprops.core.Constants
import es.kprops.core.di.ApiFactory
import es.kprops.data.commands.ant.api.CommandApi
import es.kprops.data.commands.ant.entity.KenobyResultEntity
import es.kprops.data.commands.ant.entity.toKenobiResult
import es.kprops.domain.model.ant.AntAction
import es.kprops.domain.model.ant.AntResult
import es.kprops.domain.repository.ant.KenobiCommand

/**
 * @author Alfredo Sanz
 * @time 2022
 */
class KenobiCommandImpl : KenobiCommand {

    private val runCommandApi: CommandApi = ApiFactory.getRunCommandApi()

    override fun openKenobiCmd(action: AntAction): AntResult {
        println("KenobiCommandImpl - openKenobiCmd")
        try {
            val route: String =   Constants.BAT_FILE_SOURCE + Constants.BAT_FILE_gotokenobi
            val command = "cmd /c start $route"
            this.runCommandApi.doAction(command)
        }
        catch(e: Exception) {
            return KenobyResultEntity("KO").toKenobiResult()
        }
        return KenobyResultEntity("OK").toKenobiResult()
    }

    override fun launchKenobiServer(action: AntAction): AntResult {
        println("KenobiCommandImpl - launchKenobiServer")
        try {
            val route: String =   Constants.BAT_FILE_SOURCE + Constants.BAT_FILE_kenobiserver
            val command = "cmd /c start $route"
            this.runCommandApi.doAction(command)
        }
        catch(e: Exception) {
            return KenobyResultEntity("KO").toKenobiResult()
        }
        return KenobyResultEntity("OK").toKenobiResult()
    }

    override fun launchKenobiTest(action: AntAction): AntResult {
        println("KenobiCommandImpl - launchKenobiTest")
        try {
            val route: String =   Constants.BAT_FILE_SOURCE + Constants.BAT_FILE_gototest
            val command = "cmd /c start $route"
            this.runCommandApi.doAction(command)
        }
        catch(e: Exception) {
            return KenobyResultEntity("KO").toKenobiResult()
        }
        return KenobyResultEntity("OK").toKenobiResult()
    }

    override fun copyEnvPPRD1(action: AntAction): AntResult {
        println("KenobiCommandImpl - copyEnvPPRD1")
        try {
            val route: String =   Constants.BAT_FILE_SOURCE + Constants.BAT_FILE_gotopprd1
            val command = "cmd /c start $route"
            this.runCommandApi.doAction(command)
        }
        catch(e: Exception) {
            return KenobyResultEntity("KO").toKenobiResult()
        }
        return KenobyResultEntity("OK").toKenobiResult()
    }

    override fun copyEnvSit2(action: AntAction): AntResult {
        println("KenobiCommandImpl - copyEnvSit2")
        try {
            val route: String =   Constants.BAT_FILE_SOURCE + Constants.BAT_FILE_gotosit2
            val command = "cmd /c start $route"
            this.runCommandApi.doAction(command)
        }
        catch(e: Exception) {
            return KenobyResultEntity("KO").toKenobiResult()
        }
        return KenobyResultEntity("OK").toKenobiResult()
    }

    override fun launchKenobiInstall(action: AntAction): AntResult {
        println("KenobiCommandImpl - launchKenobiInstall")
        try {
            val route: String =   Constants.BAT_FILE_SOURCE + Constants.BAT_FILE_gotoinstall
            val command = "cmd /c start $route"
            this.runCommandApi.doAction(command)
        }
        catch(e: Exception) {
            return KenobyResultEntity("KO").toKenobiResult()
        }
        return KenobyResultEntity("OK").toKenobiResult()
    }

    override fun buildProKenobi(action: AntAction): AntResult {
        println("KenobiCommandImpl - buildProKenobi")
        try {
            val route: String =   Constants.BAT_FILE_SOURCE + Constants.BAT_FILE_gotokenobi_build
            val command = "cmd /c start $route"
            this.runCommandApi.doAction(command)
        }
        catch(e: Exception) {
            return KenobyResultEntity("KO").toKenobiResult()
        }
        return KenobyResultEntity("OK").toKenobiResult()
    }
}