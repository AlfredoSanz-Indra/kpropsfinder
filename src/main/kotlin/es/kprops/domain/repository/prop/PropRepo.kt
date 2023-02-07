package es.kprops.domain.repository.prop

import es.kprops.domain.model.prop.PropResult

/**
 * @author Alfredo Sanz
 * @time 2022
 */
interface PropRepo {

    fun findPropertiesByName(environment: String, propName: String): PropResult

    fun findPropertiesByValue(environment: String, propVal: String): PropResult
}