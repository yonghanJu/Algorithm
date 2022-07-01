// 2022-07-01
// https://programmers.co.kr/learn/courses/30/lessons/43164 (여행경로)

import java.util.Stack

class Solution {
    
    lateinit var stack:Stack<String>
    lateinit var list:List<String>
    lateinit var graph:Array<IntArray>
    lateinit var map: MutableMap<String,Int>
    var answer = mutableListOf<String>()
    
    fun solution(tickets: Array<Array<String>>): Array<String> {
        val set = mutableSetOf<String>().apply{
            tickets.forEach{
                add(it[0])
                add(it[1])
            }
        }
        stack = Stack()
        stack.add("ICN")
        list = set.toList().sorted()
        map = mutableMapOf<String,Int>().apply{
            list.forEachIndexed{ idx, it->
                put(it, idx)
            }
        }
        
        graph = Array(list.size){IntArray(list.size)}
        tickets.forEach{
            graph[map[it[0]]!!][map[it[1]]!!]++
        }
        
        dfs("ICN", 0, tickets.size)
        
        return answer.toTypedArray()
    }
    
    fun dfs(now:String, depth:Int, targetCount:Int):Boolean{
        if(depth == targetCount){
            stack.forEach{
                answer.add(it)
            }
            return true
        }
        
        for(i in graph[map[now]!!].indices){
            if(graph[map[now]!!][i]!! >0){
                graph[map[now]!!][i] = graph[map[now]!!][i]!! -1
                stack.add(list[i])
                if(dfs(list[i], depth+1, targetCount)) return true
                stack.pop()
                graph[map[now]!!][i] = graph[map[now]!!][i]!! +1
            }
        }
        
        return false
    }
}
