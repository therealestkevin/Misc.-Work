

fun main(args : Array<String>){
    println(getStringLength("hello"))
    var testArray = listOf<Int>(3,2,2,2)
    printArray(testArray)
}


fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        //automatic cast, that's nice
        return obj.length
    }

    // `obj` is still of type `Any` outside of the type-checked branch
    return null
}

fun printArray(arr : List<Int>) {
    for(item in arr){
        println(item)
    }
}