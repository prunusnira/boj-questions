import java.io.BufferedWriter
import java.io.OutputStreamWriter

var bw = BufferedWriter(OutputStreamWriter(System.`out`))
var total = 0

fun main() {
    val n = readLine()!!.toInt()

    caseCheck(0, n, Array(n) { _ -> -1 })

    bw.write(total.toString())
    bw.flush()
    bw.close()
}

fun caseCheck(i: Int, n: Int, arr: Array<Int>) {
    if(i < n) {
        for(j in 0 until n) {
            // 첫 줄이면 아무것도 안하고 그냥 true 찍고 넘김
            if(i == 0) {
                arr[i] = j
                caseCheck(i+1, n, arr)
            }
            else {
                var ok = true
                // 이전 라인들에서 가로 직선 혹은 대각선으로 true가 있는지 확인
                for(a in 0 until i) {
                    if(arr[a] == j) ok = false
                }
                if(!ok) continue

                var xi = i
                var xj = j
                while(xi > 0 && xj > 0) {
                    xi--
                    xj--
                    if(arr[xi] == xj) ok = false
                }
                if(!ok) continue

                xi = i
                xj = j
                while(xi > 0 && xj < n-1) {
                    xi--
                    xj++
                    if(arr[xi] == xj) ok = false
                }
                if(!ok) continue

                arr[i] = j
                caseCheck(i+1, n, arr)
            }
        }
    }
    else {
        // 끝남
        var count = 0
        for(a in 0 until n) {
            if(arr[a] != -1) count++
        }
        if(count == n) total++
    }

    // i == n-1이 확인되면 i 위치는 -1로 다시 변경
    if(i > 0) arr[i-1] = -1
}