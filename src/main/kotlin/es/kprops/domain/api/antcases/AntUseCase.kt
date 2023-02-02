package es.kprops.domain.api.antcases

import es.kprops.core.model.CommandBuildType
import es.kprops.core.model.CommandFrontTrasLaunchType
import es.kprops.domain.model.ant.AntResult

/**
 * @author Alfredo Sanz
 * @time 2022
 */
interface AntUseCase {
    suspend fun gitPullAll()

    suspend fun gitPullKenobi()

    suspend fun gitLog()

    suspend fun openKenobiCmd(): AntResult

    suspend fun launchKenobi(): AntResult

    suspend fun launchKenobiTest(): AntResult

    suspend fun copyEnvPPRD1(): AntResult

    suspend fun copyEnvSit2(): AntResult

    suspend fun copyEnvLocal(): AntResult

    suspend fun copyEnvHid(): AntResult

    suspend fun launchKenobiInstall(): AntResult

    suspend fun buildProKenobi(): AntResult

    suspend fun backBuild(buildType: CommandBuildType): AntResult

    suspend fun launchFrontTrastServer(launchType: CommandFrontTrasLaunchType): AntResult
}