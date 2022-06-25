// 2022-06-25 정확성 테스트는 통과, 효율성 테스트 통과 X
// https://programmers.co.kr/learn/courses/30/lessons/72412(순위 검색)

class Solution {
    fun solution(info: Array<String>, query: Array<String>): IntArray {
        var answer: IntArray = IntArray(query.size)
        val map = mutableMapOf<String,MutableList<Int>>()
        val scores = info.map{it.split(' ').last().toInt()}
        
        info.forEachIndexed{ index, it->
            val split = it.split(' ')    
            for(i in 0..3){
                if(map[split[i]]==null) map[split[i]]=mutableListOf()
                map[split[i]]?.add(index)
            }
        }
        
        query.forEachIndexed{ index, q->
            val split = q.split(' ')
            val countList = BooleanArray(info.size){true}
            var count = 0
            for(i in 0..6 step 2){
                if(split[i]=="-") continue
                val tmp = BooleanArray(info.size)
                map[split[i]]?.forEach{
                    tmp[it]=true
                }
                for(j in tmp.indices){
                    if(tmp[j].not()){
                        countList[j]=false
                    }
                }
            }
            for(i in countList.indices){
                if(countList[i].not()) continue
                val last = split.last()
                if(last =="-") continue
                if(scores[i]>= last.toInt()) count++
            }
            answer[index]=count
        }
        
        return answer
    }
}
