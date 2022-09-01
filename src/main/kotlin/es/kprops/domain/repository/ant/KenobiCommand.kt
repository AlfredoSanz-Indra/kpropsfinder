package es.kprops.domain.repository.ant

import es.kprops.domain.model.ant.AntAction
import es.kprops.domain.model.ant.AntResult

interface KenobiCommand {

    fun openKenobiCmd(action: AntAction): AntResult

    fun launchKenobiServer(action: AntAction): AntResult

    fun launchKenobiTest(action: AntAction): AntResult

    fun copyEnvPPRD1(action: AntAction): AntResult

    fun copyEnvSit2(action: AntAction): AntResult

    fun copyEnvHid(action: AntAction): AntResult

    fun launchKenobiInstall(action: AntAction): AntResult

    fun buildProKenobi(action: AntAction): AntResult
}