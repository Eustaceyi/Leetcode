class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        '''
        Custom sort
        '''
        let = []
        dig = []
        for log in logs:
            if log[-1].isdigit():
                dig.append(log[:])
            else:
                let.append(log[:])
        def find_space(s):
            i = 0
            while i < len(s):
                if s[i] == ' ':
                    return i+1
                else:
                    i += 1
        let = sorted(let)
        let = sorted(let, key=lambda x: x[find_space(x):])
        return let + dig