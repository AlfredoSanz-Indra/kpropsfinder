package es.kprops.core.resources

import es.kprops.core.model.Datasources
import java.util.*

/**
 * @author Alfredo Sanz
 * @time 2022
 */
object TheResources {

private lateinit var constantsProp: Properties
private lateinit var datasources: Datasources


    fun getConstantsProp(): Properties {
        if (!this::constantsProp.isInitialized) {
            this.constantsProp = readResources("constants.properties")
        }
        return this.constantsProp
    }

    fun getDatasources(): Datasources {
        if (!this::datasources.isInitialized) {
            this.datasources = readJsonResources("datasources.json")
        }
        return this.datasources
    }
}