var min = 0
var max = 0
var init = false
lateinit var nums: List<Int>

fun main() {
    val n = readLine()!!.toInt()
    nums = readLine()!!.split(" ").map(String::toInt)
    val operator = readLine()!!.split(" ").map(String::toInt)

    // 순서 섞기 및 계산 수행
    val p = operator[0]
    val m = operator[1]
    val x = operator[2]
    val d = operator[3]
    solve(p, m, x, d, ArrayList<Int>())

    println(max)
    println(min)
}

fun solve(plus: Int, minus: Int, multi: Int, div: Int, oplist: ArrayList<Int>) {
    if(plus == 0 && minus == 0 && multi == 0 && div == 0) {
        var sum = nums[0]
        // 계산 수행하기
        for(i in oplist.indices) {
            when(oplist[i]) {
                0 -> sum += nums[i+1]
                1 -> sum -= nums[i+1]
                2 -> sum *= nums[i+1]
                3 ->
                    if(sum < 0) sum = ((-1 * sum) / nums[i+1]) * -1
                    else sum /= nums[i+1]
            }
        }

        if(!init) {
            init = true
            // min/max 동시 변경
            min = sum
            max = sum
        }
        else {
            // min/max 처리
            if(sum < min) min = sum
            else if(sum > max) max = sum
        }
    }
    else {
        var np = plus
        var nm = minus
        var nx = multi
        var nd = div

        if(plus > 0) {
            oplist.add(0)
            np--
            solve(np, nm, nx, nd, oplist)
            oplist.removeAt(oplist.lastIndex)
            np++
        }

        if(minus > 0) {
            oplist.add(1)
            nm--
            solve(np, nm, nx, nd, oplist)
            oplist.removeAt(oplist.lastIndex)
            nm++
        }

        if(multi > 0) {
            oplist.add(2)
            nx--
            solve(np, nm, nx, nd, oplist)
            oplist.removeAt(oplist.lastIndex)
            nx++
        }

        if(div > 0) {
            oplist.add(3)
            nd--
            solve(np, nm, nx, nd, oplist)
            oplist.removeAt(oplist.lastIndex)
            nd++
        }
    }
}