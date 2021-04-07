import kotlin.collections.ArrayList
import kotlin.collections.HashMap

lateinit var board: Array<Array<Int>>
lateinit var visit: Array<Array<Boolean>>
var tree = HashMap<Int, HashMap<Int, ArrayList<Pair<Int, Int>>>>()

fun updateTree(x: Int, y: Int, i: Int, j: Int) {
    if(!tree.containsKey(x)) {
        tree[x] = HashMap()
    }
    if(!tree[x]!!.containsKey(y)) {
        tree[x]!![y] = ArrayList()
    }
    if(!tree[x]!![y]!!.contains(Pair(i, j))) {
        tree[x]!![y]!!.add(Pair(i, j))
    }
}

fun main() {
    // 일단 테이블 만들기
    val n = readLine()!!.toInt()
    board = Array<Array<Int>>(n) { _ -> Array<Int>(n) { _ -> 0 } }
    visit = Array<Array<Boolean>>(n) { _ -> Array<Boolean>(n) { _ -> false } }

    for(i in 0 until n) {
        val table = readLine()!!.chunked(1).map(String::toInt).toTypedArray()
        board[i] = table
    }

    // 그래프 구조 작성
    // (x, y)에서 출발하여 다른 좌표로 이어지는 그래프 작성
    for(i in 0 until n) {
        for(j in 0 until n) {
            if(board[i][j] == 1) {
                // 상하좌우를 검사하여 연결되어있는 노드는 추가
                if(i > 0 && board[i-1][j] == 1) {
                    updateTree(i, j, i-1, j)
                    updateTree(i-1, j, i, j)
                }

                if(j > 0 && board[i][j-1] == 1) {
                    updateTree(i, j, i, j-1)
                    updateTree(i, j-1, i, j)
                }

                if(i < n-1 && board[i+1][j] == 1) {
                    updateTree(i, j, i+1, j)
                    updateTree(i+1, j, i, j)
                }

                if(j < n-1 && board[i][j+1] == 1) {
                    updateTree(i, j, i, j+1)
                    updateTree(i, j+1, i, j)
                }
            }
        }
    }

    trace(n)
    println(countArr.size)
    countArr.sort()
    for(x in countArr) {
        println(x)
    }
}

var countArr = ArrayList<Int>()
var count = 0
fun trace(n: Int) {
    for(i in 0 until n) {
        for(j in 0 until n) {
            if(!visit[i][j]) {
                if(board[i][j] == 0) {
                    visit[i][j] = true
                    continue
                }
                else {
                    count = 0
                    DFS(i, j)
                    countArr.add(count)
                }
            }
        }
    }
}

fun DFS(i: Int, j: Int) {
    visit[i][j] = true
    count++
    if(tree.containsKey(i)) {
        if(tree[i]!!.containsKey(j)) {
            val next = tree[i]!![j]!!

            for(x in next) {
                if(!visit[x.first][x.second]) {
                    DFS(x.first, x.second)
                }
            }
        }
    }
}