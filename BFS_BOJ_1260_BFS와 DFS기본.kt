// 2022-02-23
// https://www.acmicpc.net/problem/1260

import java.io.*
import java.util.*

lateinit var table:Array<MutableList<Int>>
lateinit var isVisited:MutableList<Boolean>
lateinit var sb:StringBuilder
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n,m,start) = readLine().split(' ').map{it.toInt()}
    table = Array(n+1){ mutableListOf() }

    sb = StringBuilder()

    repeat(m){
        val st = StringTokenizer(readLine())
        val n1 = st.nextToken().toInt()
        val n2 = st.nextToken().toInt()
        table[n1].add(n2)
        table[n2].add(n1)
    }

    isVisited = MutableList(n+1){false}
    dfs(start)
    sb.append('\n')
    isVisited = MutableList(n+1){false}
    bfs(start)

    println(sb)
}

fun dfs(node: Int){
    isVisited[node] = true
    table[node].sort()
    sb.append(node).append(' ')
    val tmp  = ArrayList(table[node])
    tmp.forEach { if(isVisited[it].not()){
        dfs(it)
    }}
}

fun bfs(start: Int){
    val queue:Queue<Int> = LinkedList<Int>()
    queue.add(start)
    isVisited[start] = true
    sb.append(start).append(' ')

    while(!queue.isEmpty()){
        var pop = queue.poll()

        table[pop].forEach{
            if(isVisited[it].not()){
                queue.add(it)
                isVisited[it] = true
                sb.append(it).append(' ')
            }
        }
    }
}
