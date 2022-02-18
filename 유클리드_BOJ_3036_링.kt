// 2022-02-18
// https://www.acmicpc.net/problem/3036

import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val rings = readLine().split(' ').map{it.toInt()}
    repeat(n-1){
        val lcm = lcm(rings[0], rings[it+1])
        println( "${rings[0]/lcm}/${rings[it+1]/lcm}" )
    }
}

fun lcm(a:Int, b:Int):Int{
    return if(b == 0) a else lcm( maxOf(b,a%b),minOf(b,a%b))
}
