class Solution:
    def containsNearbyAlmostDuplicate(self, nums: List[int], k: int, t: int) -> bool:
        '''
        Things like bucket sort, keep k buckets and bucket range is t
        if there is a number is within t distance, it will be in the bucket before/in/after the bucket of the number belongs
        '''
        bucket = {}
        for i, value in enumerate(nums):
            bucketind, offset = (value//t, 1) if t else (value, 0)
            for ind in range(bucketind-offset, bucketind+offset+1):
                if ind in bucket and abs(bucket[ind] - value) <= t:
                    return True
            bucket[bucketind] = value
            if len(bucket) > k:
                del bucket[nums[i - k] // t if t else nums[i - k]]
        return False
                    