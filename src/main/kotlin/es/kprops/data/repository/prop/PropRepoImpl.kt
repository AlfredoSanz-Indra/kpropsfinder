package es.kprops.data.repository.prop

import es.kprops.core.di.DataFactory
import es.kprops.data.datasource.api.PropDS
import es.kprops.domain.model.prop.PropResult
import es.kprops.domain.model.prop.Property
import es.kprops.domain.repository.prop.PropRepo

/**
 * @author Alfredo Sanz
 * @time 2022
 */
class PropRepoImpl : PropRepo {

    private val propDS: PropDS = DataFactory.getPropDS()

    override fun findProperties(environment: String, name: String): PropResult {

        val props: List<Property> =  propDS.findPropertiesByName(name)
        val result = PropResult(props)

        return result
    }
}