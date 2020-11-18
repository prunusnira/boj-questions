import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 빠른 입출력을 위해서는 BufferedReader/BufferedWriter를 쓰자는 문제
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    val size = reader.readLine().toInt()
    for(i in 0 until size) {
        val arr = reader.readLine().split(" ")
        val v1 = arr[0].toInt()
        val v2 = arr[1].toInt()
        writer.write((v1+v2).toString()+"\n")
    }
    writer.flush()
    reader.close()
    writer.close()
}