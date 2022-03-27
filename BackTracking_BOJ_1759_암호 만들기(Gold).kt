// 2022-03-27
// https://www.acmicpc.net/problem/1759

import java.io.*
import java.util.*

var l = 0
var c =0

lateinit var list:MutableList<Pair<Char,Boolean>>
lateinit var visited:BooleanArray
var sb = StringBuilder()
fun main():Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    var st = StringTokenizer(readLine())
    l = st.nextToken().toInt()
    c = st.nextToken().toInt()
    st = StringTokenizer(readLine())
    list = mutableListOf()
    visited = BooleanArray(c)
    repeat(c){
        val c = st.nextToken()[0]
        if(c == 'a' || c== 'e'||c=='i'||c=='o'||c=='u') list.add(Pair(c,true))
        else list.add(Pair(c,false))
    }
    list.sortBy{it.first}

    dfs(0,0, 0)
    println(sb)
}

fun dfs(size1:Int, size2:Int, idx:Int){
    if(size1+size2==l){
        if(size1<1 || size2<2) return
        for(i in visited.indices) if(visited[i]) sb.append(list[i].first)
        sb.append('\n')
        return
    }

    for(i in idx .. list.lastIndex){
        if(visited[i].not()){
            visited[i]=true
            if(list[i].second) dfs(size1+1,size2,i+1)
            else dfs(size1,size2+1, i+1)
            visited[i]=false
        }
    }
}
