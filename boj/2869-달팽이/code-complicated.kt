// 사실은 수식으로 정말 간단하게 푸는 방법이 있다...
fun main() {
    val nums = readLine()!!.split(" ").map(String::toInt)
    val up = nums[0]
    val down = nums[1]
    val height = nums[2]

    // 무조건 up > down이므로 예외처리 필요 없음
    val day = up - down
    var trial = height / day

    var trialCheck = 0

    while(true) {
        if(day * (trial - trialCheck) + down >= height) {
            trialCheck++
        }
        else {
            trialCheck--
            break
        }
    }
    print(trial - trialCheck)

    // 이렇게 하면 시간초과 됨
    /*
    var cnt = 0
    var pos = 0
    while(true) {
        // 낮 PHASE
        cnt++
        pos += up
        if(pos >= height) break

        // 밤 PHASE
        pos -= down
    }
    print(cnt)
    */
}