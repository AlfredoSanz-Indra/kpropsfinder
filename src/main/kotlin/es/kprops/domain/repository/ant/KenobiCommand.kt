package es.kprops.domain.repository.ant

import es.kprops.domain.model.ant.AntAction
import es.kprops.domain.model.ant.AntResult

interface KenobiCommand {

    fun openKenobiCmd(action: AntAction): AntResult
}