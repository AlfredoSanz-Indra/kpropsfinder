package es.kprops.data.repository.ant

import es.kprops.core.di.ApiFactory
import es.kprops.data.commands.ant.api.*
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

    private val openKenobiCommandApi: OpenKenobiCommandApi = ApiFactory.getOpenKenobiCommandApi()
    private val launchKenobiCommandApi: LaunchKenobiCommandApi = ApiFactory.getLaunchKenobiCommandApi()
    private val buildProKenobiCommandApi: BuildProKenobiCommandApi = ApiFactory.getBuildProKenobiCommandApi()
    private val launchKenobiTestsCommandApi: LaunchKenobiTestsCommandApi = ApiFactory.getLaunchKenobiTestsCommandApi()
    private val copyEnvPPRD1CommandApi: CopyEnvPPRD1CommandApi = ApiFactory.getcopyEnvPPRD1CommandApi()
    private val copyEnvSit2KenobiCommandApi: CopyEnvSit2CommandApi = ApiFactory.getCopyEnvSit2KenobiCommandApi()
    private val launchKenobiInstallCommandApi: LaunchKenobiInstallCommandApi = ApiFactory.getLaunchKenobiInstallCommandApi()


    override fun openKenobiCmd(action: AntAction): AntResult {
        println("KenobiCommandImpl - openKenobiCmd")
        try {
            this.openKenobiCommandApi.doAction()
        }
        catch(e: Exception) {
            return KenobyResultEntity("KO").toKenobiResult()
        }
        return KenobyResultEntity("OK").toKenobiResult()
    }

    override fun launchKenobiServer(action: AntAction): AntResult {
        println("KenobiCommandImpl - launchKenobiServer")
        try {
            this.launchKenobiCommandApi.doAction()
        }
        catch(e: Exception) {
            return KenobyResultEntity("KO").toKenobiResult()
        }
        return KenobyResultEntity("OK").toKenobiResult()
    }

    override fun launchKenobiTest(action: AntAction): AntResult {
        return KenobyResultEntity("Not Implemented").toKenobiResult()
    }

    override fun copyEnvPPRD1(action: AntAction): AntResult {
        return KenobyResultEntity("Not Implemented").toKenobiResult()
    }

    override fun copyEnvSit2(action: AntAction): AntResult {
        return KenobyResultEntity("Not Implemented").toKenobiResult()
    }

    override fun launchKenobiInstall(action: AntAction): AntResult {
        return KenobyResultEntity("Not Implemented").toKenobiResult()
    }

    override fun buildProKenobi(action: AntAction): AntResult {
        return KenobyResultEntity("Not Implemented").toKenobiResult()
    }
}