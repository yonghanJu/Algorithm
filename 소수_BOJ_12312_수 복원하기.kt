// 2022-01-31
// https://www.acmicpc.net/problem/2312

import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val arr = IntArray(n)
    val primeList = ArrayList<Int>()
    val sb = StringBuilder()
    var size = 0
    repeat(n){
        val num = readLine().toInt()
        arr[it] = num
        size = if(size>num) size else num
    }

    val tmpArr = BooleanArray(size+1)

    for(i in 2..size){
        if(tmpArr[i]) continue
        primeList.add(i)
        var j=2
        while(i*j<=size){
            tmpArr[i*j] = true
            j++
        }
    }

    repeat(n){
        var num = arr[it]
        for(p in primeList){
            var count=0
            inner@while(num%p==0){
                count++
                num /= p
                if(num==1) break@inner
            }
            if(count !=0) sb.append(p).append(' ').append(count).append('\n')
        }
    }

    println(sb)


}
