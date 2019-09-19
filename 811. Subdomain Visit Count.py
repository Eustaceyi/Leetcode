from collections import defaultdict
class Solution:
    def subdomainVisits(self, cpdomains: List[str]) -> List[str]:
        dic = defaultdict(int)
        for item in cpdomains:
            (count, web) = item.split()
            weblist = web.split('.')
            dom = ''
            for i in weblist[::-1]:
                dom = i + '.' + dom
                dic[dom] += int(count)
        return [' '.join([str(dic[key]), key])[:-1] for key in dic]