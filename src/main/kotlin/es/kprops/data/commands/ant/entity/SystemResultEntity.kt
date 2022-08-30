package es.kprops.data.commands.ant.entity

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