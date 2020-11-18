// 이건 시간이 오래 걸리는 편이니 나중에 다시 와서 다른 답도 생각해보자
fun main() {
    val arr = ArrayList<Int>(10000)
    for(i in 1 until 10001) {
        arr.add(i)
    }

    for(i in 1 until 10001) {
        // 이미 셀프넘버가 아닌것으로 판명된 값은 검사하지 않는것이 포인트
        if(arr.contains(i)) {
            var v = i
            while (v <= 10000) {
                v = d(v)
                arr.remove(v)
            }
        }
    }

    for(i in arr) {
        println(i)
    }
}

fun d(n: Int): Int {
    val arr = n.toString().toCharArray()
    var nums = ArrayList<Int>()
    for(v in arr) {
        nums.add(v.toString().toInt())
    }
    return nums.sum()+n
}