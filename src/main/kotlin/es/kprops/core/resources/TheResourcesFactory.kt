package es.kprops.core.resources

import es.kprops.core.model.Clips
import es.kprops.core.model.Datasources
import es.kprops.core.model.JQueries
import java.util.*
import kotlinx.serialization.json.*
import java.io.InputStream


/**
 * Read a properties file from resources path
 */
fun readResources(fileName: String): Properties {
    val props = Properties()
    val loader = Thread.currentThread().contextClassLoader
    loader.getResourceAsStream(fileName).use { resourceStream -> props.load(resourceStream) }

    return props
}

/**
 * Read a Json file from Resources Path
 */
fun readJsonResources_Datasources(fileName: String): Datasources {
    val loader = Thread.currentThread().contextClassLoader
    val input: InputStream = loader.getResourceAsStream(fileName)

    val result = Json.decodeFromStream<Datasources>(input)
    return result
}

fun readJsonResources_Queries(fileName: String): JQueries {
    val loader = Thread.currentThread().contextClassLoader
    val input: InputStream = loader.getResourceAsStream(fileName)

    val result = Json.decodeFromStream<JQueries>(input)
    return result
}

fun readJsonResources_checksenvironment(fileName: String): Clips {
    val loader = Thread.currentThread().contextClassLoader
    val input: InputStream = loader.getResourceAsStream(fileName)

    val result = Json.decodeFromStream<Clips>(input)
    return result
}