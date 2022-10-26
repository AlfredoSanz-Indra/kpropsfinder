package es.kprops.core


 fun formatLogText(input: String): String {
    var result = input
    val tList: List<String> = input.split("\n")
    if(tList.size > 9) {
        val newList: List<String> = tList.subList(tList.size - 10, tList.size)
        result = ""
        newList.forEach {
            result += "\n" + it
        }
    }

    return result
}