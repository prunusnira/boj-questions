fun main() {
    val start = readLine()!!.toInt()

    var next = start
    var init = true
    var count = 0
    while(true) {
        if(init) {
            init = false
        }
        else {
            if(start == next) break
        }
        val fw = next%10
        next = next/10+next%10
        val nx = next%10
        next = fw*10+nx
        count++
    }

    print(count)
}