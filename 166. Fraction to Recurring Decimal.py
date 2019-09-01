class Solution:
    def fractionToDecimal(self, n: int, d: int) -> str:
        if n == 0:
            return '0'
        output1 = ''
        output2 = ''
        count = 0
        if n * d < 0:
            output1 += '-'
            if n < 0:
                n = -n
            if d < 0:
                d = -d
        dic = {}
        div, rai = divmod(n, d)
        if rai == 0:
            return output1 + str(div)
        output1 += str(div) + '.'
        n = rai
        while n != 0 and n not in dic:
            div, rai = divmod(n*10, d)
            dic[n] = (count, div, rai)
            count+=1
            output2 += str(div)
            n = rai
        if n == 0: 
            return output1 + output2
        else:
            output2 = output2[:dic[n][0]] + '(' + output2[dic[n][0]:] + ')'
            return output1 + output2