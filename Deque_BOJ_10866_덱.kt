// 2022-02-09
// https://www.acmicpc.net/problem/10866

import java.io.*
import java.util.*


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val sb = StringBuilder()
    val deque:Deque<Int> = LinkedList()

    repeat(n){
        val str = readLine()

        when(str[0]){
            's'-> sb.append(deque.size).append('\n')
            'e'-> sb.append(if(deque.isEmpty()) 1 else 0).append('\n')
            'f'-> sb.append(if(deque.isEmpty()) -1 else deque.peekFirst()).append('\n')
            'b'-> sb.append(if(deque.isEmpty()) -1 else deque.peekLast()).append('\n')
            'p'->{
                when(str[5]){
                    'a'->sb.append(if(deque.isEmpty()) -1 else deque.pollLast()).append('\n')
                    'r'->sb.append(if(deque.isEmpty()) -1 else deque.pollFirst()).append('\n')
                    'f'->deque.addFirst(str.split(' ')[1].toInt())
                    'b'->deque.addLast(str.split(' ')[1].toInt())
                }
            }
        }
    }
    print(sb)
}
