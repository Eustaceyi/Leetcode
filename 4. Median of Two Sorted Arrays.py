class Solution:
    def findMedianSortedArrays(self, nums1, nums2):
        '''
        The thought of this problem should be:
        median splits the whole array into two parts, 
        where the left part is as the same length of the right part,
        and also the max of the left part is samller or equal to the min of the right part.

        First we make the shorter array as nums1, thus we could use less time.
        And we make sure that the split of i and j keeps the left part anf the right part the same length.
        The next step should be checking the max of left and the min of right.
        When this satifies, this should be the solution.
        '''
        m, n = len(nums1), len(nums2)
        if m > n:
            nums1, nums2, m, n = nums2, nums1, n, m

        imin, imax, half_len = 0, m, (m + n + 1) // 2

        # do binary search here
        while imin <= imax:
            i = (imin + imax) // 2
            j = half_len - i

            if i < m and nums2[j-1] > nums1[i]:
                # i is too small, must increase it
                imin = i + 1

            elif i > 0 and nums1[i-1] > nums2[j]:
                # i is too big, must decrease it
                imax = i - 1

            else:
                # i is perfect
                if i == 0: max_of_left = nums2[j-1]
                elif j == 0: max_of_left = nums1[i-1]
                else: max_of_left = max(nums1[i-1], nums2[j-1])

                if (m + n) % 2 == 1:
                    return float(max_of_left)
                
                if i == m: min_of_right = nums2[j]
                elif j == n: min_of_right = nums1[i]
                else: min_of_right = min(nums1[i], nums2[j])

                return (max_of_left + min_of_right) / 2.0