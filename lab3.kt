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

fun evalInfo(i:Any):String? {
    when (i) {
        is Int -> {
            if (i % 10 == 0) {
                return "M10"
            } else if (i % 5 == 0) {
                return "M5"
            } else if (i % 2 == 0) {
                return "M2"
            } else {
                return null
            }
        }
        is String -> return "L${i.length}"
        is Boolean -> if (i) return "Verdadero" else return "Falso"
        else -> return null
    }
}

fun processList(inputList: List<Any?>?): List<ItemData>? {
	var rList: ArrayList<ItemData> = ArrayList<ItemData>()
    
    if (inputList != null) {
        if (inputList.size != 0) {
            for (i in inputList) {
                var originalPos: Int
                var originalValue: Any
                var type: String? = null
                var info: String? = null

                if (i != null) {
                    originalPos = inputList.indexOf(i)
                    originalValue = i.toString()
                    when (i) {
                        is Int -> {
                            type = "entero"
                            info = evalInfo(i)
                            originalValue = i
                        }
                        is String -> {
                            type = "cadena"
                            info = evalInfo(i)
                        }
                        is Boolean -> {
                            type = "booleano"
                            info = evalInfo(i)
                            originalValue = i
                        }
                    }
                    rList.add(ItemData(originalPos, originalValue, type, info))
                }
            }
        }
    }
    return rList
}