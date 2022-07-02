// 2022-07-02
// https://programmers.co.kr/learn/courses/30/lessons/64064 (불량 사용자)

import java.util.*

class Solution {
    lateinit var list:Array<MutableList<Int>>
    lateinit var isVisited:BooleanArray
    lateinit var stack:Stack<Int>
    lateinit var mSet:MutableSet<MutableSet<Int>>
    var target = 0
    fun solution(user_id: Array<String>, banned_id: Array<String>): Int {
        target = banned_id.size
        isVisited = BooleanArray(user_id.size)
        stack=Stack()
        mSet = mutableSetOf()
        list = Array(banned_id.size){mutableListOf<Int>()}
        for(i in banned_id.indices){
            val ban = banned_id[i].replace('*','.').toRegex()
            for(j in user_id.indices){
                if(user_id[j].matches(ban)){
                    list[i].add(j)
                }
            }
        }
        dfs(0)
        
        return mSet.size
    }
    
    fun dfs(depth:Int){
        if(depth==target){
            val s = mutableSetOf<Int>()
            stack.forEach{
                s.add(it)
            }
            mSet.add(s)
            return
        }
        if(list[depth].size==0) dfs(depth+1)
        
        for(i in list[depth]){
            if(isVisited[i]) continue
            isVisited[i]=true
            stack.add(i)
            dfs(depth+1)
            stack.pop()
            isVisited[i]=false
        }
    }
}
