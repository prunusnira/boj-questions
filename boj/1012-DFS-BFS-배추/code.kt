import kotlin.collections.ArrayList
import kotlin.collections.HashMap

var count = 0
fun main() {
    val t = readLine()!!.toInt()

    for(x in 0 until t) {
        count = 0
        val (m, n, k) = readLine()!!.split(" ").map(String::toInt)

        val board = Array(m) { _ -> Array(n) { _ -> 0 } }
        val dfsvisit = Array(m) { _ -> Array(n) { _ -> false } }
        var graph = HashMap<Int, HashMap<Int, ArrayList<Pair<Int, Int>>>>()

        for(y in 0 until k) {
            val (kx, ky) = readLine()!!.split(" ").map(String::toInt)
            board[kx][ky] = 1
        }

        // 배추 위치별 탐색 그래프 작성
        for(i in 0 until m) {
            for(j in 0 until n) {
                if(board[i][j] == 1) {
                    if(i > 0 && board[i-1][j] == 1) {
                        updateTree(graph, i, j, i-1, j)
                        updateTree(graph, i-1, j, i, j)
                    }

                    if(j > 0 && board[i][j-1] == 1) {
                        updateTree(graph, i, j-1, i, j)
                        updateTree(graph, i, j, i, j-1)
                    }

                    if(i < m-1 && board[i+1][j] == 1) {
                        updateTree(graph, i, j, i+1, j)
                        updateTree(graph, i+1, j, i, j)
                    }

                    if(j < n-1 && board[i][j+1] == 1) {
                        updateTree(graph, i, j, i, j+1)
                        updateTree(graph, i, j+1, i, j)
                    }
                }
            }
        }

        // 탐색 - 전체 보드를 탐색해야 함
        trace(board, graph, dfsvisit, m, n)
        println(count)
    }
}

fun updateTree(tree: HashMap<Int, HashMap<Int, ArrayList<Pair<Int, Int>>>>,
               x: Int, y: Int, i: Int, j: Int) {
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

fun trace(board: Array<Array<Int>>,
        graph: HashMap<Int, HashMap<Int, ArrayList<Pair<Int, Int>>>>,
          dfsvisit: Array<Array<Boolean>>,
          m: Int, n: Int) {
    for(i in 0 until m) {
        for(j in 0 until n) {
            if(!dfsvisit[i][j]) {
                if(board[i][j] == 0) {
                    dfsvisit[i][j] = true
                    continue
                }
                else {
                    // dfs로 다 순환시키면서 visit = true로 만들고
                    // count 1 추가
                    dfs(graph, dfsvisit, i, j)
                    count++
                }
            }
        }
    }
}

fun dfs(graph: HashMap<Int, HashMap<Int, ArrayList<Pair<Int, Int>>>>,
        dfsvisit: Array<Array<Boolean>>,
        i: Int, j: Int) {
    dfsvisit[i][j] = true
    if(graph.containsKey(i)) {
        if(graph[i]!!.containsKey(j)) {
            val next = graph[i]!![j]!!
            for(nextnode in next) {
                if(!dfsvisit[nextnode.first][nextnode.second]) {
                    dfs(graph, dfsvisit, nextnode.first, nextnode.second)
                }
            }
        }
    }
}