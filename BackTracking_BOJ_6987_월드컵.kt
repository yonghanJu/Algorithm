// 2022-03-29
// https://www.acmicpc.net/problem/6987

import java.io.*
import java.util.*

val sb = StringBuilder()
lateinit var list:Array<IntArray>
lateinit var isVisited:Array<BooleanArray>

fun main():Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    o@for(i in 0..3){
        val tmp = readLine().split(' ')
        list = Array(6){intArrayOf(tmp[it*3].toInt(), tmp[it*3+1].toInt(), tmp[it*3+2].toInt())}
        for(it in list) { if(it.sum()!= 5){
            sb.append(0).append(' ')
            continue@o
        }}
        isVisited = Array(6){BooleanArray(6)}
        sb.append(if(dfs(0)) 1 else 0).append(' ')
    }
    println(sb)
}

fun dfs(depth:Int):Boolean{
    if(depth==6) return true
    if(list[depth][0] == 0 && list[depth][1] == 0 && list[depth][2] == 0) return dfs(depth+1)

    if(list[depth][0] > 0){
        for(i in depth+1..5){
            if(isVisited[depth][i]) continue
            if(list[i][2]>0){
                isVisited[depth][i] = true
                list[i][2]--
                list[depth][0]--
                if(dfs(depth)) return true
                list[i][2]++
                list[depth][0]++
                isVisited[depth][i] = false
            }
        }
    }else if(list[depth][1] > 0){
        for(i in depth+1..5){
            if(isVisited[depth][i]) continue
            if(list[i][1]>0){
                isVisited[depth][i]=true
                list[i][1]--
                list[depth][1]--
                if(dfs(depth)) return true
                list[i][1]++
                list[depth][1]++
                isVisited[depth][i]=false
            }
        }
    }else if(list[depth][2]>0){
        for(i in depth+1..5){
            if(isVisited[depth][i]) continue
            if(list[i][0]>0){
                isVisited[depth][i] = true
                list[i][0]--
                list[depth][2]--
                if(dfs(depth)) return true
                list[i][0]++
                list[depth][2]++
                isVisited[depth][i] = false
            }
        }
    }

    return false
}
