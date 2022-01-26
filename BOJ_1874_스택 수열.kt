// 2022-01-26
// https://www.acmicpc.net/problem/1874

import java.io.*
import java.lang.StringBuilder
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
  
    // BufferedWriter의 경우 일정 크기 이상 버퍼가 커지면 자동flush 문제가 발생(출력초과)
    // 따라서 기존 bw를 주석처리 해주고 StringBuilder 을 사용하자!!!!!!! 
    // val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val sb = StringBuilder()
    val queue:Queue<Int> = LinkedList()
    val queue2:Queue<Int> = LinkedList()
    val stack = Stack<Int>()

    repeat(readLine().toInt()){
        queue.add(readLine().toInt())
        queue2.add(it+1)
    }

    while(!queue2.isEmpty()) {
        if(stack.empty()) {
            stack.push(queue2.poll())
            sb.append("+\n")
            //bw.write("+\n")
        }
        else if(queue.peek() != stack.peek()) {
            stack.push(queue2.poll())
            sb.append("+\n")
            //bw.write("+\n")
        }else{
            queue.poll()
            stack.pop()
            sb.append("-\n")
            //bw.write("-\n")
        }
    }

    while(!stack.isEmpty()) {
        if(stack.pop() != queue.poll()){
            println("NO")
            return
        }
        else sb.append("-\n")
    }

    print(sb)
    // bw.flush()
    // bw.close()
}
