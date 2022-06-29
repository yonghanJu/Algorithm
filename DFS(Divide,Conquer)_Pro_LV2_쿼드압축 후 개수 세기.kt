// 2022-06-29
// https://programmers.co.kr/learn/courses/30/lessons/68936 (쿼드압축 후 개수 세기)

class Solution {
    var one = 0
    var zero = 0
    fun solution(arr: Array<IntArray>): IntArray {        
        dfs(0,0,arr.size, arr)
        return intArrayOf(zero, one)
    }
    
    fun dfs(x:Int, y:Int, size:Int, arr:Array<IntArray>){
        val data = arr[x][y]
        for(i in x until x+size){
            for(j in y until y+size){
                if(arr[i][j] != data){
                    dfs(x,y,size/2,arr)
                    dfs(x+size/2,y,size/2,arr)
                    dfs(x,y+size/2,size/2,arr)
                    dfs(x+size/2,y+size/2,size/2,arr)
                    return
                }
            }
        }
        
        if(data==1) one++ else zero++
    }
}
