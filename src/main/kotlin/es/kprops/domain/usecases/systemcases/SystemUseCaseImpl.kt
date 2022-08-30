package es.kprops.domain.usecases.systemcases

import es.kprops.core.di.RepoFactory
import es.kprops.domain.api.systemcases.SystemUseCase
import es.kprops.domain.repository.system.SystemCommand

/**
 * @author Alfredo Sanz
 * @time 2022
 */
class SystemUseCaseImpl : SystemUseCase {

    private val systemCommand: SystemCommand = RepoFactory.getSystemCommandRepo()

    override fun startVpn() {

        this.systemCommand.startVpn()
    }

    override fun stopVpn() {
        this.systemCommand.stopVpn()
    }
}