// 2022-02-09
// https://www.acmicpc.net/problem/1016

import java.io.*
import java.util.*
import kotlin.math.sqrt


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val mm = readLine().split(' ')
    val min = mm[0].toLong()
    val max = mm[1].toLong()
    var answer = max - min +1
    val arr = BooleanArray(answer.toInt())
    var m = sqrt(max.toDouble()).toInt()

    for(i in 2..m){
        var j =i*i.toLong()
        var start = if(min%j==0L) min/j else min/j +1L
        var k = start
        while(k*j<=max){
            arr[(k*j-min).toInt()]=true
            k++
        }
    }

    arr.forEach { if(it) answer-- }
    println(answer)
}
