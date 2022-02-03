// 2022-02-03
// https://www.acmicpc.net/problem/4948

import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val list = ArrayList<Int>()
    val primeList = ArrayList<Int>()
    val sb = StringBuilder()
    var max = 0


    while(true){
        val num = readLine().toInt()
        if(num==0) break else list.add(num)
        max = if(max>num) max else num
    }

    val notPrime = BooleanArray(max*2+1)

    for(i in 2..max*2){
        if(notPrime[i]) continue
        primeList.add(i)
        var j =2
        while(i*j<=max*2){
            notPrime[i*j]=true
            j++
        }
    }

    for(i in list){
        var answer =0
        for(p in primeList){
            if(p<=i) continue
            if(p>i*2) break else answer++
        }
        sb.append(answer).append('\n')
    }

    print(sb)
}
