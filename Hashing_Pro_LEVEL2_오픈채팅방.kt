class Solution {
    fun solution(record: Array<String>): Array<String> {
        var answer = mutableListOf<String>()
        val map = HashMap<String,String>()
        val isLeaved = HashMap<String,Boolean>()
        record.forEach{
            val split = it.split(' ')
            when(split[0]){
                "Enter"->{
                    map[split[1]]=split[2]
                    isLeaved[split[1]] = false
                }
                "Leave"->{
                    isLeaved[split[1]] = true
                }
                "Change"->{
                    if(isLeaved[split[1]] == false){
                        map[split[1]] = split[2]
                    }
                }
            }
        }
        
        record.forEach{
            val split = it.split(' ')
            when(split[0]){
                "Enter"->{
                    answer.add("${map[split[1]]}님이 들어왔습니다.")
                }
                "Leave"->{
                    answer.add("${map[split[1]]}님이 나갔습니다.")
                }
            }
        }
        return Array(answer.size){answer[it]}
    }
}
