package es.kprops.domain.repository.git

import es.kprops.domain.model.git.GitAction
import es.kprops.domain.model.git.GitResult

/**
 * @author Alfredo Sanz
 * @time 2022
 */
interface GitCommand {
    fun pullAll(action: GitAction): GitResult
}