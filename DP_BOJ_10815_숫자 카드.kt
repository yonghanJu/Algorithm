// 2022-06-13
// https://www.acmicpc.net/problem/10815

import java.util.*

class Solution {
    fun solution(list1:List<Int>, list2:List<Int>){
        val map = list2.associateBy { it }
        val answer = IntArray(list1.size)
        list1.forEachIndexed { idx, it->
            map[it]?.let{ answer[idx]=1 }
        }
        println(answer.run{
            val sb = StringBuilder()
            this.forEach { sb.append(it).append(' ')}
            sb
        })
    }
}

fun main() {
    readLine()!!
    val list1 = readLine()!!.split(' ').map{it.toInt()}
    readLine()!!
    val list2 = readLine()!!.split(' ').map{it.toInt()}
    Solution().solution(list2, list1)
}
