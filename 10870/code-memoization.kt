val memo = ArrayList<Int>()

fun main() {
    val n = readLine()!!.toInt()
    memo.add(0)
    memo.add(1)
    print(fibo(n))
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