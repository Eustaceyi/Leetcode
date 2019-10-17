class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        '''
        Using stack to keep track of the logs
        ''' 
        ans = [0 for _ in range(n)] # ans array
        stack = []                  # the stack for keep tracking
        prev = 0                    # the var for recording prev timestamp
        for log in logs:
            log = log.split(':')
            # for start condition
            if log[1] == 'start':
                # if there is a switch of functions
                if stack:
                    # update the being switched function
                    ans[stack[-1]] += int(log[2]) - prev
                # put the new one into stack and update the timestamp
                stack.append(int(log[0]))
                prev = int(log[2])
            # for end condition
            else:
                # there must be a function in stack, update its time
                ans[stack[-1]] += int(log[2]) - prev + 1
                stack.pop()
                prev = int(log[2]) + 1
        return ans