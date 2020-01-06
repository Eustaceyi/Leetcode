from heapq import heappush, heappop
class Solution:
    def trapRainWater(self, heightMap: List[List[int]]) -> int:
        if not heightMap or not heightMap[0]:
            return 0
        heap = []
        count = 0
        low = 0
        seen = set()
        m,n = len(heightMap), len(heightMap[0])
        for i in range(m):
            heappush(heap, (heightMap[i][0], i, 0))
            heappush(heap, (heightMap[i][n-1], i, n-1))
            seen.add(i*n)
            seen.add(i*n+n-1)
        for i in range(n):
            heappush(heap, (heightMap[0][i], 0, i))
            heappush(heap, (heightMap[m-1][i], m-1, i))
            seen.add(i)
            seen.add((m-1)*n+i)
        while heap:
            hei, row, col = heappop(heap)
            if hei > low:
                low = hei
            count += low - hei if hei < low else 0
            if row > 0 and (row-1)*n+col not in seen:
                heappush(heap, (heightMap[row-1][col], row-1, col))
                seen.add((row-1)*n+col)
            if row < m-1 and (row+1)*n+col not in seen:
                heappush(heap, (heightMap[row+1][col], row+1, col))
                seen.add((row+1)*n+col)
            if col > 0 and row*n+col-1 not in seen:
                heappush(heap, (heightMap[row][col-1], row, col-1))
                seen.add(row*n+col-1)
            if col < n-1 and row*n+col+1 not in seen:
                heappush(heap, (heightMap[row][col+1], row, col+1))
                seen.add(row*n+col+1)
        return count