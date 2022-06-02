// 2022-06-02
// https://www.acmicpc.net/problem/10216

import java.util.*

class Solution {
    lateinit var isVisited:BooleanArray
    lateinit var gArr:Array<IntArray>
    var size = 0
    fun solution(arr:Array<IntArray>) :Int{
        var answer =0
        gArr = arr
        size = arr.size
        isVisited = BooleanArray(size)

        for(i in arr.indices){
            answer += dfs(i)
        }

        return answer
    }

    fun dfs(idx:Int):Int{
        if(isVisited[idx]) return 0

        isVisited[idx]=true
        for(i in isVisited.indices){
            if(isVisited[i]) continue
            val dx = Math.abs(gArr[i][0] - gArr[idx][0])
            val dy = Math.abs(gArr[i][1] - gArr[idx][1])
            val r = gArr[i][2]+gArr[idx][2]
            if( dx*dx+dy*dy <= r*r ){
                dfs(i)
            }
        }

        return 1
    }
}

fun main() {
    repeat(readLine()!!.toInt()){
        println(Solution().solution(Array(readLine()!!.toInt()){ readLine()!!.split(' ').map{it.toInt()}.toIntArray() }))
    }
}
