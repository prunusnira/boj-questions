/**
 * 임의의 소수를 본래의 숫자에서 뺐을 때,
 * 1) 나머지 수도 소수이면 일단 합격
 * 2) 경우가 여러개인 경우를 고려하여 소수의 차도 같이 저장해둠
 *
 * 케이스가 10000까지이므로 에라토스테네스의 체를 이용하는게 무조건 빠름 */

fun main() {
    val che = Array(10001) { i -> i }
    val primeList = ArrayList<Int>()

    // 10000까지 소수 미리 판정해두기
    che[1] = 0
    for(i in 2..10000) {
        if(che[i] == 0) continue

        for(j in 2*i..10000 step i) {
            che[j] = 0
        }
    }

    for(i in 0..10000) {
        if(che[i] != 0) primeList.add(i)
    }

    val n = readLine()!!.toInt()
    for(i in 0 until n) {
        val num = readLine()!!.toInt()

        var lower = -1
        var high = -1
        var diff = -1

        // 순차적으로 수를 빼고 남는 값이 소수인지 확인
        for(i in primeList) {
            if(i < num) {
                val other = num - i
                if(i > other) break
                if(primeList.contains(other)) {
                    // 두 값을 저장하고 그 차이도 저장
                    if(diff == -1) {
                        lower = i
                        high = other
                        diff = high - lower
                    }
                    else if(other - i < diff) {
                        lower = i
                        high = other
                        diff = high - lower
                    }
                }
            }
            else {
                break
            }
        }
        println("$lower $high")
    }
}