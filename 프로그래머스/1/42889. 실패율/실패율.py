def solution(N, stages):
    answer = []
    
    failure =[[-1.0,0]]
    sort_stages = sorted(stages)
    
    #i는 스테이지 단계
    for i in range(1,N+1):
        if len(sort_stages) ==0 :
            failure.append([0.0,i])
        else:
            failure.append([sort_stages.count(i)/len(sort_stages),i])
        while(i in sort_stages):
            sort_stages.remove(i)

    rank = []
    failure = sorted(failure,reverse=True)
    
    for j in range(0,len(failure)-1):
        rank.append(failure[j][1])
        if failure[j][0] != failure[j+1][0]:
            rank.sort()
            answer +=rank
            rank = []

    return answer