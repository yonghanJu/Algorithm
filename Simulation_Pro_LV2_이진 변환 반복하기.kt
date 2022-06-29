// 2022-06-29
// https://programmers.co.kr/learn/courses/30/lessons/70129 (이진 변환 반복하기)

class Solution {
    fun solution(s: String): IntArray {
        val answer = IntArray(2)
        var str = s
        var a = 0
        var totalCount = 0
        while(str!="1"){
            val count = str.count{it=='0'}
            str = (str.length-count).toString(2)
            a++
            totalCount+= count
        }
        answer[0]=a
        answer[1]=totalCount
        return answer
    }
}
