// https://school.programmers.co.kr/learn/courses/30/lessons/150369
// 2023-07-18

class Solution {
    fun solution(cap: Int, n: Int, deliveries: IntArray, pickups: IntArray): Long {
        var answer: Long = 0
        
        val delQ = ArrayDeque<Pair<Int, Int>>()
        val pickQ = ArrayDeque<Pair<Int, Int>>()
        for(i in 0 until n) {
            if(deliveries[i] != 0) delQ.addLast(Pair(i + 1, deliveries[i]))
            if(pickups[i] != 0) pickQ.addLast(Pair(i + 1, pickups[i]))
        }
        
        while(delQ.isNotEmpty() || pickQ.isNotEmpty()) {
            var maxIndex = 0
            var dc = cap
            while(dc > 0 && delQ.isNotEmpty()) {
                var (index, del) = delQ.removeLast()
                if(del > dc) delQ.addLast(Pair(index, del - dc))
                dc -= del
                maxIndex = maxOf(maxIndex, index)
            }
            
            var pc = cap
            while(pc > 0 && pickQ.isNotEmpty()) {
                val (index, pick) = pickQ.removeLast()
                if(pick > pc) pickQ.addLast(Pair(index, pick - pc))
                pc -= pick
                maxIndex = maxOf(maxIndex, index)
            }
            answer += maxIndex.toLong()
        }
        
        return answer * 2.toLong()
    }
}
