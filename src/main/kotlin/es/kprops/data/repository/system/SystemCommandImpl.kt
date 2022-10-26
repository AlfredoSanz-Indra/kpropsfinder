package es.kprops.data.repository.system

import es.kprops.core.di.ApiFactory
import es.kprops.data.commands.ant.api.CommandApi
import es.kprops.data.commands.ant.api.Commands
import es.kprops.data.commands.ant.entity.SystemResultEntity
import es.kprops.domain.model.system.SystemResult
import es.kprops.domain.repository.system.SystemCommand

/**
 * @author Alfredo Sanz
 * @time 2022
 */
class SystemCommandImpl : SystemCommand {

    private val runCommandApi: CommandApi = ApiFactory.getRunCommandApi()

    override fun startVpn() : SystemResult {
        println("SystemCommandImpl - startVpn")
        try {
           // this.runCommandApi.doAction(Commands.SYSTEM_START_VPN)
        }
        catch(e: Exception) {
            return SystemResultEntity("KO").toSystemResult()
        }
        return SystemResultEntity("OK").toSystemResult()
    }

    override fun stopVpn(): SystemResult {
        println("SystemCommandImpl - stopVpn")
        try {
           // this.runCommandApi.doAction(Commands.SYSTEM_STOP_VPN)
        }
        catch(e: Exception) {
            return SystemResultEntity("KO").toSystemResult()
        }
        return SystemResultEntity("OK").toSystemResult()
    }
}