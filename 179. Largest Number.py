'''
Key point: sort the array and keep in mind that need to reverse the two if 
x + y < y + x (in str), and this will make sure that 3 is before 30
https://leetcode.com/articles/largest-number/
'''

class LargerNumKey(str):
    def __lt__(x, y):
        return x+y > y+x
        
class Solution:
    def largestNumber(self, nums):
        largest_num = ''.join(sorted(map(str, nums), key=LargerNumKey))
        return '0' if largest_num[0] == '0' else largest_num