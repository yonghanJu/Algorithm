https://programmers.co.kr/learn/courses/30/lessons/12985#

class Solution {
    fun solution(n: Int, a: Int, b: Int): Int {
        var answer = 0
        
        var cut = n/2
        var size = n/2
        var isAdd = false
        while(size > 0){
            if(a > cut && b > cut){
                cut += size/2
            }else if(a <= cut && b <=cut ){
                cut -= size/2
            }
            else{
                isAdd = true
            }
            size/=2
            
            if(isAdd){
                answer++
            }
        }
        
        return answer
    }
}
