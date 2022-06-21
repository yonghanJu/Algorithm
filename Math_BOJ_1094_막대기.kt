// 2022-06-22
// https://www.acmicpc.net/problem/1094

import java.util.*

class Solution {
    fun solution(n:Int){
        val pq = PriorityQueue<Int>()
        pq.add(64)
        var total = 64
        while(total!=n){
            val small = pq.poll()
            if(total - small/2 >= n){
                total -= small/2
            }else{
                pq.add(small/2)
            }
            pq.add(small/2)
        }
        println(pq.size)
    }
}

fun main() {
    Solution().solution(readLine()!!.toInt())
}
