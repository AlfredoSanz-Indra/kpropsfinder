package es.kprops.core.resources

import java.util.*

/**
 * @author Alfredo Sanz
 * @time 2022
 */
object TheResources {

private lateinit var constantsProp: Properties


    fun getConstantsProp(): Properties {
        if (!this::constantsProp.isInitialized) {
            this.constantsProp = readResources("constants.properties")
        }
        return this.constantsProp
    }
}