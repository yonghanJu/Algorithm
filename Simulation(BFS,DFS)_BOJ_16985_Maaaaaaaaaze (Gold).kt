// 2022-05-22
// https://www.acmicpc.net/problem/16985

import java.util.*

data class Data(val x:Int, val y:Int, val z:Int, val dis:Int)

class Solution {
    var answer = Int.MAX_VALUE
    val dx = intArrayOf(1,-1,0,0,0,0)
    val dy = intArrayOf(0,0,1,-1,0,0)
    val dz = intArrayOf(0,0,0,0,1,-1)
    val isUsed = BooleanArray(5)
    val stack = Stack<Int>()
    lateinit var m: Array<Array<IntArray>>

    fun solution(maze:Array<Array<IntArray>>) {
        m=maze
        makeFloor(0)
        print(if(answer==Int.MAX_VALUE) -1 else answer)
    }

    fun makeFloor(floor:Int){
        if(floor==5){
            val tmpList = stack.toList()
            dfs(0, Array(5){m[tmpList[it]]})
            return
        }

        for(i in 0..4){
            if(isUsed[i]) continue
            isUsed[i]=true
            stack.add(i)
            makeFloor(floor+1)
            isUsed[i]=false
            stack.pop()
        }
    }

    fun dfs(floor:Int, maze:Array<Array<IntArray>>){
        if(floor==5){
            answer = minOf(bfs(maze),answer)
            return
        }

        var tmpMaze = Array(5){i->Array(5){j-> maze[i][j]} }

        dfs(floor+1, tmpMaze)
        for(i in 0..2){
            tmpMaze[floor] = rotate(tmpMaze[floor])
            dfs(floor+1, tmpMaze)
        }
    }

    fun bfs(maze:Array<Array<IntArray>>):Int{
        if(maze[0][0][0]==0) return Int.MAX_VALUE
        val q = ArrayDeque<Data>()
        val isVisited = Array(5){Array(5){BooleanArray(5)}}
        isVisited[0][0][0]=true
        q.addFirst(Data(0,0,0,0))

        while(q.isEmpty().not()){
            val cur = q.removeLast()
            if(cur.x==4 && cur.y==4 && cur.z==4){
                return cur.dis
            }

            for(i in 0..5){
                val nx = cur.x+dx[i]
                val ny = cur.y+dy[i]
                val nz = cur.z+dz[i]

                if((nx in 0..4 && ny in 0..4 && nz in 0..4).not()) continue
                if(isVisited[nx][ny][nz]) continue
                if(maze[nx][ny][nz]==0) continue
                isVisited[nx][ny][nz]=true
                q.addFirst(Data(nx,ny,nz,cur.dis+1))
            }
        }
        return Int.MAX_VALUE
    }

    fun rotate(arr: Array<IntArray>):Array<IntArray>{
        var newArr = Array(5){ IntArray(5) }

        for(i in 0..4){
            for(j in 0..4){
                newArr[4-j][i]=arr[i][j]
            }
        }

        return newArr
    }
}

fun main() {
    Solution().solution(Array(5){Array(5){readLine()!!.split(' ').map{it.toInt()}.toIntArray()} })
}
