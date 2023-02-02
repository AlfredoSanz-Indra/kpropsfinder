package es.kprops.core.model

import kotlinx.serialization.Serializable

/**
 * @author Alfredo Sanz
 * @time 2023
 */
@Serializable
data class Clips (
    @Serializable()
    val clips: List<Clip>
)