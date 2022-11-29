package es.kprops.data.repository.ant

import es.kprops.core.di.DataFactory
import es.kprops.data.commands.api.CommandApi
import es.kprops.data.commands.api.Commands
import es.kprops.data.commands.entity.KenobyResultEntity
import es.kprops.data.commands.entity.toKenobiResult
import es.kprops.domain.model.ant.AntAction
import es.kprops.domain.model.ant.AntResult
import es.kprops.domain.repository.ant.KenobiCommand

/**
 * @author Alfredo Sanz
 * @time 2022
 */
class KenobiCommandImpl : KenobiCommand {

    private val runCommandApi: CommandApi = DataFactory.getRunCommandApi()

    override fun openKenobiCmd(action: AntAction): AntResult {
        println("KenobiCommandImpl - openKenobiCmd")
        try {
            this.runCommandApi.doAction(Commands.OPEN_KENOBI_CMD)
        }
        catch(e: Exception) {
            return KenobyResultEntity("KO").toKenobiResult()
        }
        return KenobyResultEntity("OK").toKenobiResult()
    }

    override fun launchKenobiServer(action: AntAction): AntResult {
        println("KenobiCommandImpl - launchKenobiServer")
        try {
            this.runCommandApi.doAction(Commands.START_KENOBI_SERVER)
        }
        catch(e: Exception) {
            return KenobyResultEntity("KO").toKenobiResult()
        }
        return KenobyResultEntity("OK").toKenobiResult()
    }

    override fun launchKenobiTest(action: AntAction): AntResult {
        println("KenobiCommandImpl - launchKenobiTest")
        try {
            this.runCommandApi.doAction(Commands.LAUNCH_TESTS)
        }
        catch(e: Exception) {
            return KenobyResultEntity("KO").toKenobiResult()
        }
        return KenobyResultEntity("OK").toKenobiResult()
    }

    override fun copyEnvPPRD1(action: AntAction): AntResult {
        println("KenobiCommandImpl - copyEnvPPRD1")
        try {
            this.runCommandApi.doAction(Commands.COPY_ENV_PPRD1)
        }
        catch(e: Exception) {
            return KenobyResultEntity("KO").toKenobiResult()
        }
        return KenobyResultEntity("OK").toKenobiResult()
    }

    override fun copyEnvSit2(action: AntAction): AntResult {
        println("KenobiCommandImpl - copyEnvSit2")
        try {
            this.runCommandApi.doAction(Commands.COPY_ENV_SIT2)
        }
        catch(e: Exception) {
            return KenobyResultEntity("KO").toKenobiResult()
        }
        return KenobyResultEntity("OK").toKenobiResult()
    }

    override  fun copyEnvLocal(action: AntAction): AntResult {
        println("KenobiCommandImpl - copyEnvLocal")
        try {
            this.runCommandApi.doAction(Commands.COPY_ENV_LOCAL)
        }
        catch(e: Exception) {
            return KenobyResultEntity("KO").toKenobiResult()
        }
        return KenobyResultEntity("OK").toKenobiResult()
    }

    override fun copyEnvHid(action: AntAction): AntResult {
        println("KenobiCommandImpl - copyEnvHid")
        try {
            this.runCommandApi.doAction(Commands.COPY_ENV_HID)
        }
        catch(e: Exception) {
            return KenobyResultEntity("KO").toKenobiResult()
        }
        return KenobyResultEntity("OK").toKenobiResult()
    }

    override fun launchKenobiInstall(action: AntAction): AntResult {
        println("KenobiCommandImpl - launchKenobiInstall")
        try {
            this.runCommandApi.doAction(Commands.MAKE_INSTALL)
        }
        catch(e: Exception) {
            return KenobyResultEntity("KO").toKenobiResult()
        }
        return KenobyResultEntity("OK").toKenobiResult()
    }

    override fun buildProKenobi(action: AntAction): AntResult {
        println("KenobiCommandImpl - buildProKenobi")
        try {
           this.runCommandApi.doAction(Commands.BUILD_PROD)
        }
        catch(e: Exception) {
            return KenobyResultEntity("KO").toKenobiResult()
        }
        return KenobyResultEntity("OK").toKenobiResult()
    }

    override fun backBuildAll(action: AntAction): AntResult {
        println("KenobiCommandImpl - backBuildAll")
        try {
            this.runCommandApi.doAction(Commands.BUILD_ALL_BACK)
        }
        catch(e: Exception) {
            return KenobyResultEntity("KO").toKenobiResult()
        }
        return KenobyResultEntity("OK").toKenobiResult()
    }
}