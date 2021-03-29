fun main(args:Array<String>) {
    var strset: List<String>

    try {
        // Exception 1: strset must not null
        strset = getInputStr()

        // Exception 2: strset does not have 2 values	
        if(checkSize(strset)) {
            // Convert each number
            var num1 = strset[0].toInt()
            var num2 = strset[1].toInt()

            // Exception 3: Check numbers are in right range
            print(num1 + num2)
        }
    }
    catch (e:Exception) {
        print("Exception")
    }
}

fun getInputStr() : List<String> {
    val input = readLine()
    var strset: List<String>
    if(input != null) {
        strset = input.split(" ")
    }
    else {
        throw Exception()
    }
    return strset
}

fun checkSize(set:List<String>): Boolean {
    if(set.size != 2) throw Exception()
    else return true
}