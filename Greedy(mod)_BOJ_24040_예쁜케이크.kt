// 2022-03-20
// https://www.acmicpc.net/problem/24040

import java.io.*
import java.util.*

fun main()= with(BufferedReader(InputStreamReader(System.`in`))) {
    val case = readLine().toInt()
    repeat(case){
        val n = readLine().toLong()
        println(if(n%3==2L || n%9==0L)  "TAK" else "NIE")
    }
}
