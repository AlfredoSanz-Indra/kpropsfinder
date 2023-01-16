package es.kprops.core.model

import kotlinx.serialization.Serializable

/**
 * @author Alfredo Sanz
 * @time 2022
 */
@Serializable
data class Environment(
    val name: String,
    @Serializable()
    val datasources: List<Datasource>
)
