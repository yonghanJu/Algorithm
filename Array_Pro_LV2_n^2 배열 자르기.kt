// 2022-06-29
// https://programmers.co.kr/learn/courses/30/lessons/87390 (n^2 배열 자르기)

class Solution {
    fun solution(n: Int, left: Long, right: Long): IntArray {
        var answer = mutableListOf<Int>()

        var index = left
        while(index<=right){
            val x = (index/n).toInt() +1
            val y = (index%n).toInt() +1
            answer.add( if(x >= y) x else y)
            index++
        }
        
        return answer.toIntArray()
    }
}
