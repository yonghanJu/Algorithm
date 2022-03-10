// 2022-03-10
// https://www.acmicpc.net/problem/20304

import java.io.*
import java.util.*

var m=0
var n =0
var len = 0
lateinit var q:ArrayDeque<Pair<Int,Int>>
lateinit var isVisited:BooleanArray
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var st = StringTokenizer(readLine())
    var answer =0
    n = st.nextToken().toInt()
    q = ArrayDeque()
    isVisited = BooleanArray(n+1)
    len = Integer.toBinaryString(n).length
    st = StringTokenizer(readLine())
    m = st.nextToken().toInt()
    st = StringTokenizer(readLine())
    while(st.hasMoreTokens()){
        val num = st.nextToken().toInt()
        q.addFirst(Pair(num, 0))
        isVisited[num]=true
    }

    while(q.isEmpty().not()){
        val cur= q.removeLast()
        var curB = Integer.toBinaryString(cur.first)
        val sb = StringBuilder()
        repeat(len-curB.length){sb.append(0)}
        curB = sb.append(curB).toString()
        answer = cur.second

        for(at in 0 until len){
            val ns = curB.toCharArray()
            if(ns[at]=='1') ns[at]='0' else ns[at]='1'
            val nn = Integer.parseInt(String(ns),2)
            if(nn>n) continue
            else if(isVisited[nn]) continue
            else{
                q.addFirst(Pair(nn,cur.second+1))
                isVisited[nn]=true
            }
        }
    }

    println( answer)
}
