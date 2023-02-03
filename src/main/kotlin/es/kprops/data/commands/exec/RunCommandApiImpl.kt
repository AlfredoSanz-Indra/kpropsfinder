package es.kprops.data.commands.exec

import es.kprops.core.resources.TheResources
import es.kprops.data.commands.api.CommandApi
import es.kprops.data.commands.api.Commands

/**
 * @author Alfredo Sanz
 * @time 2022
 */
class RunCommandApiImpl: CommandApi {

    override fun doAction(commandAction: Commands) {

        val route: String = getRoute(commandAction)
        val command = "cmd /c start $route"

        println("doAction: Executing command ->  $command")
        Runtime.getRuntime().exec(command)
    }


    private fun getRoute(command: Commands): String {

        var result = ""
        val props = TheResources.getConstantsProp()

        when(command.name) {
            Commands.OPEN_KENOBI_CMD.name ->        result = props.get("BAT_FILE_SOURCE") as String + props.get("BAT_FILE_gotokenobi") as String
            Commands.START_KENOBI_SERVER.name ->    result = props.get("BAT_FILE_SOURCE") as String + props.get("BAT_FILE_kenobiserver") as String
            Commands.BUILD_PROD.name ->             result = props.get("BAT_FILE_SOURCE") as String + props.get("BAT_FILE_gotokenobi_build") as String
            Commands.GIT_LOG.name ->                result = props.get("BAT_FILE_SOURCE") as String + props.get("BAT_FILE_gotolog") as String
            Commands.COPY_ENV_PPRD1.name ->         result = props.get("BAT_FILE_SOURCE") as String + props.get("BAT_FILE_gotopprd1") as String
            Commands.COPY_ENV_SIT2.name ->          result = props.get("BAT_FILE_SOURCE") as String + props.get("BAT_FILE_gotosit2") as String
            Commands.COPY_ENV_HID.name ->           result = props.get("BAT_FILE_SOURCE") as String + props.get("BAT_FILE_gotohid") as String
            Commands.COPY_ENV_LOCAL.name ->         result = props.get("BAT_FILE_SOURCE") as String + props.get("BAT_FILE_gotolocal") as String
            Commands.GIT_PULL_ALL.name ->           result = props.get("BAT_FILE_SOURCE") as String + props.get("BAT_FILE_gotopull") as String
            Commands.LAUNCH_TESTS.name ->           result = props.get("BAT_FILE_SOURCE") as String + props.get("BAT_FILE_gototest") as String
            Commands.MAKE_INSTALL.name ->           result = props.get("BAT_FILE_SOURCE") as String + props.get("BAT_FILE_gotoinstall") as String
            Commands.SYSTEM_START_VPN.name ->       result = props.get("BAT_FILE_NTOL_SCRIPTS_SOURCE") as String + props.get("BAT_FILE_startVpn") as String
            Commands.SYSTEM_STOP_VPN.name ->        result = props.get("BAT_FILE_DESKTOP_SOURCE") as String + props.get("BAT_FILE_stopVpn") as String
            Commands.SYSTEM_OPEN_BRIDGES.name ->    result = props.get("BAT_FILE_NTOL_SCRIPTS_APACHE_SOURCE") as String + props.get("BAT_FILE_openBridges") as String
            Commands.GIT_PULL_KENOBI.name ->        result = props.get("BAT_FILE_SOURCE") as String + props.get("BAT_FILEgoto_pullkenobi") as String
            Commands.BUILD_ALL_BACK.name ->         result = props.get("BAT_FILE_SOURCE") as String + props.get("BAT_FILE_gotobuildback") as String
            Commands.BUILD_COMMON_BACK.name ->      result = props.get("BAT_FILE_SOURCE") as String + props.get("BAT_FILE_gotobuildbackcommon") as String
            Commands.BUILD_TIENDA_BACK.name ->      result = props.get("BAT_FILE_SOURCE") as String + props.get("BAT_FILE_gotobuildbacktienda") as String
            Commands.BUILD_CATALOG_BACK.name ->     result = props.get("BAT_FILE_SOURCE") as String + props.get("BAT_FILE_gotobuildbackcatalogo") as String
            Commands.BUILD_CESTA_BACK.name ->       result = props.get("BAT_FILE_SOURCE") as String + props.get("BAT_FILE_gotobuildbackcesta") as String
            Commands.BUILD_TRASTIENDA_BACK.name ->  result = props.get("BAT_FILE_SOURCE") as String + props.get("BAT_FILE_gotobuildbacktrastienda") as String
            Commands.LAUNCH_FRONT_TRASTIENDA_LOCAL.name ->  result = props.get("BAT_FILE_SOURCE") as String + props.get("BAT_FILE_goto_launchTrastiendaLocalServer") as String
            Commands.START_WEBLOGIC.name ->         result = props.get("BAT_FILE_SOURCE") as String + props.get("BAT_FILE_gotostartweblogic") as String
        }

        return result
    }
}