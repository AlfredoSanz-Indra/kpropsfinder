package es.kprops.data.commands.git.repository

import es.kprops.data.commands.git.api.GitPullCommandApi

/**
 * @author Alfredo Sanz
 * @time 2022
 */
class GitPullCommandApiImpl : GitPullCommandApi {

    override fun doAction() {



        println("doAction")

        //Runtime.getRuntime().exec("git status")
        Runtime.getRuntime().exec("cmd /c start c:\\Windows\\System32\\gotopull.bat")

    }
}