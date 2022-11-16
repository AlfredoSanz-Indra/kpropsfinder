package es.kprops.data.datasource.db

import es.kprops.data.datasource.api.PropDS
import es.kprops.domain.model.prop.Property


/**
 * @author Alfredo Sanz
 * @time 2022
 */
class PropDSImpl : PropDS {
    override fun findPropertiesByName(name: String): List<Property> {
        TODO("Not yet implemented")
    }
}