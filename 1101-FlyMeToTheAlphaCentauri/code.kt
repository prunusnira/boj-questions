/**
 * 본래는 수식을 이용하여 푸는게 정석이라고 생각하고
 * 절반까지의 거리를 올 때 까지의 등차수열로 계산하면
 * 최소 이동 횟수를 구할 수 있을것이라고 생각하고 구현하였으나
 * 최소 이동 횟수를 구하는 과정이 너무 복잡해져서 방식을 변경,
 * 
 * 간단하게 절반 까지 오는 과정까지 더해가면서
 * 다음값이 오버되는 경우 브레이크를 걸고
 * 남는 길이에 대해 현재 최고 길이를 이용해 간단히 조건 계산만을 수행했음
 */

fun main() {
    val cases = readLine()!!.toInt()
    for(case in 0 until cases) {
        val (x, y) = readLine()!!.split(" ").map(String::toInt)
        val l = y - x

        if(l < 4) {
            // 범위가 3일때 까지는 1로만 이동 가능
            println(l)
        }
        else {
            var sum = 0
            var cnt = 1
            while(true) {
                sum += cnt
                cnt++

                if(l/2 - sum < cnt) {
                    cnt--
                    break
                }
            }

            val left = l - sum * 2

            if(left == 0) {
                println(2*cnt)
            }
            else if(left > cnt+1) {
                // 반드시 1번 이상의 이동이 필요한 경우, 2번만 될 수 없음
                println(2*cnt+2)
            }
            else {
                // 무조건 1번으로 나머지 영역이 이동될 수 있음
                println(2*cnt+1)
            }
        }
    }
}