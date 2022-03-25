// 2022-03-26
// https://www.acmicpc.net/problem/18428

import java.io.*
import java.util.*

var n =0
lateinit var graph:Array<CharArray>
lateinit var teacher:MutableList<Pair<Int,Int>>
lateinit var student:MutableList<Pair<Int,Int>>
lateinit var seeSet:MutableSet<Pair<IntRange,IntRange>>
lateinit var cntGraph:MutableList<Pair<Int,Int>>
lateinit var stack:Stack<Pair<Int,Int>>
fun main():Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    graph = Array(n){readLine().replace(" ","").toCharArray()}
    teacher = mutableListOf()
    student = mutableListOf()
    seeSet = mutableSetOf()
    stack = Stack()
    cntGraph = mutableListOf()
    for(i in 0 until n){
        for(j in 0 until n){
            if(graph[i][j]=='T') teacher.add(Pair(i,j))
            if(graph[i][j]=='S') student.add(Pair(i,j))
            if(graph[i][j]=='X') cntGraph.add(Pair(i,j))
        }
    }
    for(t in teacher){
        for( s in student){
            if(s.first == t.first){
                val h = maxOf(t.second, s.second)
                val l = minOf(t.second, s.second)
                if(h == l+1) println("NO").let{return}
                seeSet.add(Pair(s.first..s.first, l+1 until h))
            }
            if(s.second == t.second){
                val h = maxOf(t.first, s.first)
                val l = minOf(t.first, s.first)
                if(h == l+1) println("NO").let{return}
                seeSet.add(Pair( l+1 until h, s.second..s.second))
            }
        }
    }


    println(if(bt(0,0))"YES" else "NO")
}

fun bt(size:Int,idx:Int):Boolean{
    if(size == 3){
        val tmp = HashSet(seeSet)
        stack.forEach { pair->
            seeSet.forEach { rangePair->
                if(pair.first in rangePair.first && pair.second in rangePair.second) tmp.remove(Pair(rangePair.first, rangePair.second))
            }
        }
        return tmp.size == 0
    }
    for(i in idx .. cntGraph.lastIndex){
        stack.add(cntGraph[i])
        if(bt(size+1,i+1)) return true
        stack.pop()
    }
    return false
}
