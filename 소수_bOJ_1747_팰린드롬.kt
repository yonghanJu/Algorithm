// 2022-02-03
// https://www.acmicpc.net/problem/1747

import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val max = 1003001
    val n = readLine().toInt()
    val primeB = BooleanArray(max+1)
    val list = ArrayList<Int>()

    for(i in 2 ..max){
        if(primeB[i]) continue
        list.add(i)
        var j =2
        while(i*j <= max){
            primeB[i*j] = true
            j++
        }
    }

    outer@for(it in list){
        if(it < n) continue
        val str =it.toString()
        for(j in 0.. str.length/2){
            if(str[j] != str[str.length-1-j]) continue@outer
        }
        print(it)
        return
    }
}
