import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

// 문제 특성상 반드시 BFS로만 풀어야 한다
// DFS로 하면 되돌아오기까지 시간이 너무 오래 걸려서 안됨

fun main() {
    val (n, m) = readLine()!!.split(" ").map(String::toInt)
    val board = Array(n) { _ -> Array(m) { _ -> 0 } }

    for(i in 0 until n) {
        val line = readLine()!!.chunked(1).map(String::toInt).toTypedArray()
        board[i] = line
    }

    // 그래프 만들기
    val graph = HashMap<Int, HashMap<Int, ArrayList<Pair<Int, Int>>>>()

    for(i in 0 until n) {
        for(j in 0 until m) {
            if(board[i][j] == 1) {
                if(i > 0 && board[i-1][j] == 1) {
                    createGraph(graph, i, j, i-1, j)
                    createGraph(graph, i-1, j, i, j)
                }
                if(j > 0 && board[i][j-1] == 1) {
                    createGraph(graph, i, j, i, j-1)
                    createGraph(graph, i, j-1, i, j)
                }
                if(i < n-1 && board[i+1][j] == 1) {
                    createGraph(graph, i, j, i+1, j)
                    createGraph(graph, i+1, j, i, j)
                }
                if(j < m-1 && board[i][j+1] == 1) {
                    createGraph(graph, i, j, i, j+1)
                    createGraph(graph, i, j+1, i, j)
                }
            }
        }
    }

    trace(graph, n, m)
}

fun createGraph(graph: HashMap<Int, HashMap<Int, ArrayList<Pair<Int, Int>>>>,
                ox: Int, oy: Int, tx: Int, ty: Int) {
    if(!graph.containsKey(ox))
        graph[ox] = HashMap()

    if(!graph[ox]!!.containsKey(oy))
        graph[ox]!![oy] = ArrayList()

    if(!graph[ox]!![oy]!!.contains(Pair(tx, ty)))
        graph[ox]!![oy]!!.add(Pair(tx, ty))
}

fun trace(graph: HashMap<Int, HashMap<Int, ArrayList<Pair<Int, Int>>>>,
          n: Int, m: Int) {
    val visited = Array(n) { _ -> Array(m) { _ -> false } }
    // (0, 0)에서 시작하여 (n-1, m-1)까지 이동하는데 걸린 횟수 검사
    bfs(graph, visited, n, m)
}

fun bfs(graph: HashMap<Int, HashMap<Int, ArrayList<Pair<Int, Int>>>>,
        visited: Array<Array<Boolean>>,
        n: Int, m: Int) {
    val queue = LinkedList<Pair<Int, Int>>()
    queue.add(Pair(0, 0))
    var count = 0

    val nextqueue = LinkedList<Pair<Int, Int>>()
    while(!queue.isEmpty()) {
        val next = queue.poll()

        if(next.first == n-1 && next.second == m-1) {
            println(count+1)
            break
        }
        if(visited[next.first][next.second]) {
            if(queue.size == 0) {
                count++
                queue.addAll(nextqueue)
                nextqueue.clear()
            }
            continue
        }

        visited[next.first][next.second] = true

        if(graph.containsKey(next.first)) {
            if(graph[next.first]!!.containsKey(next.second)) {
                val nextlist = graph[next.first]!![next.second]!!
                nextqueue.addAll(nextlist)
            }
        }

        if(queue.size == 0) {
            count++
            queue.addAll(nextqueue)
            nextqueue.clear()
        }
    }
}