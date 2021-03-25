var arr = Array(101) { _ -> 0L}

fun main() {
    val n = readLine()!!.toInt()
    arr[0] = 0
    arr[1] = 1
    arr[2] = 1
    arr[3] = 1
    arr[4] = 2
    arr[5] = 2

    for(i in 0 until n) {
        val x = readLine()!!.toInt()
        println(calc(x))
    }
}

fun calc(n: Int): Long {
    if(n < 4) {
        return 1L
    }
    else if(n < 6) {
        return 2L
    }
    else if(arr[n] != 0L) {
        return arr[n]
    }
    else {
        arr[n] = calc(n-1) + calc(n-5)
        return arr[n]
    }
}