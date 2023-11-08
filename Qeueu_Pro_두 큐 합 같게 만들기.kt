class Solution {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        var answer = 0
        var sum1 = 0L
        var sum2 = 0L
        val q1 = ArrayDeque<Int>().apply { queue1.forEach { addLast(it); sum1+= it } }
        val q2 = ArrayDeque<Int>().apply { queue2.forEach { addLast(it); sum2 += it } }
        if((sum1 + sum2) % 2 != 0L) return -1
        while(sum1 != sum2) {
            if(sum1 == 0L || sum2 == 0L || answer > queue1.size * 3) return -1
            answer++
            if(sum1 > sum2) {
                val pop = q1.removeFirst()
                q2.addLast(pop)
                sum1 -= pop
                sum2 += pop
            } else {
                val pop = q2.removeFirst()
                q1.addLast(pop)
                sum1 += pop
                sum2 -= pop
            }
        }
        return answer
    }
}
