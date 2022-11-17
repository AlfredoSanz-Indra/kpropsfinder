package es.kprops.core.resources

import java.util.*


/**
 * Read a properties file from resources path
 */
fun readResources(fileName: String): Properties {
    val props = Properties()
    val loader = Thread.currentThread().contextClassLoader
    loader.getResourceAsStream(fileName).use { resourceStream -> props.load(resourceStream) }

    return props
}