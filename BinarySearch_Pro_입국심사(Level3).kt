import java.util.*

// 굳이 빈공간으로 가지 않아도 됨
// 끝나는 시간이 중요
// 이분 탐색 통나무 자르기와 비슷한 문제입니다
class Solution {
    fun solution(n: Int, times: IntArray): Long {
        var answer: Long = 0
        var start = 0L
        var end = 1000000000000000000L
        
        while(start<= end){
            var mid = (start+end)/2
            var finCnt =0L
            times.forEach{
                finCnt+= mid/it
            }
            
            if(finCnt < n){
                start = mid+1
            }else{
                end = mid-1
                answer = mid
            }
        }
        
        return answer
    }
}
