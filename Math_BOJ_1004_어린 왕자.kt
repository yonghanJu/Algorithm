// 2022-07-11
// https://www.acmicpc.net/problem/1004

class Solution {
    fun solution(repeat:Int){
        repeat(repeat){
            val (startX, startY, endX, endY) = readLine()!!.split(' ').map{it.toInt()}
            val n = readLine()!!.toInt()
            var count = 0
            for(i in 0 until n) {
                val (x, y, r) = readLine()!!.split(' ').map{it.toInt()}
                val a = Math.pow((x - startX).toDouble(),(2.toDouble())) + Math.pow((y - startY).toDouble(),(2.toDouble())) - r*r
                val b = Math.pow((x - endX).toDouble(),(2.toDouble())) + Math.pow((y - endY).toDouble(),(2.toDouble())) - r*r
                if(a*b<0) count++
            }
            println(count)
        }
    }
}

fun main() {
    Solution().solution(readLine()!!.toInt())
}
