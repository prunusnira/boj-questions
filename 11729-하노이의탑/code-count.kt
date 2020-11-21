import kotlin.math.pow

/**
 * 하노이의 탑 규칙
 * n이 늘어날 수록 최소 이동 횟수가 2^n씩 늘어난다
 *
 * n = 1 -> 1
 * n = 2 -> 3 (차이 2)
 * n = 3 -> 7 (차이 4)
 * n = 4 -> 15 (차이 8)
 * ...
 *
 * k_1 = 1
 * k_n = 1 + sigma(2^(n-1)) / n >= 2
 * 
 * 최소 이동 횟수만 필요하면 이걸로만 해도 충분함
 * 
 * 사실은 이 값도 재귀없이 계산할 수 있는데, (2^n - 1)이다
 */
fun main() {
    val n = readLine()!!.toInt()
    println(hanoi(n))
}

fun hanoi(n: Int): Int {
    return if(n == 1) 1
    else 2.toDouble().pow((n - 1).toDouble()).toInt() + hanoi(n-1)
}