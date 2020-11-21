fun main() {
    // 인원수
    val n = readLine()!!.toInt()
    
    // 몸무게/키 정보를 담은 리스트
    val w = ArrayList<Int>()
    val h = ArrayList<Int>()
    
    // 개별 덩치가 더 큰 사람 수를 담은 리스트
    val person = ArrayList<Int>()

    // 입력받고 초기화
    for(i in 0 until n) {
        val (lw, lh) = readLine()!!.split(" ").map(String::toInt)
        w.add(lw)
        h.add(lh)
        person.add(0)
    }

    // 덩치 정보 입력
    for(i in 0 until n) {
        for(j in i+1 until n) {
            if(w[i] > w[j] && h[i] > h[j]) person[j]++
            else if(w[i] < w[j] && h[i] < h[j]) person[i]++
        }
    }

    for(p in person) {
        print("${p+1} ")
    }
}