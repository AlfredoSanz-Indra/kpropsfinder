package es.kprops.domain.repository.ant

import es.kprops.domain.model.ant.AntAction
import es.kprops.domain.model.ant.AntResult

/**
 * @author Alfredo Sanz
 * @time 2022
 */
interface GitCommand {
    fun pullAll(action: AntAction): AntResult

    fun gitLog(action: AntAction): AntResult
}