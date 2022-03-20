// 2022-03-20
// https://www.acmicpc.net/problem/20937

import java.io.*
import java.util.*

fun main()= with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val list = IntArray(50001)
    val arr = readLine().split(' ').map{it.toInt()}
    arr.forEach { list[it]++ }
    println(list.maxOrNull())
}
