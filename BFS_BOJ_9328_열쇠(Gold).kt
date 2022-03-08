// 2022-03-08
// https://www.acmicpc.net/problem/9328

import java.io.*
import java.util.*
import kotlin.collections.HashMap

val dx = intArrayOf(1,-1,0,0)
val dy = intArrayOf(0,0,1,-1)

lateinit var graph:Array<CharArray>
lateinit var isVisited : Array<BooleanArray>
lateinit var keyMap: HashMap<Char,Char>

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val testCase = readLine().toInt()
    repeat(testCase){

        val (h,w) = readLine().split(' ').map{it.toInt()}
        graph = Array(h){readLine().toCharArray()}
        val str = readLine()
        keyMap = if(str == "0") HashMap() else str!!.toCharArray().associateBy({it.uppercaseChar()}, {it}) as HashMap<Char, Char>
        println(bfs(h,w))

    }
}

fun bfs(h:Int, w:Int):Int{
    //입구찾기


    var answer = 0
    var isDone = 0
    var s = 0
    while(true){ // 키를 먹으면 다시 실행
        var now =0
        var cnt =0
        s = 0
        val entrance = mutableListOf<Pair<Int,Int>>()

        for(i in 0 until h){
            if(graph[i][0]=='.' || keyMap[graph[i][0]]!=null) entrance.add(Pair(i,0))
            else if(graph[i][0].isLowerCase()){
                keyMap[graph[i][0].uppercaseChar()]='k'
                entrance.add(Pair(i,0))
            }
            else if(graph[i][0] =='$'){
                s++
                entrance.add(Pair(i,0))
            }
            if(graph[i][w-1]=='.'|| keyMap[graph[i][w-1]]!=null) entrance.add(Pair(i,w-1))
            else if(graph[i][w-1].isLowerCase()){
                keyMap[graph[i][w-1].uppercaseChar()]='k'
                entrance.add(Pair(i,w-1))
            }
            else if(graph[i][w-1] =='$'){
                s++
                entrance.add(Pair(i,w-1))
            }
        }
        for(i in 1 until w-1){
            if(graph[0][i]=='.'|| keyMap[graph[0][i]]!=null) entrance.add(Pair(0,i))
            else if(graph[0][i].isLowerCase()){
                keyMap[graph[0][i].uppercaseChar()]='k'
                entrance.add(Pair(0,i))
            }
            else if(graph[0][i] =='$'){
                s++
                entrance.add(Pair(0,i))
            }
            if(graph[h-1][i]=='.'|| keyMap[graph[h-1][i]]!=null) entrance.add(Pair(h-1,i))
            else if(graph[h-1][i].isLowerCase()){
                keyMap[graph[h-1][i].uppercaseChar()]='k'
                entrance.add(Pair(h-1,i))
            }
            else if(graph[h-1][i] =='$'){
                s++
                entrance.add(Pair(h-1,i))
            }
        }

        isVisited = Array(h){BooleanArray(w)}
        val q = ArrayDeque<Pair<Int,Int>>()



        for(enter in entrance) {
            q.addFirst(Pair(enter.first,enter.second))
            isVisited[enter.first][enter.second] = true
        }

        while(q.isEmpty().not()){
            val cur = q.removeLast()
            now++

            for(i in 0..3){
                val nx = cur.first+dx[i]
                val ny = cur.second+dy[i]

                if((nx in graph.indices && ny in graph[0].indices).not()) continue
                if(isVisited[nx][ny]) continue
                if(graph[nx][ny] == '*') continue
                else if(graph[nx][ny]=='.'){ // 이동
                    isVisited[nx][ny] = true
                    q.addFirst(Pair(nx,ny))
                }else if(graph[nx][ny].isUpperCase()){ // 문
                    if(keyMap[graph[nx][ny]]!=null) {
                        isVisited[nx][ny] = true
                        q.addFirst(Pair(nx,ny))
                    }
                }else if(graph[nx][ny].isLowerCase()){ // 열쇠
                    keyMap[graph[nx][ny].uppercaseChar()] = 'k'
                    isVisited[nx][ny] = true
                    q.addFirst(Pair(nx,ny))
                }else if(graph[nx][ny]=='$'){// 문서
                    isVisited[nx][ny] = true
                    q.addFirst(Pair(nx,ny))

                    cnt++
                }
            }
        }
        answer = maxOf(cnt, answer)
        if(now==isDone) break
        isDone = now
    }

    return answer +s
}
