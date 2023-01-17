package es.kprops.core.db

import es.kprops.core.model.Datasource
import org.jdbi.v3.core.Jdbi

/**
 * @author Alfredo Sanz
 * @time 2022
 */
object  DBConnectionPool {

    private val dsVault: MutableMap<String, Jdbi> = HashMap()

    fun getConnection(_ds: Datasource): Jdbi {
        println("DBConnectionPool->getConnection - dsname: ${_ds.shortName}")
        val result: Jdbi

        if(dsVault.containsKey(_ds.name)) {
            println("DBConnectionPool->getConnection - conn exist")
            result = dsVault.getValue(_ds.name)
        }
        else {
            println("DBConnectionPool->getConnection - create conn")
            result = DBConnectionFactory.openConnection(_ds)

            dsVault.put(_ds.name, result)
        }

        return result
    }
}