class Solution:
    def intervalIntersection(self, A: List[List[int]], B: List[List[int]]) -> List[List[int]]:
        result = []
        pa = 0
        pb = 0
        while pa < len(A) and pb < len(B):
            if A[pa][0] > B[pb][1]:
                pb += 1
            elif A[pa][1] < B[pb][0]:
                pa += 1
            else:
                inters = [max(A[pa][0], B[pb][0]), min(A[pa][1], B[pb][1])]
                result.append(inters)
                if A[pa][1] < B[pb][1]:
                    pa += 1
                else:
                    pb += 1
        return result