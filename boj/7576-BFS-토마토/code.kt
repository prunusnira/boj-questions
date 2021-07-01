import java.util.*

// 문제 특성상 반드시 DFS로만 풀어야 한다
// 첫 칸에서 주어진 마지막 칸 까지 이동하는 문제이다
val bfsqueue = LinkedList<Pair<Int, Int>>()

fun main() {
    val (m, n) = readLine()!!.split(" ").map(String::toInt)
    val board = Array(n) { _ -> Array(m) { _ -> 0 } }

    for(i in 0 until n) {
        val line = readLine()!!.split(" ").map(String::toInt).toTypedArray()
        board[i] = line
    }

    // 최초 그래프를 만들 때 옆에 0이 있는 1들을 queue에 등록한다
    var isZeroExist = false
    for(i in 0 until n) {
        for(j in 0 until m) {
            if(board[i][j] == 1) {
                if(i > 0 && board[i-1][j] == 0) {
                    bfsqueue.add(Pair(i, j))
                }
                if(j > 0 && board[i][j-1] == 0) {
                    bfsqueue.add(Pair(i, j))
                }
                if(i < n-1 && board[i+1][j] == 0) {
                    bfsqueue.add(Pair(i, j))
                }
                if(j < m-1 && board[i][j+1] == 0) {
                    bfsqueue.add(Pair(i, j))
                }
            }

            // 만약 사방이 빈 칸이면 (-1로 모두 가로막혀 있으면) 불가능 판정
            else if(board[i][j] == 0) {
                isZeroExist = true
                var l = true
                var r = true
                var u = true
                var d = true

                if(i > 0) {
                    if(board[i - 1][j] == -1) l = false
                }
                else {
                    l = false
                }

                if(j > 0) {
                    if(board[i][j-1] == -1) u = false
                }
                else {
                    u = false
                }

                if(i < n-1) {
                    if(board[i+1][j] == -1) r = false
                }
                else {
                    r = false
                }

                if(j < m-1) {
                    if(board[i][j+1] == -1) d = false
                }
                else {
                    d = false
                }

                // -1을 출력하고 종료
                if(!l && !r && !u && !d) {
                    println(-1)
                    return
                }
            }
        }
    }

    // board에 0이 전혀 없으면 0 출력하고 종료
    if(!isZeroExist) {
        println(0)
        return
    }

    bfs(board, n, m)
}

fun bfs(board: Array<Array<Int>>, n: Int, m: Int) {
    var count = -1
    val nextqueue = LinkedList<Pair<Int, Int>>()

    while(!bfsqueue.isEmpty()) {
        val next = bfsqueue.poll()

        // next를 기준으로 상하좌우를 확인하고 0이 있으면 1로 바꾸고 queue에 등록, -1이 있으면 스킵
        val i = next.first
        val j = next.second

        if(i > 0) {
            if(board[i-1][j] == 0) {
                board[i-1][j] = 1
                nextqueue.add(Pair(i-1, j))
            }
        }
        if(j > 0) {
            if(board[i][j-1] == 0) {
                board[i][j-1] = 1
                nextqueue.add(Pair(i, j-1))
            }
        }
        if(i < n-1) {
            if(board[i+1][j] == 0) {
                board[i+1][j] = 1
                nextqueue.add(Pair(i+1, j))
            }
        }
        if(j < m-1) {
            if(board[i][j+1] == 0) {
                board[i][j+1] = 1
                nextqueue.add(Pair(i, j+1))
            }
        }

        if(bfsqueue.size == 0) {
            count++
            bfsqueue.addAll(nextqueue)
            nextqueue.clear()
        }
    }

    // 다 끝난 후 0이 남아있으면 -1 출력, 아니면 카운트 출력
    for(i in 0 until n) {
        for(j in 0 until m) {
            if(board[i][j] == 0) {
                println(-1)
                return
            }
        }
    }
    println(count)
}