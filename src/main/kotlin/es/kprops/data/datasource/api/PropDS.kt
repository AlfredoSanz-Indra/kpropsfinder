package es.kprops.data.datasource.api

import es.kprops.core.model.Datasource
import es.kprops.domain.model.prop.Property


/**
 * @author Alfredo Sanz
 * @time 2022
 */
interface PropDS {

    fun findPropertiesByName(ds: Datasource, name: String): List<Property>
}