// 2022-02-10
// https://www.acmicpc.net/problem/10799

import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var answer =0
    var index =0
    val str = readLine()
    val stack = Stack<Pair<Int,Char>>() // index,value

    for(c in str){
        when(c){
            ')' ->{
                if(!stack.empty() && stack.peek().second=='('){
                    val tmp = stack.pop()
                    if(tmp.first+1==index) answer+= stack.size else answer++
                }
            }
            else -> stack.add(Pair(index,'('))
        }
        index++
    }
    print(answer)
}
