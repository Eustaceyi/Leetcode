class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        '''
        This uses Priority Queue for arranging the tasks,
        for each time we check the PQ to see that if we have task to schedule or idle
        and finally count the time that we use
        Time O(time for all tasks include idle times) the insertion time for pq and temp are all constant O(1)
        Space O(1) constant space used
        '''
        dic = collections.defaultdict(int)
        for t in tasks:
            dic[t] += 1
            
        pq = []
        for t in dic:
            heapq.heappush(pq, -dic[t])
        totaltime = 0
        temp = []
        while pq:
            currtime = 0
            while currtime <= n:
                if pq:
                    count = heapq.heappop(pq)
                    if count < -1:
                        temp.append(count+1)
                currtime+=1
                totaltime+=1
                if not pq and not temp:
                    return totaltime
            while temp:
                count = temp.pop()
                heapq.heappush(pq, count)
        
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        '''
        Math method, first we at least use the total task time to preceed
        then we need to calculate all idle slots
        so we pick the most frequent task and the max idle slot should be n * count_of_most-1
        then we fill the tasks into the remaining slots
        finally we compute the total slot
        Time O(n) since sorting 26 element array is considered as O(1)
        Space O(1) constant spaces used
        '''
        n_tasks = sorted(collections.Counter(tasks).values(), reverse=True)
        most = n_tasks.pop(0)
        n_gaps = most - 1
        idle = n_gaps * n
        for n_task in n_tasks:
            idle -= min(n_task, n_gaps) # it is either the same count with max or smaller than the max
            if idle <= 0:
                idle = 0
                break
        return len(tasks) + idle