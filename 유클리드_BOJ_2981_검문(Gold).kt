// 2022-02-18
// https://www.acmicpc.net/problem/2981

import java.io.*
import java.util.*
import kotlin.math.sqrt

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val arr = mutableListOf<Int>()
    val answer = sortedSetOf<Int>()
    repeat(n){arr.add(readLine().toInt())}
    arr.sortBy { -it }
    var sub = arr[0]-arr[1]
    var gcd = 0
    for(i in 0 until arr.lastIndex) gcd = gcd(maxOf(gcd,arr[i]-arr[i+1]), minOf(gcd,arr[i]-arr[i+1]))
    answer.add(gcd)
    for(i in 2..sqrt(gcd.toFloat()).toInt()){
        if(gcd%i==0){
            answer.add(i)
            answer.add(gcd/i)
        }
    }
    answer.forEach{print("$it ")}
}

fun gcd(a:Int, b:Int):Int{
    return if(b == 0) a else gcd(b,a%b)
}
