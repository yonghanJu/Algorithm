// 2022-05-17
// https://www.acmicpc.net/problem/2910

import java.util.*

class Solution {
    fun solution(array: List<Int>) {
        val map = HashMap<Int,Pair<Int,Int>>()
        var count =0
        val sb = StringBuilder()
        for(i in array.indices){
            if(map[array[i]]==null){
                map[array[i]]=Pair(1,count)
                count++
            }else{
                val (f,s) = map[array[i]]!!
                map[array[i]]=Pair(f+1,s)
            }
        }
        map.entries.sortedWith( compareBy<Map.Entry<Int,Pair<Int,Int>>>{ -it.value.first }.thenBy{ it.value.second} ).forEach {
            repeat(it.value.first){ _-> sb.append(it.key).append(' ') }
        }
        print(sb)
    }
}

fun main() {
    val (a, b) = readLine()!!.split(' ')
    Solution().solution( readLine()!!.split(' ').map{it.toInt()})
}
