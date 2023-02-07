package es.kprops.data.datasource.api

import es.kprops.core.model.Datasource
import es.kprops.domain.model.prop.Property


/**
 * @author Alfredo Sanz
 * @time 2022
 */
interface PropDS {

    fun findPropertiesByName(_ds: Datasource, _name: String): List<Property>

    fun findPropertiesByValue(_ds: Datasource, _propVal: String): List<Property>
}