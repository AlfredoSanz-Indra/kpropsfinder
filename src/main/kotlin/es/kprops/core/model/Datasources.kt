package es.kprops.core.model

import kotlinx.serialization.Serializable

/**
 * @author Alfredo Sanz
 * @time 2022
 */
@Serializable
data class Datasources(
    @Serializable()
    val environments: List<Environment>
)
