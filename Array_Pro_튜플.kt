class Solution {
    fun solution(s: String): IntArray {
        val list = s.substring(2, s.lastIndex - 1).split("},{").map{ el -> el.split(',').map{ it.toInt()} }.sortedBy{ it.size }
        val answer = mutableListOf<Int>()
        val answerSet = mutableSetOf<Int>()
        
        
        list.forEach { 
            for(num in it) {
                if(answerSet.contains(num).not()) {
                    answer.add(num)
                    answerSet.add(num)
                    break
                }
            }
        }
        
        return answer.toIntArray()
    }
}
