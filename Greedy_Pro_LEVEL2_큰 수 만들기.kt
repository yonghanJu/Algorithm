// 2022-06-26
// https://programmers.co.kr/learn/courses/30/lessons/42883?language=kotlin(큰 수 만들기)

class Solution {
    fun solution(number: String, k: Int): String {
        var answer = StringBuilder()
        var lastIndex = 0
        
        // number.length-k 개를 뽑기
        for(i in 0 until number.length-k ){
            var max = '0'
            for(j in lastIndex .. k+i){
                if(number[j]>max){
                    max = number[j]
                    lastIndex = j+1
                }
            }
            answer.append(max)
        }
        return String(answer)
    }
}
