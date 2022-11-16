package es.kprops.domain.repository.system

import es.kprops.domain.model.system.SystemResult

/**
 * @author Alfredo Sanz
 * @time 2022
 */
interface SystemCommand {

    fun startVpn(): SystemResult

    fun stopVpn(): SystemResult

    fun openBridges(): SystemResult
}