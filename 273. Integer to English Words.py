si = ['', 'One ', 'Two ', 'Three ', 'Four ', 'Five ', 'Six ', 'Seven ', 'Eight ', 'Nine ']
teen = ['Ten ', 'Eleven ', 'Twelve ', 'Thirteen ', 'Fourteen ', 'Fifteen ', 'Sixteen ', 'Seventeen ', 'Eighteen ', 'Nineteen ']
te = ['', 'Ten ', 'Twenty ', 'Thirty ', 'Forty ', 'Fifty ', 'Sixty ', 'Seventy ', 'Eighty ', 'Ninety ']
di = ['', 'Thousand ', 'Million ', 'Billion ', 'Trillion ']

class Solution:
    def numberToWords(self, num: int) -> str:
        if num == 0:
            return "Zero"
        result = []
        count = 0
        while num:
            num, res = divmod(num, 1000)
            if res == 0:
                count += 1
                continue
            result.append(di[count])
            result.append(self.ntow(res))
            count += 1
        return ''.join(reversed(result)).strip(' ')
            
    def ntow(self, num):
        if num == 0:
            return ''
        num, single = divmod(num, 10)
        hund, ten = divmod(num, 10)
        if hund == 0:
            if ten == 1:
                return teen[single]
            else:
                return te[ten] + si[single]
        else:
            if ten == 1:
                return si[hund] + 'Hundred ' + teen[single]
            else:
                return si[hund] + 'Hundred ' + te[ten] + si[single]
            