// 2023-04-06
//https://school.programmers.co.kr/learn/courses/30/lessons/178870

class Solution {
    fun solution(sequence: IntArray, k: Int): IntArray {
        var answer: IntArray = intArrayOf(0, sequence.lastIndex)
        var startIndex = 0
        var endIndex = 0
        val psum = IntArray(sequence.size)
        psum[0] = sequence[0]
        for(i in 1..sequence.lastIndex){
            psum[i] = psum[i-1] + sequence[i]
        }
        
        while(startIndex in sequence.indices && endIndex in sequence.indices) {
            val sum = psum[endIndex] - if(startIndex==0) 0 else psum[startIndex-1]
            if(sum > k) {
                startIndex++
            } else if(sum < k) {
                endIndex++
            } else {
                if(endIndex - startIndex < answer[1] - answer[0]) {
                    answer[0] = startIndex
                    answer[1] = endIndex
                }
                if(startIndex == endIndex) endIndex++ else startIndex++
            }
        }
        return answer
    }
}
