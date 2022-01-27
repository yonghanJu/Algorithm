// 2022-01-20
// https://programmers.co.kr/learn/courses/30/lessons/42890

import java.util.*;

class Solution {    
    
    var rel = mutableListOf<Array<String>>()
    var keyMap = mutableMapOf<String, MutableSet<String>>()
    
    fun solution(relation: Array<Array<String>>): Int {
        
        rel = relation.toMutableList()
        
        for(i in 0..relation.lastIndex) comb(i,0,"","") 
        
        var tmpMap = keyMap.filter{rel.size == it.value.size}.toSortedMap(compareBy<String> { it.length }.thenBy{it}) // 핵심
        var tmpSet = mutableSetOf<String>()
        var answer = tmpMap.size
        
        outer@ for(k in tmpMap.keys){
            for(compareKeySet in tmpSet){
                var count=0
                for(key in compareKeySet) if(k.contains(key)) count++
                if(compareKeySet.length==count) {
                    answer--
                    continue@outer
                }
            }
            tmpSet.add(k)
        }
        
        return answer
    }
    
    fun comb(row: Int, key: Int, keySet: String, com: String){
        if(key==rel[0].size){
            val rset = keyMap.getOrDefault(keySet, mutableSetOf())
            rset.add(com)
            keyMap.put(keySet, rset)
            return
        }
        
        comb(row, key+1, keySet+key, com+rel[row][key])
        comb(row, key+1, keySet, com)
    }
}
