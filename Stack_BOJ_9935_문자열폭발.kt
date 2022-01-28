// 2022-01-28
// https://programmers.co.kr/learn/courses/30/lessons/42890

import java.io.*
import java.util.*


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val stack = Stack<Char>()
    val str = readLine()
    val target = readLine()
    var cnt = 0

    str.forEach {
        if(target[target.lastIndex]==it) {
            var tmp = CharArray(target.length-1)
            while(cnt <target.length-1 && (!stack.empty() && stack.peek() == target[target.length-cnt-2])){
                tmp[target.length-cnt-2] = stack.pop()
                cnt++
            }
            if(cnt != target.length-1){
                for(index in tmp.lastIndex-cnt+1..tmp.lastIndex) stack.add(tmp[index])
                stack.add(it)
            }
            cnt = 0
        }else stack.add(it)
    }

    if(stack.empty()) print("FRULA") else print(stack.toCharArray())
}
