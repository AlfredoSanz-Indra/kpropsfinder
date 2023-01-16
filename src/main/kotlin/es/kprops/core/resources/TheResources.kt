package es.kprops.core.resources

import es.kprops.core.model.Datasources
import es.kprops.core.model.JQueries
import java.util.*

/**
 * @author Alfredo Sanz
 * @time 2022
 */
object TheResources {

private lateinit var constantsProp: Properties
private lateinit var datasources: Datasources
private lateinit var queries: JQueries


    fun getConstantsProp(): Properties {
        if (!this::constantsProp.isInitialized) {
            this.constantsProp = readResources("constantss.properties")
        }
        return this.constantsProp
    }

    fun getDatasources(): Datasources {
        if (!this::datasources.isInitialized) {
            this.datasources = readJsonResources_Datasources("datasources.json")
        }
        return this.datasources
    }

    fun getQueries(): JQueries {
        if (!this::queries.isInitialized) {
            this.queries = readJsonResources_Queries("queries.json")
        }
        return this.queries
    }
}