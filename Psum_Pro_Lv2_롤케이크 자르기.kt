class Solution {
    fun solution(topping: IntArray): Int {
        var answer: Int = 0
        val left = IntArray(topping.size) 
        val right = IntArray(topping.size)
        var isChecked = BooleanArray(10001)
        var count = 0
        for(i in topping.indices) {
            if(isChecked[topping[i]].not()) {
                count++
                isChecked[topping[i]] = true
            }
            left[i] = count
        }
        isChecked = BooleanArray(10001)
        count = 0
        for(i in topping.lastIndex downTo 0) {
            if(isChecked[topping[i]].not()) {
                count++
                isChecked[topping[i]] = true
            }
            right[i] = count
        }
        for(i in 0..topping.lastIndex - 1) {
            if(left[i] == right[i + 1]) answer++
        }
        return answer
    }
}
