package es.kprops.domain.api.systemcases

import es.kprops.domain.model.system.SystemResult

/**
 * @author Alfredo Sanz
 * @time 2022
 */
interface SystemUseCase {

    suspend fun startVpn(): SystemResult

    suspend fun stopVpn(): SystemResult

    suspend fun openBridges(): SystemResult
}