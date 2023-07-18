// https://school.programmers.co.kr/learn/courses/30/lessons/150368
// 2023-07-18

import java.util.*

class Solution {
    var emoticonSize = 0
    val stack = Stack<Int>()
    val answer = IntArray(2)
    fun solution(users: Array<IntArray>, emoticons: IntArray): IntArray {
        emoticonSize = emoticons.size
        dfs(emoticons.toList(), users)
        
        return answer
    }
    
    fun dfs(emoticons: List<Int>, users: Array<IntArray>) {
        if(stack.size == emoticonSize) {
            val (member, sale) = sol(stack.toList(), emoticons, users)
            if(answer[0] <= member && ( answer[0] < member || answer[1] < sale)) {
                
                    answer[0] = member
                    answer[1] = sale
            }
        } else {
            for(i in 0..3) {
                stack.add(i)
                dfs(emoticons, users)
                stack.pop()
            }
        }
    }
    
    fun sol(discountList: List<Int>, emoticons: List<Int>, users: Array<IntArray>) : Pair<Int, Int> {
        val discounts = listOf(10, 20, 30, 40)
        
        var member = 0
        var sale = 0
        
        users.forEach { user ->
            var buy = 0
            discountList.forEachIndexed { index, dis ->
                if(user[0] <= discounts[dis]) {
                    buy += ((emoticons[index] * (100-discounts[dis])) / 100.toDouble()).toInt()
                }
            }
            if(buy >= user[1]) member++ else sale += buy
        }
        return Pair(member, sale)
    }
}
