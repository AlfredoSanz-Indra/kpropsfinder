package es.kprops.core.model

import kotlinx.serialization.Serializable

/**
 * @author Alfredo Sanz
 * @time 2022
 */
@Serializable
data class Query(
    val dsname: String,
    val q_select: List<String>,
    val q_from: List<String>,
    val q_where: List<String>
)
