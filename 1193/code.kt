fun main() {
    val n = readLine()!!.toInt()
    var cnt = 1
    var value = 1

    // 홀수열 -> 왼쪽이 위에서 내려감
    // 짝수열 -> 왼쪽이 아래에서 올라감

    while(true) {
        if(n > value) {
            cnt++
            value += cnt
        }
        else {
            val start = value - cnt
            val end = value + 1
            if(cnt % 2 == 0) {
                val up = n - start
                val down = end - n
                println("$up/$down")
            }
            else {
                val down = n - start
                val up = end - n
                println("$up/$down")
            }
            break
        }
    }
}