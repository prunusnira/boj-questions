fun main() {
    val all = readLine()!!.toInt()
    val cases = ArrayList<IntArray>()

    for(i in 0 until all) {
        val arr = readLine()!!.split(" ").map(String::toInt).toIntArray()
        cases.add(arr.copyOfRange(1, arr.size))
    }

    for(case in cases) {
        val avg = case.average()
        var cnt = 0
        for(v in case) {
            if(v.toDouble() > avg) cnt++
        }
        val perc = String.format("%.3f", cnt.toDouble()/case.size*100)
        println("$perc%")
    }
}