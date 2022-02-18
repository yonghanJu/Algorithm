// 2022-02-18
// https://www.acmicpc.net/problem/1934

import java.io.*
import java.util.*

var a = 0
var b = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()

    repeat(n){
        val tmp = readLine().split(' ')
        a = tmp[0].toInt()
        b = tmp[1].toInt()
        var curA = a
        var curB = b
        while(curA%curB != 0 && curB%curA !=0){
            if(curA>curB) curA+=a else curB += b
        }
        println(maxOf(curA,curB))
    }
}
