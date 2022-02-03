// 2022-02-03
// https://www.acmicpc.net/problem/15965

import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val max = 7368791
    val n = readLine().toInt()
    val primeB = BooleanArray(max+1)
    val list = ArrayList<Int>()

    var count =0
    for(i in 2 ..max){
        if(primeB[i]) continue
        list.add(i)
        if(count == 500000) break
        count++
        var j =2
        while( i*j <max){
            primeB[i*j] = true
            j++
        }
    }
    print(list[n-1])
}
