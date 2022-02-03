// 2022-02-03
// https://www.acmicpc.net/problem/11502

import java.io.*
import java.util.*

private lateinit var prime:BooleanArray
private lateinit var list:ArrayList<Int>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val sb = StringBuilder()
    val target = IntArray(n)
    var max = 0
    repeat(n){
        val num = readLine().toInt()
        max = if(max > num) max else num
        target[it] = num
    }

    prime = BooleanArray(max+1)
    list = ArrayList()
    for(i in 2..max){
        if(prime[i]) continue
        list.add(i)
        var j = 2
        while(i*j<=max){
            prime[i*j] = true
            j++
        }
    }

    outer@for(it in 0 until n){

        for(p1 in list){
            for(p2 in list){
                for(p3 in list){
                    if(p1+p2+p3 == target[it]) {
                        sb.append("${p1} ${p2} ${p3}\n")
                        continue@outer
                    }
                }
            }
        }
        sb.append(0).append('\n')
    }
    print(sb)
}
