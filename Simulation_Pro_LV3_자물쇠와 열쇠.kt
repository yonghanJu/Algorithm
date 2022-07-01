// 2022-07-01
// https://programmers.co.kr/learn/courses/30/lessons/60059# (자물쇠와 열쇠)

class Solution {
    var n = 0
    fun solution(key: Array<IntArray>, lock: Array<IntArray>): Boolean {        
        // 홈의 개수
        for(l in lock){
            l.forEach{
                if(it==0) n++
            }
        }
        for(r in 0..3){
            if(r!=0) rotation(key)
            for(i in -key.lastIndex..lock.lastIndex){
                for(j in  -key.lastIndex..lock.lastIndex){
                    if(matches(key, lock, i,j)) return true
                }
            }
        }
        
        return false
    }
    
    fun rotation(arr:Array<IntArray>){
        val tmp = Array(arr.size){ arr[it].clone() }
        
        for(i in arr.indices){
            for(j in arr.indices){
                arr[i][j] = tmp[arr.size-j-1][i]
            }
        }
    }
    
    fun matches(key:Array<IntArray>, lock:Array<IntArray>,x:Int, y:Int):Boolean{
        
        var cnt = 0
        for(i in key.indices){
            for(j in key.indices){
                if((x+i in lock.indices && y+j in lock.indices).not()) continue
                if(key[i][j]==1 && lock[x+i][y+j]==1) return false
                if(key[i][j]==0 && lock[x+i][y+j]==0) return false
                if(key[i][j]==1 && lock[x+i][y+j]==0) cnt++
            }
        }
        
        return cnt==n
    }
}
