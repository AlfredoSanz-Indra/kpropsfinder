package es.kprops.data.commands.git.repository

import es.kprops.data.commands.git.api.GitPullCommandApi

class GitPullCommandApiImpl : GitPullCommandApi {

    override suspend fun doAction() {
        println("doAction")
    }
}