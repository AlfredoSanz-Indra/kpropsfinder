package es.kprops.domain.repository.git

import es.kprops.domain.model.git.GitAction
import es.kprops.domain.model.git.GitResult

interface GitCommand {

    fun pullAll(action: GitAction): GitResult
}