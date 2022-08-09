package es.kprops.core.di

import es.kprops.data.commands.ant.repository.*

/**
 * @author Alfredo Sanz
 * @time 2022
 */
object  ApiFactory {

    private lateinit var pullCommand: GitPullCommandApiImpl
    private lateinit var gitLogCommandApi: GitLogCommandApiImpl
    private lateinit var openKenobiCommandApi: OpenKenobiCommandApiImpl
    private lateinit var buildProKenobiCommandApi: BuildProKenobiCommandApiImpl
    private lateinit var copyEnvPPRD1CommandApi: CopyEnvPPRD1CommandApiImpl
    private lateinit var copyEnvSit2CommandApi: CopyEnvSit2CommandApiImpl
    private lateinit var launchKenobiCommandApi: LaunchKenobiCommandApiImpl
    private lateinit var launchKenobiInstallCommandApi: LaunchKenobiInstallCommandApiImpl
    private lateinit var launchKenobiTestsCommandApi: LaunchKenobiTestsCommandApiImpl

    fun getPullCommandApi(): GitPullCommandApiImpl {
        if (!this::pullCommand.isInitialized) {
            this.pullCommand = GitPullCommandApiImpl()
        }
         return this.pullCommand
    }

    fun getOpenKenobiCommandApi(): OpenKenobiCommandApiImpl {
        if (!this::openKenobiCommandApi.isInitialized) {
            this.openKenobiCommandApi = OpenKenobiCommandApiImpl()
        }
        return this.openKenobiCommandApi
    }

    fun getBuildProKenobiCommandApi(): BuildProKenobiCommandApiImpl {
        if (!this::buildProKenobiCommandApi.isInitialized) {
            this.buildProKenobiCommandApi = BuildProKenobiCommandApiImpl()
        }
        return this.buildProKenobiCommandApi
    }

    fun getcopyEnvPPRD1CommandApi(): CopyEnvPPRD1CommandApiImpl {
        if (!this::copyEnvPPRD1CommandApi.isInitialized) {
            this.copyEnvPPRD1CommandApi = CopyEnvPPRD1CommandApiImpl()
        }
        return this.copyEnvPPRD1CommandApi
    }

    fun getCopyEnvSit2KenobiCommandApi(): CopyEnvSit2CommandApiImpl {
        if (!this::copyEnvSit2CommandApi.isInitialized) {
            this.copyEnvSit2CommandApi = CopyEnvSit2CommandApiImpl()
        }
        return this.copyEnvSit2CommandApi
    }

    fun getGitLogCommandApi(): GitLogCommandApiImpl {
        if (!this::gitLogCommandApi.isInitialized) {
            this.gitLogCommandApi = GitLogCommandApiImpl()
        }
        return this.gitLogCommandApi
    }

    fun getLaunchKenobiCommandApi(): LaunchKenobiCommandApiImpl {
        if (!this::launchKenobiCommandApi.isInitialized) {
            this.launchKenobiCommandApi = LaunchKenobiCommandApiImpl()
        }
        return this.launchKenobiCommandApi
    }

    fun getLaunchKenobiInstallCommandApi(): LaunchKenobiInstallCommandApiImpl {
        if (!this::launchKenobiInstallCommandApi.isInitialized) {
            this.launchKenobiInstallCommandApi = LaunchKenobiInstallCommandApiImpl()
        }
        return this.launchKenobiInstallCommandApi
    }

    fun getLaunchKenobiTestsCommandApi(): LaunchKenobiTestsCommandApiImpl {
        if (!this::launchKenobiTestsCommandApi.isInitialized) {
            this.launchKenobiTestsCommandApi = LaunchKenobiTestsCommandApiImpl()
        }
        return this.launchKenobiTestsCommandApi
    }
}