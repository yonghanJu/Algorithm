// 2022-01-27
// https://www.acmicpc.net/problem/1918

import java.io.*
import java.util.*


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val stackA = Stack<String>()
    val stackOp = Stack<Char>()

    val str = readLine()
    for(i in str.lastIndex downTo 0){

        if (str[i] == '*' || str[i] == '/' || str[i] == ')') stackOp.add(str[i]) // *, /, 괄호열기 연산자 들어왓을 때
        else if (str[i] == '+' || str[i] == '-'){   // +, - 연산자 들어왔을 때
            while(!stackOp.empty() && !(stackOp.peek() == '+' || stackOp.peek() == '-' || stackOp.peek() == ')')) {
                stackA.add(stackA.pop()+stackA.pop()+stackOp.pop())
            }
            stackOp.add(str[i])
        }else if( str[i] =='('){ // 괄호 안 계산
            while( !stackOp.empty() && stackOp.peek() != ')') stackA.add(stackA.pop()+stackA.pop()+stackOp.pop())
            stackOp.pop()
        } else stackA.add(str[i].toString())
    }
    while (!stackOp.empty()) stackA.add(stackA.pop()+stackA.pop()+stackOp.pop())
    println(stackA.pop())

}
