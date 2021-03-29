import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.collections.ArrayList
import kotlin.system.exitProcess

var br = BufferedReader(InputStreamReader(System.`in`))
var bw = BufferedWriter(OutputStreamWriter(System.`out`))

fun main() {
    val arr = Array(9) { _ -> IntArray(9) { _ -> 0 } }
    for(i in 0 until 9) {
        arr[i] = br.readLine().split(" ").map(String::toInt).toIntArray()
    }
    br.close()

    solve(0, 0, arr)
}

/**
 * 1. (0, 0)에서 시작하여 각 칸을 탐색
 * 2. 값이 0인 (i, j)가 나오면 가로, 세로, 3*3 범위에서 가용 가능한 값을 탐색
 * 3. 각 탐색 결과에서 중복되는 값을 구함
 * 3-1. 중복되는 값이 없다면 이전 단계로 이동
 * 3-2. 중복되는 값에 대해 각각 대입하고 다음 칸으로 이동
 *
 * 케이스에서 오류가 확인되면 대입한 칸을 0으로 만들고 이전 단계로 이동함
 */
fun solve(i: Int, j: Int, arr: Array<IntArray>) {
    if(i < 9) {
        if(arr[i][j] != 0) {
            if(j < 8) solve(i, j+1, arr)
            else solve(i+1, 0, arr)
        }
        else {
            find(i, j, arr)
        }
    }
    else {
        // 결과 확인
        for(a in 0 until 9) {
            for(b in 0 until 9) {
                bw.write("${arr[a][b]}")
                if(b < 8) bw.write(" ")
            }
            if(a < 8) bw.write("\n")
        }
        bw.flush()
        bw.close()
        exitProcess(0)
    }
}

fun find(i: Int, j: Int, arr: Array<IntArray>) {
    val hlist = checkHr(j, arr)
    val wlist = checkWx(i, arr)
    val tlist = check33(i, j, arr)

    // 가로, 세로, 3*3에 대해 중복되는것만 모아서 solve를 돌림
    if(hlist.count() > 0 && wlist.count() > 0 && tlist.count() > 0) {
        val dup = ArrayList<Int>()
        for(a in 1..9) {
            if(hlist.contains(a) &&
                    wlist.contains(a) &&
                    tlist.contains(a)) {
                dup.add((a))
            }
        }

        if(dup.count() > 0) {
            for(v in dup) {
                arr[i][j] = v
                if(j < 8) solve(i, j+1, arr)
                else solve(i+1, 0, arr)
                arr[i][j] = 0
            }
        }
        else return
    }
}

fun checkHr(j: Int, arr: Array<IntArray>): ArrayList<Int> {
    val list = ArrayList<Int>(9)
    list.addAll(Array(9) { x -> x+1 })

    for(a in 0 until 9) {
        if(list.contains(arr[a][j])) list.remove(arr[a][j])
    }

    return list
}

fun checkWx(i: Int, arr: Array<IntArray>): ArrayList<Int> {
    val list = ArrayList<Int>(9)
    list.addAll(Array(9) { x -> x+1 })

    for(a in 0 until 9) {
        if(list.contains(arr[i][a])) list.remove(arr[i][a])
    }

    return list
}

fun check33(i: Int, j: Int, arr: Array<IntArray>): ArrayList<Int> {
    val list = ArrayList<Int>(9)
    list.addAll(Array(9) { x -> x+1 })

    var startx = if(i < 3) 0
    else if(i < 6) 3
    else 6

    var starty = if(j < 3) 0
    else if(j < 6) 3
    else 6

    for(a in startx until startx + 3) {
        for(b in starty until starty + 3) {
            if(list.contains(arr[a][b])) list.remove(arr[a][b])
        }
    }

    return list
}