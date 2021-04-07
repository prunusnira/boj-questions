class Solution {
    fun solution(s: String): IntArray {
        var answer = intArrayOf()
        
        // 파싱
        val startCutArr = s.split("{")
        
        // { 로 잘랐을 때: 0, 1은 empty, 2~size까지 각 데이터가 들어감
        // 그 다음 }로 자르고[0]을 가져온 후, ','로 자르면 완성
        var tupleStr = Array<Array<Int>>(startCutArr.size - 2) { _ -> Array<Int>(0) { _ -> 0 } }
        for(i in 2 until startCutArr.size) {
            val tupleNumArr = startCutArr[i].split("}")[0].split(",")
            tupleStr[i-2] = Array<Int>(tupleNumArr.size) { _ -> 0 }
            for(j in 0 until tupleNumArr.size) {
                tupleStr[i-2][j] = Integer.parseInt(tupleNumArr[j])
            }
        }
        
        // 튜플 만들어내기
        // 원소 개수 순서대로 튜플 값이 추가되므로 정렬 후 추가되는 항목만 더해나간다
        // 빠르게 하기위해 개수를 배열에 적어두고 찾아가는 방식으로 한다
        var count = Array<Int>(tupleStr.size) { i -> tupleStr[i].size }
        val ansarr = IntArray(tupleStr.size) { _ -> 0 }
        var pos = 0
        
        for(i in 1..tupleStr.size) {
            val idx = count.indexOf(i)
            // idx의 합과 ansarr의 합을 빼어서 그것을 pos에 넣는다
            ansarr[pos] = tupleStr[idx].sum() - ansarr.sum()
            pos++
        }
        
        answer = ansarr
        
        return answer
    }
}