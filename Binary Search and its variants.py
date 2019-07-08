def BinarySearch(nums, target):
    lo, hi = 0, len(nums)-1
    while lo <= hi:
        mid = (hi - lo)//2 + lo
        if nums[mid] == target:
            return True
        elif nums[mid] < target:
            lo = mid + 1
        else:
            hi = mid - 1
    return False

def LeftMostBinarySearch(nums, target):
    lo, hi = 0, len(nums)
    while lo < hi:
        mid = (hi - lo)//2 + lo
        if nums[mid] < target:
            lo = mid + 1
        else:
            hi = mid
    return lo

def RightMostBinarySearch(nums, target):
    lo, hi = 0, len(nums)
    while lo < hi:
        mid = (hi - lo)//2 + lo
        if nums[mid] <= target:
            lo = mid + 1 
        else:
            hi = mid
    return lo - 1