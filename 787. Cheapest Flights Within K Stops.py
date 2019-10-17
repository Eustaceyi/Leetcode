class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, K: int) -> int:
        '''
        key point Dijkstra's algorithm,
        we need to put (price, steps left, pos) in the heap
        and keep tracking steps left, if we have tried all possible path and we still get no answer,
        we cannot go through
        and the first answer we meet should be the optimal solution
        '''
        graph = collections.defaultdict(dict)
        for a, b, price in flights:
            graph[a][b] = price
        
        pq = [(0, K+1, src)]
        while pq:
            price, k, pos = heapq.heappop(pq)
            if pos == dst:
                return price
            if k > 0:
                newpos = graph[pos]
                for p in newpos:
                    heapq.heappush(pq, (price+newpos[p], k-1, p))
        return -1