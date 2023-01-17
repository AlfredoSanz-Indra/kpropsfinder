package es.kprops.core.model

import kotlinx.serialization.Serializable


/**
 * @author Alfredo Sanz
 * @time 2022
 */
@Serializable
data class Datasource(
    val name: String,
    val shortName: String,
    val url: String,
    val user: String,
    val password: String
)
