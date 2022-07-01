// 2022-07-01
// https://programmers.co.kr/learn/courses/30/lessons/81303 (표 편집)

import java.util.*

class Solution {
    fun solution(n: Int, k: Int, cmd: Array<String>): String {
        val delStack = Stack<Int>()
        var cursor = k
        var size = n

        cmd.forEach{ c->
            when(c[0]){
                'C'->{
                    size--
                    delStack.add(cursor)
                    if(cursor==size) cursor--
                }
                'Z'->{
                    size++
                    val num = delStack.pop()
                    if(num <= cursor) cursor++
                }
                'U'->{
                    cursor-= c.split(' ')[1].toInt()
                }
                'D'->{
                    cursor+= c.split(' ')[1].toInt()
                }
            }
        }
        
        val sb = StringBuilder()
        repeat(size){sb.append('O')}
        while(delStack.isEmpty().not()){
            sb.insert(delStack.pop(),'X')
        }
        
        return String(sb)
    }
}
