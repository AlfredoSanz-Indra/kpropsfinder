package es.kprops.core.model

import kotlinx.serialization.Serializable

/**
 * @author Alfredo Sanz
 * @time 2023
 */
@Serializable
data class Clip(
    val name: String,
    val label: String,
    val checkType: String,
    val restURL: String,
    val bdSentence: String
)