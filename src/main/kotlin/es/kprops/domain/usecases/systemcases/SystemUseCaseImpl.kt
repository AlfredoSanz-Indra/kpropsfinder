package es.kprops.domain.usecases.systemcases

import es.kprops.core.di.RepoFactory
import es.kprops.domain.api.systemcases.SystemUseCase
import es.kprops.domain.model.system.SystemResult
import es.kprops.domain.repository.system.SystemCommand

/**
 * @author Alfredo Sanz
 * @time 2022
 */
class SystemUseCaseImpl : SystemUseCase {

    private val systemCommand: SystemCommand = RepoFactory.getSystemCommandRepo()

    suspend override fun startVpn(): SystemResult {
       return  this.systemCommand.startVpn()
    }

    suspend override fun stopVpn(): SystemResult {
       return this.systemCommand.stopVpn()
    }
}