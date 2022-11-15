package es.kprops.data.commands.entity

import es.kprops.domain.model.system.SystemResult

/**
 * @author Alfredo Sanz
 * @time 2022
 */
data class SystemResultEntity(val result: String) {

    fun toSystemResult(): SystemResult {
        return SystemResult(result)
    }
}