import java.io.BufferedWriter
import java.io.OutputStreamWriter

/**
 * 전체를 9개의 구역으로 나누고 5번째는 항상 공백이 되도록 만든다
 * 구역이기 때문에 각 구역 내부는 재귀적으로 적용된다
 */
var arr: Array<Array<String>>? = null
fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val n = readLine()!!.toInt()
    arr = Array(n) { Array(n) { "" } }

    // n의 3의 지수를 구함
    val exp = getExp(n)
    draw(exp, 0, 0, 0, false)

    for(i in 0 until n) {
        for(j in 0 until n) {
            bw.write(arr!![i][j])
        }
        bw.write("\n")
    }
    bw.flush()
    bw.close()
}

fun draw(exp: Int, depth: Int, startX: Int, startY: Int, isCenter: Boolean) {
    for(i in 0..2) {
        for(j in 0..2) {
            if(exp == 1) {
                if(isCenter || (i == 1 && j == 1)) {
                    arr!![startX+i][startY+j] = " "
                }
                else {
                    arr!![startX+i][startY+j] = "*"
                }
            }
            else {
                var nextCenter = false
                if(isCenter || (i == 1 && j == 1)) nextCenter = true
                draw(exp-1, depth+1, (startX+i)*3, (startY+j)*3, nextCenter)
            }
        }
    }
}

fun getExp(n: Int): Int {
    var value = n
    var cnt = 0
    while(true) {
        if(value / 3 != 1) {
            value /= 3
            cnt++
        }
        else {
            cnt++
            break
        }
    }
    return cnt
}