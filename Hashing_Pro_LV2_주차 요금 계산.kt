// 2022-06-30
// https://programmers.co.kr/learn/courses/30/lessons/92341 (주차 요금 계산)

class Solution {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        // 차량 별 시간을 측정
        val timeMap = mutableMapOf<String,Int>()
        val totalMap = mutableMapOf<String,Int>()
        records.forEach{
            val record = it.split(' ') // "05:34 5961 IN"
            val time = record[0].split(':').run{
                get(0).toInt()*60 + get(1).toInt()
            }
            if(record[2]=="IN"){
                timeMap[record[1]] = time
            }else{
                totalMap[record[1]] = totalMap.getOrDefault(record[1],0) + time - timeMap[record[1]]!!
                timeMap[record[1]] = -1
            }
        }
        
        timeMap.entries.forEach{
            if(it.value != -1){
                totalMap[it.key] = totalMap.getOrDefault(it.key, 0) + 23*60+59 - it.value
            }
        }
        
        return totalMap.entries.sortedBy{ it.key }.map{ 
            var fee = 0
            if(it.value<=fees[0]) fee = fees[1]
            else{
                val m = if( (it.value-fees[0])%fees[2] == 0) (it.value-fees[0])/fees[2] 
                else (it.value-fees[0])/fees[2] +1
               fee = fees[1] +  m * fees[3]
            }
            fee
        }.toIntArray() //1,439
    }
}
