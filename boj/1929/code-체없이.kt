import kotlin.math.sqrt

fun main() {
    val (min, max) = readLine()!!.split(" ").map(String::toInt)
    for(i in min..max) {
        var isPrime = true
        if(i == 1) continue
        // 소수 판별은 양의 제곱근 이하의 수로 나누었을 때만 판단하면 된다
        // (출처: 위키피디아)
        for(j in 2..sqrt(i.toDouble()).toInt()) {
            if(i % j == 0) {
                isPrime = false
                break
            }
        }
        if(isPrime) {
            println(i)
        }
    }
}