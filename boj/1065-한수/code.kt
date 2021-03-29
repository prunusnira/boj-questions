fun main() {
    val n = readLine()!!.toInt()
    var cnt = 0

    for(i in 1..n) {
        if(getTheNumber(i)) {
            cnt++
        }
    }

    print(cnt)
}

// 글자 나누기 없이 숫자로 변경
fun getTheNumber(n: Int): Boolean {
    if(n < 100) return true

    var cur = n
    var arr = ArrayList<Int>()
    while(cur > 0) {
        arr.add(cur % 10)
        cur /= 10
    }

    var diff = 0
    for(i in 1 until arr.size) {
        if(i == 1) diff = arr[i] - arr[i-1]
        else if(arr[i] - arr[i-1] != diff) {
            return false
        }
    }
    return true
}