// 2022-05-19
// https://www.acmicpc.net/problem/15686

import java.util.*

class Solution {

    var an =Int.MAX_VALUE
    var M =0
    var N =0
    val dx = listOf(0,0,1,-1)
    val dy = listOf(1,-1,0,0)
    lateinit var twoList:MutableList<Pair<Int,Int>>
    lateinit var check:BooleanArray
    lateinit var arr:Array<List<Int>>
    fun solution(m:Int, array: Array<List<Int>>) {
        arr =array
        M=m
        N=array.size
        twoList = mutableListOf()
        var answer = 0
        val isVisited = Array(array.size){IntArray(array.size)}
        // 모든 1을 큐에 삽입
        for(i in array.indices){
            for(j in array[0].indices){
                if(array[i][j]==2){
                    twoList.add(Pair(i,j))
                }
            }
        }
        check = BooleanArray(twoList.size)
        dfs(0, 0)
        print(an)
    }

    fun dfs(size:Int, index:Int){
        if(size == M){
            an = minOf(an,bfs())
            return
        }
        if(index == twoList.size) return
        check[index]=true
        dfs(size+1,index+1)
        check[index]=false
        dfs(size,index+1)
    }

    fun bfs():Int{
        var answer =0
        val q = ArrayDeque<Pair<Int,Int>>()
        val isVisited = Array(N){BooleanArray(N)}
        val distance = Array(N){IntArray(N)}
        for(i in check.indices){
            if(check[i]) {
                val p = twoList[i]
                q.add(p)
                isVisited[p.first][p.second]=true
            }
        }

        while(q.isEmpty().not()){
            val (x,y)= q.removeLast()
            if(arr[x][y]==1){
                answer += distance[x][y]
            }

            for(i in 0..3){
                val nx = dx[i]+x
                val ny = dy[i]+y

                if((nx in 0 until N && ny in 0 until N).not()) continue
                if(isVisited[nx][ny]) continue
                isVisited[nx][ny]=true
                q.addFirst(Pair(nx,ny))
                distance[nx][ny] = distance[x][y]+1
            }
        }

        return answer
    }
}

fun main() {
    val (N, M) = readLine()!!.split(' ')
    Solution().solution(M.toInt(), Array(N.toInt()){readLine()!!.split(' ').map{it.toInt()}})
}
