package es.kprops.data.commands.git.entity

import es.kprops.domain.model.git.GitResult

data class GitResultEntity(val result: String)


    fun GitResultEntity.toGitResult(): GitResult {
        return GitResult(result)
    }
