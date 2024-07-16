class Solution {
    fun solution(arrayA: IntArray, arrayB: IntArray): Int {
        var answer: Int = 0
        var aa = arrayA[0]
        var bb = arrayB[0]
        
        for (i in 0..arrayA.size - 2) {
            aa = gcd(aa, arrayA[i + 1])
        }
        
        for (i in 0..arrayB.size - 2) {
            bb = gcd(bb, arrayB[i + 1])
        }
    
        
        val canA = arrayB.all { it % aa != 0 }
        val canB = arrayA.all { it % bb != 0 }
        return if (canA && canB) maxOf(aa, bb) 
        else if (canA) aa 
        else if (canB) bb 
        else 0
    }
    
    fun gcd(a: Int, b: Int): Int {
        if (b == 0) return a
        return gcd(b, a % b)
    }
}
