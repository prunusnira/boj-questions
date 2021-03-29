val memo = ArrayList<Int>()

// 피보나치를 재귀로 실행했을 때
// 0과 1의 실행 횟수는 피보나치로 나타내어짐 (0의 첫 시도만 1이다)
// 0의 실행 횟수는 1칸씩 밀린다
fun main() {
    memo.add(0)
    memo.add(1)
    val n = readLine()!!.toInt()
    for(i in 0 until n) {
        val v = readLine()!!.toInt()
        if(v == 0) print("1 0\n")
        else if(v == 1) print("0 1\n")
        else {
            print("${fibo(v-1)} ${fibo(v)}\n")
        }
    }
}

fun fibo(n: Int): Int {
    if(n < 2) return n
    else {
        if(memo.size > n) {
            return memo[n]
        }
        else {
            memo.add(fibo(n-1)+fibo(n-2))
        }
        return memo[n]
    }
}