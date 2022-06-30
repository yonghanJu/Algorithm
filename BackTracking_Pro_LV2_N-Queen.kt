// 2022-07-01
// https://programmers.co.kr/learn/courses/30/lessons/12952 (N-Queen)

class Solution {
    
    lateinit var board:Array<BooleanArray>
    var answer = 0
    
    fun solution(n: Int): Int {
        board = Array(4){BooleanArray(n*2)}
        dfs(0,0,0,n)
        return answer
    }
    
    fun dfs(x:Int, y:Int, count:Int, size:Int){
        if(count==size){
            answer++
            return
        }
        if(y==size){
            dfs(x+1,0,count,size)
            return
        }
        if(x==size) return
        
        dfs(x,y+1,count,size)
        if(board[0][x].not() && board[1][y].not() && board[2][x+y].not() && board[3][x-y+size].not()){
            board[0][x] = true
            board[1][y] = true
            board[2][x+y] = true
            board[3][x-y+size] = true
            dfs(x,y+1,count+1,size)
            board[0][x] = false
            board[1][y] = false
            board[2][x+y] = false
            board[3][x-y+size] = false
        }
    }
}
