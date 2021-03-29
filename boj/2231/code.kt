fun main() {
    val n = readLine()!!.toInt()
    print(getMinimumDivOrigin(n))
}

fun getMinimumDivOrigin(n: Int): Int {
    val numSize = n.toString().length
    var startVal = n - 9*numSize
    if(startVal < 0) startVal = 0 // 혹시나...

    for(i in startVal until n) {
        if(getDivSum(i) == n) return i
    }
    return 0
}

fun getDivSum(n: Int): Int {
    val numSize = n.toString().length

    var div = n
    var v = n
    for(i in 0 until numSize) {
        v += div % 10
        div /= 10
    }

    return v
}