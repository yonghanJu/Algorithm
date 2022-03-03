// 2022-03-03
// https://www.acmicpc.net/problem/6593

import java.io.*
import java.util.*

data class Node(val l:Int, val r:Int, val c:Int, val cnt:Int)

var l =0
var r =0
var c =0
lateinit var isVisited:Array<Array<BooleanArray>>
lateinit var graph:Array<Array<CharArray>>
lateinit var q: ArrayDeque<Node>
val dl = intArrayOf(1,-1,0,0,0,0)
val dr = intArrayOf(0,0,1,-1,0,0)
val dc = intArrayOf(0,0,0,0,1,-1)
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var st = StringTokenizer(readLine())
    l = st.nextToken().toInt()
    r = st.nextToken().toInt()
    c = st.nextToken().toInt()

    O@while((l==0 && r ==0 && c==0).not()){
        graph =Array(l){ Array(r){readLine().toCharArray()}.apply{readLine()} }
        isVisited  = Array(l){ Array(r){ BooleanArray(c) }}
        q = ArrayDeque()
        outer@for(i in 0 until l){
            for(j in 0 until r){
                for( k in 0 until c) {
                    if(graph[i][j][k]=='S') {
                        q.addFirst(Node(i,j,k,0))
                        isVisited[i][j][k] = true
                        break@outer
                    }
                }
            }
        }

        while(q.isEmpty().not()){
            val cur= q.removeLast()
            if(graph[cur.l][cur.r][cur.c]=='E') {
                println("Escaped in ${cur.cnt} minute(s).")
                st = StringTokenizer(readLine())
                l = st.nextToken().toInt()
                r = st.nextToken().toInt()
                c = st.nextToken().toInt()
                continue@O
            }
            for(i in 0..5){
                val nl = cur.l + dl[i]
                val nr = cur.r + dr[i]
                val nc = cur.c + dc[i]

                if(nl in 0 until l && nr in 0 until r && nc in 0 until c && graph[nl][nr][nc] !='#' && isVisited[nl][nr][nc].not()){
                    q.addFirst(Node(nl,nr,nc,cur.cnt+1))
                    isVisited[nl][nr][nc] = true
                }
            }
        }
        println("Trapped!")

        st = StringTokenizer(readLine())
        l = st.nextToken().toInt()
        r = st.nextToken().toInt()
        c = st.nextToken().toInt()
    }
}
