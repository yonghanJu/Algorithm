// 2022-01-06
// https://programmers.co.kr/learn/courses/30/lessons/43105?language=java

import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        if(triangle.length==1) return triangle[0][0];
        
        for(int a = 1; a<triangle.length; a++){
            for(int b=0; b<triangle[a].length; b++){
                if(b==0) triangle[a][b] += triangle[a-1][b];
                else if(b==triangle[a].length-1) triangle[a][b] += triangle[a-1][b-1];
                else triangle[a][b] += Math.max(triangle[a-1][b-1],triangle[a-1][b]);
                
                answer = Math.max(answer, triangle[a][b]);
            }
        }
        return answer;
    }
}
