def solution(k, tangerine):
    answer = 0
    dic = {}
    for i in tangerine:
        dic[i] = 0
    for i in tangerine:
        dic[i] += 1
    dic = sorted(dic.items(), key = lambda item:item[1], reverse = True)
    for item in dic:
        if k > 0:
            k -= item[1]
            answer += 1
        else:
            break
    return answer
