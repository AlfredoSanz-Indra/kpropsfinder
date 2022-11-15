package es.kprops.data.commands.entity

import es.kprops.domain.model.ant.AntResult

/**
 * @author Alfredo Sanz
 * @time 2022
 */
data class GitResultEntity(val result: String)

    fun GitResultEntity.toGitResult(): AntResult {
        return AntResult(result)
    }
