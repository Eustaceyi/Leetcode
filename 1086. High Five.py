class Solution:
    def highFive(self, items: List[List[int]]) -> List[List[int]]:
        dic = {}
        for item in items:
            if item[0] in dic:
                dic[item[0]].append(item[1])
            else:
                dic[item[0]] = [item[1]]
        result = []
        for item in dic:
            result.append([item, sum(sorted(dic[item], reverse=True)[:5])//5])
        return result