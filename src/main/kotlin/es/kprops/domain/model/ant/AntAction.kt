package es.kprops.domain.model.ant

import es.kprops.core.model.CommandBuildType
import es.kprops.core.model.CommandFrontTrasLaunchType

/**
 * @author Alfredo Sanz
 * @time 2022
 */
data class  AntAction(val action: String,
                      val buildType: CommandBuildType? = null,
                      val launchType: CommandFrontTrasLaunchType? = null)
