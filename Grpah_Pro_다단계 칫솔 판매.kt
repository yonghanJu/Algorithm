class Solution {
    private lateinit var answer: IntArray
    private lateinit var parentList: IntArray
    
    fun solution(enroll: Array<String>, referral: Array<String>, seller: Array<String>, amount: IntArray): IntArray {
        
        answer = IntArray(enroll.size)
        parentList = IntArray(enroll.size) { -1 }
        
        val map = mutableMapOf<String, Int>()
        for(i in referral.indices) {
            map[enroll[i]] = i
            if(referral[i] != "-")  parentList[i] = map[referral[i]]!!
        }
        for(i in seller.indices) {
            dfs(map[seller[i]]!!, amount[i] * 100)
        }
        return answer
    }
    
    private fun dfs(cur: Int, money: Int) {
        val remain = money / 10
        answer[cur] += money - remain
        if(parentList[cur] != -1 && remain > 0) dfs(parentList[cur], remain)
    }
}
