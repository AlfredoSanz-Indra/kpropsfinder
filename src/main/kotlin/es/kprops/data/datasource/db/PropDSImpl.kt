package es.kprops.data.datasource.db

import es.kprops.core.db.DBConnectionPool
import es.kprops.core.db.DBQueryFactory
import es.kprops.core.model.Datasource
import es.kprops.core.resources.TheResources
import es.kprops.data.datasource.api.PropDS
import es.kprops.domain.model.prop.Property
import org.jdbi.v3.core.Handle
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.core.mapper.reflect.BeanMapper


/**
 * @author Alfredo Sanz
 * @time 2022
 */
class PropDSImpl : PropDS {
    override fun findPropertiesByName(_ds: Datasource, _prop: String): List<Property> {
        println("PropDSImpl->findPropertiesByName - dsName: ${_ds.shortName} && property: $_prop")

        val jdbi: Jdbi = DBConnectionPool.getConnection(_ds)
        lateinit var result: List<Property>

        try {
            val qname: String = TheResources.getConstantsProp().getProperty("QUERY_QUERY-ONE")
            val query: String = DBQueryFactory.getQueryFromResources(qname, _ds.name)

            println("PropDSImpl->findPropertiesByName - query: $query")

            result =
                jdbi.withHandle<List<Property>, RuntimeException>
                { handle: Handle ->
                    handle.registerRowMapper(BeanMapper.factory(Property::class.java))
                    handle.createQuery(query )
                          .bind("prop", _prop)
                          .mapTo(Property::class.java)
                          .list()
                }
        }
        catch (ex: Exception) {
            println("PropDSImpl->findPropertiesByName - Exception: ${ex.message}")
            throw Exception("Error quering properties: ${ex.message}")
        }
        return result
   }
}