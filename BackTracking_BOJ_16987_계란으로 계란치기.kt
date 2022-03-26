// 2022-03-26
// https://www.acmicpc.net/problem/16987

import java.io.*
import java.util.*

data class Egg(var s:Int, var w:Int)

var n =0
var answer = 0
lateinit var list:Array<Egg>
fun main():Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()

    list = Array(n){readLine().split(' ').let{Egg(it[0].toInt(), it[1].toInt())}}

    bt(0)
    println(answer)
}

fun bt(cur:Int){
    if(cur == n){
        var cnt = 0
        list.forEach { if(it.s <= 0) cnt++ }
        answer = maxOf(answer,cnt)
        return
    }
    if(list[cur].s <= 0 ){
        bt(cur+1)
        return
    }

    var c =false
    for(i in list.indices){
        if(i == cur) continue
        if(list[i].s<=0) continue
        c=true
        list[cur].s -= list[i].w
        list[i].s -=list[cur].w
        bt(cur+1)
        list[cur].s += list[i].w
        list[i].s += list[cur].w
    }

    if(c.not()){
        var cnt = 0
        list.forEach { if(it.s <= 0) cnt++ }
        answer = maxOf(answer,cnt)
    }
}
