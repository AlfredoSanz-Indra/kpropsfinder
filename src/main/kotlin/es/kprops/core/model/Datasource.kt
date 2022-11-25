package es.kprops.core.model

import kotlinx.serialization.Serializable


@Serializable
data class Datasource(
    val name: String,
    val url: String,
    val user: String,
    val password: String
)
