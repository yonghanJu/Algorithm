// 2022-05-23
// https://www.acmicpc.net/problem/14500

import java.util.*

class Solution {
    var answer =0
    val stack = Stack<Pair<Int,Int>>()
    lateinit var gTable:Array<IntArray>
    lateinit var isVisited:Array<BooleanArray>
    val dx = intArrayOf(0,0,1,-1)
    val dy = intArrayOf(1,-1,0,0)
    fun solution(table:Array<IntArray>) {
        isVisited = Array(table.size){BooleanArray(table[0].size)}
        gTable = table
        for(i in table.indices){
            for(j in table[0].indices) {
                isVisited[i][j]=true
                dfs(i,j,1,table[i][j])
                isVisited[i][j]=false
            }
        }
        print(answer)
    }

    fun dfs(x:Int, y:Int, count:Int,sum:Int){
        if(count==4){
            answer = maxOf(answer, sum)
            return
        }
        for(i in 0..3){
            val nx = x+dx[i]
            val ny = y+dy[i]
            if((nx in isVisited.indices && ny in isVisited[0].indices).not()) continue
            if(isVisited[nx][ny]) continue

            if(count ==2){
                isVisited[nx][ny]=true
                stack.add(Pair(nx,ny))
                dfs(x,y,count+1, sum+gTable[nx][ny])
                stack.pop()
                isVisited[nx][ny]=false
            }

            isVisited[nx][ny]=true
            stack.add(Pair(nx,ny))
            dfs(nx,ny,count+1,sum+gTable[nx][ny])
            stack.pop()
            isVisited[nx][ny]=false
        }
    }
}

fun main() {
    val (n,m) = readLine()!!.split(' ')
    Solution().solution(Array(n.toInt()){ readLine()!!.split(' ').map{it.toInt()}.toIntArray() } )
}
