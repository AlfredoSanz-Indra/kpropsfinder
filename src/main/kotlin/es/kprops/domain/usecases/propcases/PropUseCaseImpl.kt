package es.kprops.domain.usecases.propcases

import es.kprops.core.di.RepoFactory
import es.kprops.domain.api.propcases.PropUseCase
import es.kprops.domain.model.prop.PropResult
import es.kprops.domain.repository.prop.PropRepo

/**
 * @author Alfredo Sanz
 * @time 2022
 */
class PropUseCaseImpl : PropUseCase {

    private val propCommand: PropRepo = RepoFactory.getPropCommandRepo()

    override suspend fun findProperties(environment: String, propName: String): PropResult {
        return propCommand.findProperties(environment, propName)
    }
}