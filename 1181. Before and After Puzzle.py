class Solution:
    def beforeAndAfterPuzzles(self, phrases: List[str]) -> List[str]:
        '''
        Time O(n^2 + n * s) where s is len of longest string
        Space O(n) two hashmaps are used
        '''
        start = collections.defaultdict(list)
        end = collections.defaultdict(list)
        for i, ph in enumerate(phrases):
            phlist = ph.split(' ')
            start[phlist[0]].append((ph, i))
            end[phlist[-1]].append((ph, i))
            
        ans = set()
        for i, ph in enumerate(phrases):
            phlist = ph.split(' ')
            for st, j in end[phlist[0]]:
                if i != j:
                    ans.add(st + ' '.join([''] + phlist[1:]))
            for ed, j in start[phlist[-1]]:
                if i != j:
                    ans.add(' '.join(phlist[:-1] + ['']) + ed)
        return sorted(ans)