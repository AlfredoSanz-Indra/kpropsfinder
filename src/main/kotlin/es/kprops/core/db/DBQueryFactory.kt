package es.kprops.core.db

import es.kprops.core.model.JQueries
import es.kprops.core.model.Queries
import es.kprops.core.model.Query
import es.kprops.core.resources.TheResources


/**
 * @author Alfredo Sanz
 * @time 2022
 */
object DBQueryFactory {

    fun getQueryFromResources(queryName: String,
                              dsName: String  ): String {

        println("DBQueryFactory->getQueryFromResources - queryName: $queryName")
        println("DBQueryFactory->getQueryFromResources - dsName: $dsName")
        var result = ""

        val jqs: JQueries = TheResources.getQueries()
        val qsList: List<Queries> = jqs.queries.filter { it -> it.name.equals(queryName)  }
        var qs: Queries? = qsList.find { it -> dsName == it.query.dsname.findLast { it2 -> it2 == dsName } }
        if(null == qs) {
            qs = qsList.find { it -> it.query.dsname.get(0) == "DEFAULT" }
        }

        if(null != qs) {
            result = format(qs.query)
        }

        return result
    }

    private fun format(q: Query): String {
        val result: StringBuilder = StringBuilder()

        q.q_select.forEach { it -> result.append(it) }
        q.q_from.forEach { it -> result.append((it)) }
        q.q_where.forEach { it -> result.append(it) }

        return result.toString()
    }
}