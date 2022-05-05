import java.util.*
//https://programmers.co.kr/learn/courses/30/lessons/86052


class Solution {
    
    val dx = intArrayOf(-1,0,1,0)
    val dy = intArrayOf(0,1,0,-1)
    var X =0
    var Y =0
    fun solution(grid: Array<String>): IntArray {
        var answer = mutableListOf<Int>()
        
        val table = Array(grid.size){Array(grid[it].length){BooleanArray(4)}}
        X = table.size
        Y = table[0].size
        
        while(true){
            var isDone = true
            for(i in table.indices){
                for(j in table[i].indices){
                    for(d in 0..3){
                        if(table[i][j][d]) continue
                        answer.add(light(i,j,d,table,grid))
                        isDone = false
                    }
                }
            }
            
            if(isDone) break
        }
        
        return answer.sorted().toIntArray()
    }
    
    fun light(i:Int, j:Int, d:Int, table:Array<Array<BooleanArray>>,grid:Array<String>):Int{
        var size = 1
        var curX = i
        var curY = j
        var curD = d
        table[i][j][d]=true
        
        while(true){
            var isDone = true
            val nx = (dx[curD]+curX+X)%X
            val ny = (dy[curD]+curY+Y)%Y
            var nd = when(grid[nx][ny]){
                'S'->{curD}
                'L'->{(curD+1)%4}
                'R'->{(curD+3)%4}
                else->{0}
            }
            
            if(table[nx][ny][nd].not()){
                table[nx][ny][nd]=true
                curX = nx
                curY = ny
                curD = nd
                size++
                isDone = false
            }
            
            if(isDone) break
        }
        
        return size
    }
}
