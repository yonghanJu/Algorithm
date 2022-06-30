// 2022-06-30
// https://programmers.co.kr/learn/courses/30/lessons/92335# (k진수에서 소수 개수 구하기)

class Solution {
    fun solution(n: Int, k: Int): Int {
        var answer: Int = 0
        var str = StringBuilder()
        var num = n
        
        while(num!=0){
            // StringBuilder 문단 앞에 삽입
            str = str.insert(0,(num%k).toString())
            num/=k
        }
        
        // 정규식 활용 split
        val list = String(str).split('0')
        
        //val max = list.maxOrNull() ?: return 0
        //val isPrime = BooleanArray(max+1){true}
        
        // 1. 배열을 돌면서 소수 여부를 판단하기 때문에 사전 정의를 잘 하자
        // 1을 소수가 아닌걸로 미리 정의
        // 2. 인덱스에 직접 접근할 떄는 항상 조심
        
        // 소수판별 에라토스테 체 알고리즘
        // 이번 알고리즘에선 int 범위를 넘어가므로 사용 x
//         if(max != 0) isPrime[1]=false
        
//         var i = 2
//         while(i<=max){
//             if(isPrime[i].not()) {
//                 i++
//                 continue
//             }
//             var j = i*i
//             while(j<=max){
//                 isPrime[j]=false
//                 j += i
//             }
//             i++
//         }
        
        for(it in list){
            if(it=="") continue
            if(isPrime(it.toLong())) answer++
        }
        return answer
    }
    
    fun isPrime(n:Long):Boolean{
        // 1일 때 예외 처리
        // 항상 범위를 설정할 땐 예외를 처리
        if(n<2L) return false
        
        // 소수판별 범위 설정 시 Math.sqrt 사용
        for(i in 2 .. Math.sqrt(n.toDouble()).toLong()){
            if(n%i==0L) return false
        }
        return true
    }
}
