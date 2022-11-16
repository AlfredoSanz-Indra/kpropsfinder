package es.kprops.data.repository.system

import es.kprops.core.di.DataFactory
import es.kprops.data.commands.api.CommandApi
import es.kprops.data.commands.api.Commands
import es.kprops.data.commands.entity.SystemResultEntity
import es.kprops.domain.model.system.SystemResult
import es.kprops.domain.repository.system.SystemCommand

/**
 * @author Alfredo Sanz
 * @time 2022
 */
class SystemCommandImpl : SystemCommand {

    private val runCommandApi: CommandApi = DataFactory.getRunCommandApi()

    override fun startVpn() : SystemResult {
        println("SystemCommandImpl - startVpn")
        try {
            this.runCommandApi.doAction(Commands.SYSTEM_START_VPN)
        }
        catch(e: Exception) {
            return SystemResultEntity("KO").toSystemResult()
        }
        return SystemResultEntity("OK").toSystemResult()
    }

    override fun stopVpn(): SystemResult {
        println("SystemCommandImpl - stopVpn")
        try {
            this.runCommandApi.doAction(Commands.SYSTEM_STOP_VPN)
        }
        catch(e: Exception) {
            return SystemResultEntity("KO").toSystemResult()
        }
        return SystemResultEntity("OK").toSystemResult()
    }
}