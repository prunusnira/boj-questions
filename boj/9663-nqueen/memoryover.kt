import java.io.BufferedWriter
import java.io.OutputStreamWriter

var bw = BufferedWriter(OutputStreamWriter(System.`out`))
var total = 0

fun main() {
    val n = readLine()!!.toInt()

    caseCheck(0, n, Array(n) { _ -> Array(n) { _ -> false } })

    bw.write(total.toString())
    bw.flush()
    bw.close()
}

fun caseCheck(i: Int, n: Int, arr: Array<Array<Boolean>>) {
    if(i < n) {
        for(j in 0 until n) {
            val arrc = copy(arr)

            // 첫 줄이면 아무것도 안하고 그냥 true 찍고 넘김
            if(i == 0) {
                arrc[i][j] = true
                caseCheck(i+1, n, arrc)
            }
            else {
                var ok = true
                // 이전 라인들에서 가로 직선 혹은 대각선으로 true가 있는지 확인
                for(a in 0 until i) {
                    if(arrc[a][j]) ok = false
                }
                if(!ok) continue

                var xi = i
                var xj = j
                while(xi > 0 && xj > 0) {
                    xi--
                    xj--
                    if(arrc[xi][xj]) ok = false
                }
                if(!ok) continue

                xi = i
                xj = j
                while(xi > 0 && xj < n-1) {
                    xi--
                    xj++
                    if(arrc[xi][xj]) ok = false
                }
                if(!ok) continue

                arrc[i][j] = true
                caseCheck(i+1, n, arrc)
            }
        }
    }
    else {
        // 끝남
        var count = 0
        for(a in 0 until n) {
            for(b in 0 until n) {
                if(arr[a][b]) count++
            }
        }
        if(count == n) total++
    }
}

fun copy(arr: Array<Array<Boolean>>): Array<Array<Boolean>> {
    var narr = Array(arr.size) { _ -> Array(arr.size) { _ -> false } }
    for(i in arr.indices) {
        for(j in arr.indices) {
            narr[i][j] = arr[i][j]
        }
    }

    return narr
}