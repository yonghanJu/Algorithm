class Solution {
    var max = -Int.MAX_VALUE
    val score = IntArray(11)
    var answer = intArrayOf(-1)
    fun solution(n: Int, info: IntArray): IntArray {
        dfs(0,0,n,info)
        return answer
    }
    
    fun dfs(index:Int, count:Int, n:Int, info:IntArray){
        // 종료 조건
        if(index>=11){
            if(count <n) return
            var s =0
            for(i in 0..10){
                if(score[i] == 0 && info[i] == 0) continue
                if(score[i] > info[i]){
                    s+= 10-i
                }else s-= 10-i
            }
            if(s>0 && s > max){
                answer = score.clone()
                max = s
            }
            if(s==max){
                for(i in 10 downTo 0){
                    if(answer[i] == score[i]) continue
                    if(answer[i] < score[i]) {
                        answer = score.clone()
                        max = s
                    }
                    break
                }
            }
            return
        }
        
        // dfs 반복
        for(i in 0..n-count){
            score[index] = i
            dfs(index+1, count+i, n, info)
        }
    }
}
