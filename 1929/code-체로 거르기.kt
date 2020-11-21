fun main() {
    val (min, max) = readLine()!!.split(" ").map(String::toInt)
    val che = Array(max+1) { i -> i }

    // max까지 소수 미리 판정해두기
    che[1] = 0
    for(i in 2..max) {
        if(che[i] == 0) continue

        for(j in 2*i until max+1 step i) {
            che[j] = 0
        }
    }

    for(i in min..max) {
        if(che[i] != 0) {
            println(i)
        }
    }
}