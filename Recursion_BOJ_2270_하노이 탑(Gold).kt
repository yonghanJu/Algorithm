// 2022-03-21
// https://www.acmicpc.net/problem/2270

import java.io.*
import java.util.*
import kotlin.math.pow

lateinit var pos:IntArray
lateinit var modArr:IntArray
const val mod = 1000000
var answer = 0

fun main()= with(BufferedReader(InputStreamReader(System.`in`))) {
    val n =readLine().toInt()
    modArr = IntArray(100001)
    modArr[1]=1
    for(i in 2..100000){
        modArr[i] = (modArr[i-1]*2) %1000000
    }
    pos = IntArray(n+1)
    val (a,b,c) = readLine().split(' ').map{it.toInt()}
    readLine().split(' ').map{it.toInt()}.forEach { pos[it]=1 }
    readLine().split(' ').map{it.toInt()}.forEach { pos[it]=2 }
    readLine().split(' ').map{it.toInt()}.forEach { pos[it]=3 }

    re(n,pos[n])
    println(pos[n])
    println(answer)
}

fun re(size:Int, to:Int){
    if(size==0) return

    if(pos[size]==to) re(size-1,to)
    else{
        var tmp=0
        for(i in 1..3){
            if(i!=to && pos[size]!=i) tmp=i
        }
        re(size-1,tmp)
        answer = (answer + modArr[size])%1000000
    }
}
