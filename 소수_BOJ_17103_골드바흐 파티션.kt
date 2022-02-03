// 2022-02-03
// https://www.acmicpc.net/problem/17103

import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    lateinit var primeArr:BooleanArray
    val n = readLine().toInt()
    val arr= IntArray(n)
    var max = 0

    repeat(n){
        val num = readLine().toInt()
        arr[it] = num
        max = if(max>num) max else num
    }

    primeArr = BooleanArray(max+1)
    val list = ArrayList<Int>()
    for(i in 2..max){
        if(primeArr[i]) continue
        list.add(i)
        var j=2
        while(j*i<=max){
            primeArr[i*j]=true
            j++
        }
    }

    for(target in arr){
        var answer =0
        val map = HashSet<Int>()
        list.forEach{ i->
            if(i>=target) return@forEach
            else if(i*2==target) answer++
            else if(map.contains(i)) answer ++
            else map.add(target-i)
        }
        println(answer)

    }
}
