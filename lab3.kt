data class ItemData(
    var originalPos: Int,
    var originalValue: Any,
	var type: String? = null,
    var info: String? = null
)
// -----------------------

fun main() {
    val result = processList(listOf(10, "Enero", null, true))
    //val result = processList(listOf(25, "Hola", null, false))
    println(result)
}

fun processList(inputList: List<Any?>?): List<ItemData>? {
	var rList: ArrayList<ItemData> = ArrayList<ItemData>()
    
    inputList?.run {
        for (i in this.filterNotNull()) {
            i.run { rList.add(formatItem(i, inputList.indexOf(i))) }   
        }
    }
    return rList
}

fun evalInfo(i:Any):String? {
    when (i) {
        is Int -> {
            if (i % 10 == 0) return "M10"
            else if (i % 5 == 0) return "M5"
            else if (i % 2 == 0) return "M2"
            else return null
        }
        is String -> return "L${i.length}"
        is Boolean -> if (i) return "Verdadero" else return "Falso"
        else -> return null
    }
}

fun formatItem (item : Any, index : Int) : ItemData {
    val type: String? = when (item) {
                            is Int -> "entero"
                            is String -> "cadena"
                            is Boolean -> "booleano"
                            else -> null
                        }
    return ItemData(index, item, type, evalInfo(item))
}