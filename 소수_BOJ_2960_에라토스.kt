// 2022-01-31
// https://www.acmicpc.net/problem/2960

import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val nk = readLine().split(' ')
    val n = nk[0].toInt()
    val k = nk[1].toInt()
    val arr = BooleanArray(n + 1) { false }
    var answer = 0

    for (i in 2..n) {
        var j =1
        while(i*j<=n){
            if(!arr[i*j]) answer++
            if(answer==k) {
                print(i*j)
                return
            }
            arr[i*j] = true
            j++
        }
    }
    println(arr)
}
