import sys
sys.setrecursionlimit(1000000)

def solution(elements):
    s = set()
    psum = [[0] * len(elements) for i in range(len(elements))]
    
    for i in range(0, len(elements)):
        for j in range(0, len(elements)):
            s.add(re(i, j, psum, elements))
            
    return len(s)

def re(i, j, psum, elements):
    if psum[i][j] == 0:
        if i == j:
            psum[i][j] = elements[j]
        elif i > j:
            psum[i][j] = re(i, len(elements) - 1, psum, elements) + re(0, j, psum, elements)
        else:
            psum[i][j] = re(i, j - 1, psum, elements) + elements[j]
    return psum[i][j]
