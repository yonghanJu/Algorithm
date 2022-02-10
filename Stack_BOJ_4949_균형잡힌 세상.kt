// 2022-02-10
// https://www.acmicpc.net/problem/4949

import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var str = readLine()
    val sb = StringBuilder()

    outer@while(str[0] != '.'){

        val stack = Stack<Char>()

        for(c in str){
            if(c=='(' || c=='[') stack.add(c)
            else{
                when(c){
                    ']'->{
                        if(!stack.isEmpty() && stack.peek() =='[') stack.pop()
                        else{
                            sb.append("no\n")
                            str = readLine()
                            continue@outer
                        }
                    }
                    ')'->{
                        if(!stack.isEmpty() && stack.peek() =='(') stack.pop()
                        else{
                            sb.append("no\n")
                            str = readLine()
                            continue@outer
                        }
                    }
                }
            }
        }
        if(stack.empty()) sb.append("yes\n") else sb.append("no\n")

        str = readLine()
    }

    print(sb)
}
