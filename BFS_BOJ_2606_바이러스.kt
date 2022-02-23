// 2022-02-23
// https://www.acmicpc.net/problem/2606

import java.io.*
import java.util.*

lateinit var table:Array<MutableList<Int>>
lateinit var isVisited:Array<Boolean>
var answer =-1
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val l = readLine().toInt()
    table = Array(n+1){ mutableListOf() }
    isVisited = Array(n+1){false}
    repeat(l){
        val st = StringTokenizer(readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()

        table[a].add(b)
        table[b].add(a)
    }

    bfs()
    println(answer)
}

fun bfs(){
    val queue:Queue<Int> = LinkedList()

    queue.add(1)
    isVisited[1] = true

    while(queue.isEmpty().not()){
        val node = queue.poll()
        answer++

        table[node].forEach {
            if(isVisited[it].not()){
                isVisited[it]= true
                queue.add(it)
            }
        }
    }
}
