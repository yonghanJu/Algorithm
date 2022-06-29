// 2022-06-29
// https://programmers.co.kr/learn/courses/30/lessons/77885 (2개 이하로 다른 비트)
// Int, Long <-> 2진수 string 상호 변환 예제
// str.toInt(2), str.toLong(2), long.toString(2) 등을 활용해 상호 변환 가능

class Solution {
    fun solution(numbers: LongArray): LongArray {
        var answer: LongArray = LongArray(numbers.size)
        
        outer@for(i in numbers.indices){
            if(numbers[i]%2==0L) {
                answer[i]= numbers[i]+1L
                continue
            }
            val n = numbers[i].toString(2).toCharArray()
            for(j in n.lastIndex downTo 0){
                if(n[j]=='0'){
                    n[j]='1'
                    n[j+1]='0'
                    answer[i]=String(n).toLong(2)
                    continue@outer
                }
            }
            n[0]='0'
            answer[i]=("1"+String(n)).toLong(2)
        }
        
        return answer
    }
}
