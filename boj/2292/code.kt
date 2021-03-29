// 벌집 순서: 1, 7, 19, 37, 61...
// 차이 = 6n
fun main() {
    val n = readLine()!!.toInt()
    var cnt = 1
    var value = 1

    while(true) {
        if(n > value) {
            value += 6*cnt
            cnt++
        }
        else {
            print(cnt)
            break
        }
    }
}