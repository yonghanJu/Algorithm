// 2022-07-01
// https://programmers.co.kr/learn/courses/30/lessons/12951 (JadenCase 문자열 만들기)

class Solution {
    fun solution(s: String): String {
        var answer = ""
        var list = s.split(' ').map{it.toCharArray()}
        list.forEach{ cArr->
            // char 아니면 변화 x
            if(cArr.size>0) cArr[0] = cArr[0].uppercaseChar()
            for(i in 1 .. cArr.lastIndex){
                cArr[i] = cArr[i].lowercaseChar()
            }
        }
        return list.map{String(it)}.joinToString(" ")
    }
}
