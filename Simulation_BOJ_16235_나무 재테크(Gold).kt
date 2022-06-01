// 2022-06-01
// https://www.acmicpc.net/problem/16235

import java.util.*

class Solution {

    // 1. 나이만큼 양분을 먹고, 나이 1 증가, 나이 어린순으로 양분 먹기, 못먹으면 즉사
    // 2. 죽은 나무 나이/2 만큼 양분 증가
    // 3. 나이가 5배수 나무 번식
    // 4. 양분 추가

    val dx = intArrayOf(-1,-1,0,1,1,1,0,-1)
    val dy = intArrayOf(0,1,1,1,0,-1,-1,-1)
    fun solution(k:Int, protein:Array<IntArray>, trees:Array<Array<ArrayDeque<Int>>>) {
        var answer  = 0
        var grow = Array(protein.size){IntArray(protein[0].size){5} }

        repeat(k){ _->
            val addList = mutableListOf<IntArray>()
            // 1
            for(i in grow.indices){
                for(j in grow[0].indices){

                    val size = trees[i][j].size
                    for(t in 0 until size){
                        val cur = trees[i][j].removeFirst()

                        if(grow[i][j] >= cur){
                            grow[i][j] -= cur
                            trees[i][j].addLast(cur+1)
                        }else{
                            addList.add(intArrayOf(i,j,cur/2))
                        }
                    }
                }
            }

            // 2
            addList.forEach{
                grow[it[0]][it[1]] += it[2]
            }

            // 3
            for(i in grow.indices){
                for(j in grow[0].indices){
                    trees[i][j].forEach{
                        if(it%5==0){
                            for(d in 0..7){
                                val nx = i+dx[d]
                                val ny = j+dy[d]
                                if((nx in grow.indices && ny in grow[0].indices).not()) continue
                                trees[nx][ny].addFirst(1)
                            }
                        }
                    }
                }
            }

            // 4
            for(i in grow.indices){
                for(j in grow[0].indices){
                    grow[i][j] += protein[i][j]
                }
            }
        }
        for(i in grow.indices){
            for(j in grow[0].indices){
                answer += trees[i][j].size
            }
        }

        print(answer)
    }
}

fun main() {
    val (n,m,k)= readLine()!!.split(' ') // n = 땅 크기, m= 나무 개수, k=타깃
    Solution().solution(k.toInt()
        ,Array(n.toInt()){readLine()!!.split(' ').map{it.toInt()}.toIntArray()}
        ,Array(m.toInt()){readLine()!!.split(' ').map{it.toInt()}.toIntArray()}.run{
            val arr = Array(n.toInt()+1){Array(n.toInt()+1){ ArrayDeque<Int>() }}
            this.forEach{
                arr[it[0]-1][it[1]-1].addFirst(it[2])
            }
            arr
        })
}
