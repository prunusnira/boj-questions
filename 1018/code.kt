fun main() {
    val (n, m) = readLine()!!.split(" ").map(String::toInt)
    val board = Array(n) { Array(m) {' '} }
    for(idx in 0 until n) {
        val line = readLine()!!
        for(i in line.indices) {
            board[idx][i] = line[i]
        }
    }

    var maxPtn = 0
    // 각각 탐색 범위는 [0~m-8], [n~n-8]임
    for(i in 0..n-8) {
        for(j in 0..m-8) {
            // (i,j)로 시작 위치가 정해진 것이며
            // 여기서 8*8칸 이내에서 패턴 존재 여부와 개수, 시작위치 등을 기록해둔다
            var start = ' '
            var p1 = 0 // 정상 패턴 매칭 수
            var p2 = 0 // 색 반전일 때 패턴 매칭 수
            for(x in 0 until 8) {
                for(y in 0 until 8) {
                    if(x == 0 && y == 0) start = board[i][j]
                    if(start == 'B') {
                        if((x % 2 != 0 && y % 2 != 0) ||
                            (x % 2 == 0 && y % 2 == 0)) {
                            // 홀수/홀수 혹은 짝수/짝수 칸
                            if(board[i+x][j+y] == 'B') p1++
                            else p2++
                            // 색반전인 경우에 값이 더 많을 수도 있으므로 같이 체크
                        }
                        else if((x % 2 == 0 && y % 2 != 0) ||
                                (x % 2 != 0 && y % 2 == 0)) {
                            // 짝수/홀수 혹은 홀수/짝수 칸
                            if(board[i+x][j+y] == 'W') p1++
                            else p2++
                        }
                    }
                    else if(start == 'W') {
                        if((x % 2 != 0 && y % 2 != 0) ||
                            (x % 2 == 0 && y % 2 == 0)) {
                            if(board[i+x][j+y] == 'W') p1++
                            else p2++
                        }
                        else if((x % 2 == 0 && y % 2 != 0) ||
                                (x % 2 != 0 && y % 2 == 0)) {
                            if(board[i+x][j+y] == 'B') p1++
                            else p2++
                        }
                    }
                }
            }

            if(p1 > p2 && p1 > maxPtn) maxPtn = p1
            else if(p2 > p1 && p2 > maxPtn) maxPtn = p2
            else if(p1 == p1 && p1 > maxPtn) maxPtn = p1
        }
    }

    print(64 - maxPtn)
}