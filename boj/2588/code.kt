fun main() {
    val v1 = readLine()!!.toInt()
    val v2str = readLine()!!
    val v2val = v2str.toInt()
    val v2each = v2str.map{it.toString().toInt()}.toIntArray()
    v2each.reverse()

    val arr = ArrayList<Int>()
    for(i in v2each) {
        arr.add(v1 * i)
    }

    for(i in arr) {
        println(i)
    }
    println(v1*v2val)
}