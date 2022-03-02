import java.io.*
import java.util.*

data class Node(val x:Int, val y:Int, val cnt:Int)

val dx = intArrayOf(0,0,1,-1)
val dy = intArrayOf(1,-1,0,0)
var n=0
var m =0
var t = 0
lateinit var graph:MutableList<MutableList<Int>>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var st = StringTokenizer(readLine())
    n = st.nextToken().toInt()
    m = st.nextToken().toInt()
    t= st.nextToken().toInt()
    graph = mutableListOf(mutableListOf())
    repeat(n){
        st = StringTokenizer(readLine())
        val list = mutableListOf<Int>()
        list.add(0)
        repeat(m){list.add(st.nextToken().toInt())}
        graph.add(list)
    }

    print(bfs())
}

fun bfs():String{
    val q =ArrayDeque<Node>()
    val isVisited = Array(n+1){BooleanArray(m+1)}
    var root1 = Int.MAX_VALUE
    var root2 = Int.MAX_VALUE
    isVisited[1][1] = true
    q.addFirst(Node(1,1,0))

    while(q.isEmpty().not()){
        val cur = q.removeLast()
        if(cur.x==n && cur.y == m) root1 = cur.cnt
        if(graph[cur.x][cur.y]==2) root2 = m+n-cur.x-cur.y+cur.cnt


        for(i in 0..3){
            val nx = cur.x + dx[i]
            val ny = cur.y + dy[i]
            if(nx in 1..n && ny in 1..m && graph[nx][ny] != 1 &&  isVisited[nx][ny].not()){
                isVisited[nx][ny] = true
                q.addFirst(Node(nx,ny,cur.cnt+1))
            }
        }
    }

    return if(root1==Int.MAX_VALUE &&  root2 == Int.MAX_VALUE)  "Fail" else if(minOf(root1,root2) > t) "Fail" else minOf(root1,root2).toString()
}
