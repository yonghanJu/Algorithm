// 2022-06-30
// https://programmers.co.kr/learn/courses/30/lessons/12939 (최댓값과 최솟값)

class Solution {
    fun solution(s: String): String {
        var max = Int.MIN_VALUE
        var min = Int.MAX_VALUE
        s.split(' ').map{it.toInt()}.forEach{
            if(it>max) max =it
            if(it<min) min =it
        }
        return "$min $max"
    }
}
