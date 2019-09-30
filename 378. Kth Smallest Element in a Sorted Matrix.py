class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        '''
        Using heap to pick first n smallest items
        Time O(klogn)
        Space O(n)
        '''
        heap = []
        n = len(matrix)
        for i in range(n):
            heapq.heappush(heap, (matrix[0][i], 0, i))
        for i in range(k):
            num, row, col = heapq.heappop(heap)
            if row < n-1:
                heapq.heappush(heap, (matrix[row+1][col], row+1, col))
            
        return num

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        '''
        Binary Search
        Time O(N∗log(max−min))
        Space O(1)
        '''
        n = len(matrix)
        start, end = matrix[0][0], matrix[n - 1][n - 1]
        while start < end:
            mid = start + (end - start) // 2
            smaller, larger = (matrix[0][0], matrix[n - 1][n - 1])

            count, smaller, larger = self.count_less_equal(matrix, mid, smaller, larger)

            if count == k:
                return smaller
            if count < k:
                start = larger  # search higher
            else:
                end = smaller  # search lower

        return start


    def count_less_equal(self, matrix, mid, smaller, larger):
        count, n = 0, len(matrix)
        row, col = n - 1, 0
        while row >= 0 and col < n:
            if matrix[row][col] > mid:
        # as matrix[row][col] is bigger than the mid, let's keep track of the
        # smallest number greater than the mid
                larger = min(larger, matrix[row][col])
                row -= 1
            else:
        # as matrix[row][col] is less than or equal to the mid, let's keep track of the
        # biggest number less than or equal to the mid
                smaller = max(smaller, matrix[row][col])
                count += row + 1
                col += 1

        return count, smaller, larger