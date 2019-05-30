class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        '''
        This uses a helper function to add chars into the string we have, and finally add it to the list.
        '''
        mapping = {
            '2' : ['a', 'b', 'c'],
            '3' : ['d', 'e', 'f'],
            '4' : ['g', 'h', 'i'],
            '5' : ['j', 'k', 'l'],
            '6' : ['m', 'n', 'o'],
            '7' : ['p','q','r','s'],
            '8' : ['t', 'u', 'v'],
            '9' : ['w', 'x', 'y', 'z']
        }
        
        def hiddenmethod(s, rc):
            if len(rc) == 0:
                toret.append(s)
            else:
                for char in mapping[rc[0]]:
                    hiddenmethod(s+char, rc[1:])
        
        toret = []
        if digits:
            hiddenmethod('', digits)
        return toret
            