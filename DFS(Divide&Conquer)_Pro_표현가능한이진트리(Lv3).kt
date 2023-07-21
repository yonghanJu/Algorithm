// https://school.programmers.co.kr/learn/courses/30/lessons/150367#
// 2023-07-21

class Solution {
    fun solution(numbers: LongArray): IntArray {
        var answer: IntArray = IntArray(numbers.size)

        outer@for(tc in 0 until numbers.size) {
            var bNum = numbers[tc].toString(2)
            
            for(i in 0 until bNum.length) {
                if(bNum[i] == '1') {
                    val add = (bNum.length - i * 2 -1)
                    if(add >= 0) {
                        if(f("0".repeat(add) + bNum)) {
                            answer[tc] = 1
                            continue@outer
                        }
                    }
                }
            }
        }
        return answer
    }
    
    fun f(str: String) : Boolean {
        if(str.length == 1) return true
        if((str.length / 2) % 2 == 0) return false
        
        val root = str.length / 2
        if(str[root] == '0') {
            return if(str.replace("0","").length == 0) true else false
        }
        
        return f(str.substring(0 until root)) && f(str.substring(root + 1 until str.length))
    } 
}
