fun main() {
    val special = arrayOf("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=")
    var str = readLine()!!

    for(s in special) {
        // 단순히 알파벳 하나로 치환하여 개수를 1로 세도록 함
        str = str.replace(s, "a")
    }

    print(str.length)
}