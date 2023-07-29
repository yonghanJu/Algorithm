// https://school.programmers.co.kr/learn/courses/30/lessons/150365
// 2023-07-29

class Solution {
    fun solution(n: Int, m: Int, x: Int, y: Int, r: Int, c: Int, k: Int): String {
        // 맨허틀 거리가 k 보다 작을 경우 불가능 판정!!!(한참 찾았네요)
        val distance = (Math.abs(x-r) + Math.abs(y-c))
        if(distance % 2 != k % 2 || distance > k) return "impossible"
        var answer = StringBuilder()
        var count = 0
        var cx = x
        var cy = y
        while(count + Math.abs(cx-r) + Math.abs(cy-c) < k) {
            if(cx != n) {
                answer.append('d')
                cx++
            } else if(cy != 1) {
                answer.append('l')
                cy--
            } else if(cy != m) {
                answer.append('r')
                cy++
            } else if(cx != 1){
                answer.append('u')
                cx--
            }
            count ++
        }
        // 마무리 
        val dx = r - cx
        val dy = c - cy
        
        if(dx > 0) {
            answer.append("d".repeat(dx))
        }
        if(dy < 0) {
            answer.append("l".repeat(-dy))
        }
        if(dy > 0) {
            answer.append("r".repeat(dy))
        }
        if(dx < 0) {
            answer.append("u".repeat(-dx))
        }
        return answer.toString()
    }
}
