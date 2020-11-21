fun main() {
    val size = readLine()!!.toInt()
    for(idx in 0 until size) {
        val k = readLine()!!.toInt() + 1
        val n = readLine()!!.toInt()

        val floorMap = ArrayList<ArrayList<Int>>()

        floorMap.add(ArrayList())
        for(i in 0 until n) {
            floorMap[0].add(i+1)
        }

        for(i in 1 until k) {
            floorMap.add(ArrayList())
            var sum = 0
            for(j in 0 until n) {
                sum += floorMap[i-1][j]
                floorMap[i].add(sum)
            }
        }

        // 층 출력 코드
        /*for(i in k-1 downTo 0) {
            for(j in 0 until n) {
                print("${floorMap[i][j]} ")
            }
            println()
        }*/
        println(floorMap[k-1][n-1])
    }
}