package es.kprops.core.model

import kotlinx.serialization.Serializable

@Serializable
data class Datasources(
    val env: String,
    @Serializable()
    val datasources: List<Datasource>
)
