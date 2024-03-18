import java.util.*

class Solution {
    fun solution(numbers: IntArray): IntArray {
        var answer: IntArray = IntArray(numbers.size) { -1 }
        val stack = Stack<Pair<Int, Int>>()
        for(i in numbers.indices) {
            while(stack.isNotEmpty() && stack.peek().second < numbers[i]) {
                answer[stack.pop().first] = numbers[i]
            }
            stack.add(Pair(i, numbers[i]))
        }
        return answer
    }
}
