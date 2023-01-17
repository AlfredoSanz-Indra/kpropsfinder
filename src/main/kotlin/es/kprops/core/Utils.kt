package es.kprops.core


 fun formatLogText(input: String): String {
    return formatLogText(input, 10)
}

fun formatLogText(input: String, nLastFiles: Int): String {
    var result = input
    val tList: List<String> = input.split("\n")
    if(tList.size > nLastFiles) {
        val newList: List<String> = tList.subList(tList.size - nLastFiles , tList.size)
        result = ""
        newList.forEach {
            result += "\n" + it
        }
    }

    return result
}