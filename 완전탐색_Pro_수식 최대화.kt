// 2022-01-11 [카카오인턴] 수식 최대화
// https://programmers.co.kr/learn/courses/30/lessons/67257

import java.util.*;

class Solution {
    fun solution(expression: String): Long {
        var answer: Long = 0
        var opArr1= LinkedList<Char>()
        var numArr1 = LinkedList<Long>(expression.split('+','-','*').map{it.toLong()})
        expression.forEach{if(it=='+'||it == '-'||it=='*') opArr1.add(it)}
       
        //6가지 방법이 최대
        var opTimes = opArr1.size
        var case = arrayOf("+-*", "+*-", "-+*", "-*+", "*+-", "*-+")
        
        for(c in case){
            
            val numArr = LinkedList<Long>(numArr1) // 다음같이 loop마다 초기화 해줘야함
            val opArr = LinkedList<Char>(opArr1)
            
            // LinkedList는 중간에 노드가 삭제되면 오른쪽 노드들이 당겨와 자리를 메워준다
            // 또 중간에 노드를 추가 할 경우 노드들이 오른쪽으로 밀려난다
            for(i in 0..2){
                var index=0
                while(index < opArr.size){
                    if(opArr[index] == c[i]){
                        when(opArr[index]){
                            '+'-> {
                                numArr.set(index,numArr[index]+numArr[index+1])
                                numArr.removeAt(index+1)
                            }
                            '-'->{
                                numArr.set(index,numArr[index]-numArr[index+1])
                                numArr.removeAt(index+1)
                            }
                            '*'->{
                                numArr.set(index,numArr[index]*numArr[index+1])
                                numArr.removeAt(index+1)
                            }
                        }
                        opArr.removeAt(index)
                        index--
                    }
                    index++
                }
            }
            
            answer = Math.max(answer, Math.abs(numArr[0]))
        }
        
        return answer
        
    }
}
