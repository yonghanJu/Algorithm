// 2022-01-08
// https://programmers.co.kr/learn/courses/30/lessons/76502#

import java.util.*;

class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0
        val list = ArrayList<Char>()
        val stack = Stack<Char>()
        val answerstack = Stack<Char>()
        val q:Queue<Char> = LinkedList<Char>()
        var tmp = s.toCharArray()
        
        for(c in tmp) {
            q.add(c)
            stack.add(c)
        }
        
        var cnt = 0
        var t = q.peek()
        var last = stack.pop()
        while(stack.size>=cnt){
            
            if( (t=='[' ||t=='{' || t=='(') && (last=='}' || last ==']' || last== ')')){
                q.forEach{c->
                    if(answerstack.size>0){
                        var b = answerstack.peek()
                        if((b=='['&& c ==']') || (b=='{'&& c =='}') || (b=='('&& c ==')')) {
                            answerstack.pop()
                            if(answerstack.size==0) answer++
                        }else answerstack.add(c)
                    }else answerstack.add(c)
                    
                }
                if(answerstack.size==0){
                    return answer
                } else {
                    answerstack.clear()
                    answer = 0
                }
            }
            
            var a = q.poll()    
                q.add(a)
                cnt++
                t = q.peek()
                last = a
        }
        
        return answer
    }
}
