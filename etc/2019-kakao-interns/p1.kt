class Solution {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var answer = 0
        
        val stack = Array<Int>(moves.size) { _ -> 0}
        var pos = 0
        for(i in 0 until moves.size) {
            // 검사할 번호 확인
            val col = moves[i] - 1
            
            // 검사할 높이
            var colh = 0
            while(colh < board.size) {
                if(board[colh][col] == 0) {
                    colh++
                    continue
                }
                break
            }
            
            // 바닥까지 없으면 다음으로 넘김
            if(colh == board.size) continue
            
            // 현재 위치의 인형번호를 가져와서 스택에 넣음 (넣은 인형은 삭제)
            val doll = board[colh][col]
            stack[pos] = doll
            board[colh][col] = 0
            
            // 2개가 만났을 때 pop 조건 검사 및 실행
            // 주의: 항상 최상단에서만 pop이 발생한다
            if(pos > 0) {
                if(stack[pos-1] == stack[pos]) {
                    answer += 2
                    stack[pos-1] = 0
                    stack[pos] = 0
                    pos -= 2
                }
            }
            pos++
        }
        
        return answer
    }
}