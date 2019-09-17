from collections import defaultdict, deque
class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        '''
        build graph and use dfs to find path
        '''
        def build_graph(tickets):
            for t in tickets:
                G[t[0]].append(t[1])
            for t in G:
                G[t] = deque(sorted(G[t], reverse=True))

        def find_route(S):
            route.append(S)
            if len(route) == len(tickets) +1:
                return True
            for i in range(len(G[S])):
                A = G[S].pop()
                if find_route(A):
                    return True
                G[S].appendleft(A)
            route.pop()
            return False
        
        G = defaultdict(list)
        build_graph(tickets)
        route = []
        find_route('JFK')
        return route