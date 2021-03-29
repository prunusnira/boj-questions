/**
 * 이 코드는 문제와 관계 없이
 * '덩치가 더 큰 사람의 수로 랭킹을 매겼을 때'
 * 사용할 수 있는 코드이다
 * 
 * ...사실 처음에 조건을 제대로 이해하지 못하고 이렇게 풀었다
 */
fun main() {
    // 인원수
    val n = readLine()!!.toInt()
    
    // 몸무게/키 정보를 담은 리스트
    val w = ArrayList<Int>()
    val h = ArrayList<Int>()
    
    // 개별 덩치가 더 큰 사람 수를 담은 리스트
    val person = ArrayList<Int>()
    
    // 랭크 정보를 담은 리스트
    val rank = ArrayList<Int>()
    
    // 덩치가 큰 사람 수(person의 값)이 동일한 횟수를 저장하여 rank를 쉽게 구하기 위한 리스트
    val map = HashMap<Int, Int>()

    // 입력받고 초기화
    for(i in 0 until n) {
        val (lw, lh) = readLine()!!.split(" ").map(String::toInt)
        w.add(lw)
        h.add(lh)
        person.add(0)
        rank.add(0)
    }

    // 덩치 정보 입력
    for(i in 0 until n) {
        for(j in i+1 until n) {
            if(w[i] > w[j] && h[i] > h[j]) person[i]++
            else if(w[i] < w[j] && h[i] < h[j]) person[j]++
        }
    }

    for(p in person) {
        println(p)
    }

    // 같은 덩치 등수의 사람 수 관리
    for(p in person) {
        if(map.containsKey(p)) {
            map[p] = map[p]!!.plus(1)
        }
        else {
            map[p] = 1
        }
    }

    // person 값을 정렬된 set으로 만들어 순위를 매길 때 활용함
    var set = person.sorted().reversed().toSet().toIntArray()

    // rank 값 결정
    for(i in 0 until n) {
        val setidx = set.indexOf(person[i])
        var setSum = 0
        for(j in 0 until setidx) {
            setSum += map[set[j]]!!
        }
        rank[i] = setSum
    }

    // 출력
    for(i in 0 until n) {
        print("${rank[i]+1} ")
    }
}