fun main() {
    val str = readLine()!!.split(" ")
    val v1 = str[0].toInt()
    val v2 = str[1].toInt()
    val v3 = str[2].toInt()

    println((v1+v2)%v3)
    println(((v1%v3)+(v2%v3))%v3)
    println((v1*v2)%v3)
    println(((v1%v3)*(v2%v3))%v3)
}