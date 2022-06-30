// 2022-07-01
// https://programmers.co.kr/learn/courses/30/lessons/12953# (N개의 최소공배수)

class Solution {
    fun solution(arr: IntArray): Int {
        var answer = 1
        
        for(i in arr.indices){
            answer = lcm(answer, arr[i])
        }
        
        return answer
    }
    
    fun gcd(a:Int, b:Int):Int{
        var l = a
        var r = b
        var tmp = 0
        while(r!=0){
            tmp = r
            r = l%r
            l = tmp
        }
        return l
    }
    
    fun lcm(a:Int, b:Int) = a*b/gcd(a,b)
}
