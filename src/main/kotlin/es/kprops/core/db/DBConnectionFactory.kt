package es.kprops.core.db

import es.kprops.core.model.Datasource
import org.jdbi.v3.core.Jdbi


/**
 * @author Alfredo Sanz
 * @time 2022
 */
object DBConnectionFactory {

    fun openConnection( _ds: Datasource): Jdbi {
        println("DBConnectionFactory->openConnection - dsname: ${_ds.name}")
        val result: Jdbi = Jdbi.create(_ds.url, _ds.user, _ds.password)

        return result
    }
}