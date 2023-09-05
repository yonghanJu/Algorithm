import java.lang.StringBuilder
import java.util.*

// https://www.acmicpc.net/problem/14003
// 2023-09-05

fun main() {
    val s = Solution()
    s.solution(readln().toInt(), readln().split(' ').map { it.toInt() })
}

class Solution {
    fun solution(n: Int, list: List<Int>) {
        val dp = mutableListOf<Int>()
        val stackList = mutableListOf<Stack<Int>>()
        for (i in 0 until n) {
            val index = bSec(dp, list[i])
            if (dp.size == index) {
                dp.add(list[i])
                stackList.add(Stack())
            } else {
                dp[index] = list[i]
            }
            stackList[index].add(list[i])
        }
        dp[dp.lastIndex] = stackList.last().peek()
        for(i in stackList.lastIndex - 1 downTo 0) {
            var cur = stackList[i].pop()
            while(stackList[i].isEmpty().not() && dp[i+1] > stackList[i].peek()) {
                cur = stackList[i].pop()
            }
            dp[i] = cur
        }
        val sb = StringBuilder("${dp.size}\n")
        dp.forEach {
            sb.append(it).append(' ')
        }
        println(sb)
    }

    fun bSec(list: MutableList<Int>, num: Int): Int {
        if (list.size == 0) return 0
        if (list.last() < num) return list.size
        var start = 0
        var end = list.lastIndex
        var mid = (0 + end) / 2

        while (start < end) {
            if (list[mid] == num) {
                return mid
            } else if (list[mid] < num) {
                start = mid + 1
            } else if (list[mid] > num) end = mid - 1
            mid = (start + end) / 2
        }

        if(list[mid] < num) return mid + 1
        return mid
    }
}
