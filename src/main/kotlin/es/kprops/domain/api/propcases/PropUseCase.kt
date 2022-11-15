package es.kprops.domain.api.propcases

import es.kprops.domain.model.prop.PropResult

interface PropUseCase {

    suspend fun findProperties(environment: String, propName: String): PropResult
}