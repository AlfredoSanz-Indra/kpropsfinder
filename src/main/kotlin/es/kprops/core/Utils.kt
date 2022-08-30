package es.kprops.core


 fun formatLogText(input: String): String {
    var result = input
    val tList: List<String> = input.split("\n")
    if(tList.size > 4) {
        val newList: List<String> = tList.subList(tList.size - 5, tList.size)
        result = ""
        newList.forEach {
            result += "\n" + it
        }
    }

    return result
}