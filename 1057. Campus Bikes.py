class Solution:
    def assignBikes(self, workers: List[List[int]], bikes: List[List[int]]) -> List[int]:
        '''
        Thinking of bucket sort:
        Since we have the furthest distance of bike and worker, so we can have buckets for every distance
        and we insert them as worker ascending and bike ascending order,
        after doing this, we pick worker bike pair and using set to remember them
        Time O(m*n)
        Space O(m*n)
        '''
        distances = [[] for i in range(2001)]
        for i, (x, y) in enumerate(workers):
            for j, (x_b, y_b) in enumerate(bikes):
                dist = abs(x-x_b) + abs(y-y_b)
                distances[dist].append((i, j))
                
        used_bikes = set()
        result = [-1] * len(workers)
        for dist in distances:
            for i, j in dist:
                if j not in used_bikes and result[i] == -1:
                    result[i] = j
                    used_bikes.add(j)
        return result