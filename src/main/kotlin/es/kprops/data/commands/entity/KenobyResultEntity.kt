package es.kprops.data.commands.entity

import es.kprops.domain.model.ant.AntResult

/**
 * @author Alfredo Sanz
 * @time 2022
 */
data class KenobyResultEntity(val result: String)

    fun KenobyResultEntity.toKenobiResult(): AntResult {
        return AntResult(result)
    }
