package es.kprops.domain.model.prop

/**
 * @author Alfredo Sanz
 * @time 2022
 */
data class PropResult( val propList : List<Property>,
                       val status: Int ) {
    var errorMessage: String = ""
}
