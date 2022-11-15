package es.kprops.domain.repository.prop

import es.kprops.domain.model.prop.PropResult

/**
 * @author Alfredo Sanz
 * @time 2022
 */
interface PropRepo {

    fun findProperties(environment: String, name: String): PropResult
}