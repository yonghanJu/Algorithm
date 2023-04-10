// 2023-04-10
// https://school.programmers.co.kr/learn/courses/30/lessons/169198?language=cpp

#include <string>
#include <vector>
#include <limits.h>
#include <cmath>

using namespace std;

vector<int> solution(int m, int n, int startX, int startY, vector<vector<int>> balls) {
    
    vector<int> answer;
    
    for(int i = 0; i < balls.size(); i ++) { 
        int arr[8][2] {{2*m - balls[i][0], balls[i][1]} // up
        ,{-balls[i][0], balls[i][1]}    // down
        ,{balls[i][0], 2 * n - balls[i][1]} // right
        ,{balls[i][0], -balls[i][1]}};    // left
        
        int min = INT_MAX;
        
        int skip = -1;        
        if(startX == balls[i][0]) {
            if(startY > balls[i][1]) {
                skip = 3;
            } else skip = 2;
        } if(startY == balls[i][1]) {
            if(startX > balls[i][0]) {
                skip = 1;
            } else skip = 0;
        }
        
        for(int j = 0; j < 4; j++) {
            if(j == skip) continue;
            int distance = pow(arr[j][0] - startX,2) + pow(arr[j][1] - startY, 2);
            if(min > distance) min = distance;
        }
        
        answer.push_back(min);
    }
        
    return answer;
}
