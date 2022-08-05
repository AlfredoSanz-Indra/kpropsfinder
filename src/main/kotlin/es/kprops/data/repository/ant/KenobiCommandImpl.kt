package es.kprops.data.repository.ant

import es.kprops.core.di.ApiFactory
import es.kprops.data.commands.ant.api.OpenKenobiCommandApi
import es.kprops.data.commands.ant.entity.KenobyResultEntity
import es.kprops.data.commands.ant.entity.toKenobiResult
import es.kprops.domain.model.ant.AntAction
import es.kprops.domain.model.ant.AntResult
import es.kprops.domain.repository.ant.KenobiCommand

class KenobiCommandImpl : KenobiCommand {

    private val openKenobiCommandApi: OpenKenobiCommandApi = ApiFactory.getOpenKenobiCommandApi()

    override fun openKenobiCmd(action: AntAction): AntResult {
        println("openKenobiCmd")
        try {
            this.openKenobiCommandApi.doAction()
        }
        catch(e: Exception) {
            return KenobyResultEntity("KO").toKenobiResult()
        }
        return KenobyResultEntity("OK").toKenobiResult()
    }
}