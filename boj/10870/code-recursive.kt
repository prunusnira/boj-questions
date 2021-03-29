fun main() {
    val r = readLine()!!.toInt()
    print(fibo(r))
}

fun fibo(i: Int): Int {
    return if(i < 2) i
    else fibo(i-1)+fibo(i-2)
}