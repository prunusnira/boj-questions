fun main() {
    val n = readLine()!!.toInt()
    for(i in 0 until n) {
        val nums = readLine()!!.split(" ").map(String::toInt)
        val floor = nums[0]
        val room = nums[1]
        val customer = nums[2]

        var roomNum = customer / floor
        var floorNum = customer % floor

        if(floorNum == 0) {
            roomNum--
            floorNum = floor
        }
        roomNum++

        var rmstr = roomNum.toString()
        if(roomNum < 10) {
            rmstr = "0$roomNum"
        }
        println("$floorNum$rmstr")
    }
}