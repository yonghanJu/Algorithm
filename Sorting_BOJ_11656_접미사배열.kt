// 2022-05-27
// https://www.acmicpc.net/problem/11656

import java.util.*

class Solution {
    fun solution(str:String) {
        val list = List(str.length){str.substring(it until str.length)}
        list.sorted().forEach { println(it) }
    }
}

fun main() {
    Solution().solution(readLine()!!)
}
