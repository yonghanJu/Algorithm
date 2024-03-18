def solution(numbers):
    answer = [-1 for i in range(len(numbers))]
    stack = []
    for i in range(len(numbers)):
        while len(stack) > 0 and stack[-1][1] < numbers[i]:
            answer[stack.pop()[0]] = numbers[i]
        stack.append((i, numbers[i]))
    return answer
