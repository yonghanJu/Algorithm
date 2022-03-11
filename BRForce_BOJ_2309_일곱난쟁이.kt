// 2022-03-12
// https://www.acmicpc.net/problem/2309

import java.io.*
import java.util.*


lateinit var list:IntArray
lateinit var answer:IntArray
var t=0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    list = IntArray(9){readLine().toInt()}
    answer = IntArray(7)
    list.forEachIndexed{idx,_->
        if(bf(idx,0)) answer.sortedBy{it}.forEach{println(it)}.let{return}
    }

}

fun bf(index:Int,depth:Int):Boolean{
    t +=list[index]
    if(depth==6 && t ==100){
        answer[depth] = list[index]
        return true
    }
    for(i in index+1..8){
        if(bf(i,depth+1)){
            answer[depth] = list[index]
            return true
        }

    }
    t-=list[index]
    return false
}
