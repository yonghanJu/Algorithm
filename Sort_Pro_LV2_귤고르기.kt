class Solution {
    fun solution(k: Int, tangerine: IntArray): Int {
        var answer: Int = 0
        val map = mutableMapOf<Int, Int>()
        
        tangerine.forEach {
            if(map[it] == null) map[it] = 0
            map[it] = map[it]!! + 1
        }
        
        
        var remainK = k 
        map.toList().sortedBy { -it.second }.forEach { (key, v) ->
            if(remainK > 0) {
                remainK -= v
                answer++
            }
        }
        
        return answer
    }
}
