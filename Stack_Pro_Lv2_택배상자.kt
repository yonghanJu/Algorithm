import java.util.*

class Solution {
    fun solution(order: IntArray): Int {
        var answer: Int = 0
        val stack = Stack<Int>()
        repeat(order.size) { stack.add(order.size - it) }
        val tmp = Stack<Int>()
        var curIndex = 0
        while (curIndex < order.size) {
            if (tmp.isNotEmpty() && tmp.peek() == order[curIndex]) { // 스택꺼내기
                tmp.pop()
                answer++
                curIndex++
                continue
            }
            
            if (stack.isNotEmpty() && stack.peek() == order[curIndex]) {
                stack.pop()
                answer++
                curIndex++
                continue
            } else if (stack.isNotEmpty()) {
                tmp.add(stack.pop())
                continue
            }
            break
        }
        return answer
    }
}
