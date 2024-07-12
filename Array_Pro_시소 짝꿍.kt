class Solution {
    fun solution(weights: IntArray): Long {
        var answer = 0L
        val sortedWeights = weights.sortedBy { -it }
        val weightCount = IntArray(1001)
        
        for (w in sortedWeights) {
            weightCount[w]++
            if (weightCount[w] > 1) answer += weightCount[w].toLong() - 1L
        }
        
        val map = mutableMapOf<Int, Int>()
        for (w in 1000 downTo 100) {
            // 1개 이상
            if (weightCount[w] == null) continue
            
            for (i in 2..4) {
                if (map[w * i] == null) map[w * i] = weightCount[w]
                else {
                    answer += map[w * i]!!.toLong() * weightCount[w]
                    map[w * i] = weightCount[w] + map[w * i]!!
                }
            }
        } 
        
        return answer
    }
}
