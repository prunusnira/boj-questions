fun main() {
    var strset: List<String>

    val size = readLine()?.toInt()
    strset = getInputStr(size!!)

    val result = calcPosition(strset)
    for(i in result) {
        println(i)
    }
}

fun getInputStr(size: Int) : List<String> {
    var strset = ArrayList<String>()
    for(i in 0 until size) {
        val input = readLine()
        if(input != null) {
            strset.add(input)
        }
    }
    return strset
}

/**
 * 계산을 위한 케이스 정리
 * (r1+r2 = sum / abs(r1-r2) = diff / 점 거리 = length)
 * 1. 무한대 => length == 0, r1 == r2
 * 2-1. 1점에서 만남 (외접) => length == sum
 * 2-2. 1점에서 만남 (내접) => length == diff
 * 3-1. 못만남 (멀어서) => length > sum
 * 3-2. 못만남 (원 내부) => length < diff
 * 4. 2점에서 만남 => diff < length < sum
 */
fun calcPosition(list: List<String>): List<Int> {
    val returnList = ArrayList<Int>()
    for(str in list) {
        val value = str.split(" ")
        var p1x = value[0].toInt()
        var p1y = value[1].toInt()
        var r1 = value[2].toInt()
        var p2x = value[3].toInt()
        var p2y = value[4].toInt()
        var r2 = value[5].toInt()

        val length = calcPointLength(p1x, p1y, p2x, p2y)
        val sum = (r1+r2)*(r1+r2)
        val diff = (r1-r2)*(r1-r2)

        // 각 케이스별 계산 수행
        // 무한대
        if(length == 0) {
            if(r1 == r2) {
                returnList.add(-1)
            }
            else {
                returnList.add(0)
            }
        }
        // 외접 / 내접
        else if(length == sum || length == diff) {
            returnList.add(1)
        }
        // 두 점에서 만남
        else if(length < sum && length > diff){
            returnList.add(2)
        }
        // 너무 멀리 있음 / 원의 내부
        else {
            returnList.add(0)
        }
    }
    return returnList
}

fun calcPointLength(p1x: Int, p1y: Int, p2x: Int, p2y: Int): Int {
    return (p2x-p1x)*(p2x-p1x) + (p2y-p1y)*(p2y-p1y)
}