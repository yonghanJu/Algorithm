def solution(want, number, discount):
    answer = 0
    buy = {}
    cart = {}
    count = 0
    total = sum(number)
        
    for i in range(len(discount)):
        cart[discount[i]] = 0
        buy[discount[i]] = 0
    
    for i in range(len(want)):
        buy[want[i]] = number[i]
    
    for i in range(len(discount)):
        cart[discount[i]] += 1
        if cart[discount[i]] <= buy[discount[i]]:
            count += 1
        if i >= 10:
            cart[discount[i - 10]] -= 1
            if cart[discount[i - 10]] < buy[discount[i - 10]]:
                count -= 1
        if count == total:
            answer += 1
    return answer
