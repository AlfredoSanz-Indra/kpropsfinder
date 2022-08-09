package es.kprops.domain.api.antcases

/**
 * @author Alfredo Sanz
 * @time 2022
 */
interface AntUseCase {
    fun gitPullAll()

    fun gitLog()

    fun openKenobiCmd()

    fun launchKenobi()

    fun launchKenobiTest()

    fun copyEnvPPRD1()

    fun copyEnvSit2()

    fun launchKenobiInstall()

    fun buildProKenobi()
}