package es.kprops.data.commands.ant.entity

import es.kprops.domain.model.ant.AntResult

/**
 * @author Alfredo Sanz
 * @time 2022
 */
data class GitResultEntity(val result: String)

    fun GitResultEntity.toGitResult(): AntResult {
        return AntResult(result)
    }
