package es.kprops.data.commands.git.api

import es.kprops.domain.model.git.GitAction
import es.kprops.domain.model.git.GitResult

interface GitPullCommandApi {

    suspend fun doAction()
}