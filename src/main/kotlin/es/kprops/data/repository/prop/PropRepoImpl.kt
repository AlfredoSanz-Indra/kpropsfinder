package es.kprops.data.repository.prop

import es.kprops.core.di.DataFactory
import es.kprops.core.model.Environment
import es.kprops.core.resources.TheResources
import es.kprops.data.datasource.api.PropDS
import es.kprops.domain.model.prop.PropResult
import es.kprops.domain.model.prop.Property
import es.kprops.domain.repository.prop.PropRepo

/**
 * @author Alfredo Sanz
 * @time 2022
 */
class PropRepoImpl : PropRepo {

    private val propDS: PropDS = DataFactory.getPropDS()

    override fun findProperties(_envName: String, _prop: String): PropResult {

        println("PropRepoImpl->findProperties - _envName: $_envName , property: $_prop")
        lateinit var result: PropResult

        try {
            val env: Environment = getEnvironment(_envName)

            val totalProps: MutableList<Property> = ArrayList()
            env.datasources.forEach { it ->
                    val props: List<Property> = propDS.findPropertiesByName(it, _prop)
                    props.forEach { p ->  p.dsName = it.shortName }
                    totalProps.addAll(props)
                    val n = props.size
                    println("PropRepoImpl->findProperties - Found $n props")
            }
            result = PropResult(totalProps, 200)
        }
        catch (ex: Exception) {
            println("PropRepoImpl->findProperties Exception: ${ex.message}")
            result = PropResult(ArrayList(), 500)
            result.errorMessage = ex.message!!
        }

        return result
    }

    private fun getEnvironment(_envName: String): Environment {
        try {
            return TheResources.getDatasources().environments.first { e -> e.name == _envName }
        }
        catch(ex: Exception) {
            throw Exception("Error obtaining environment data: ${ex.message}")
        }
    }
}