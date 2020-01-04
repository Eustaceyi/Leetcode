class Solution:
    def licenseKeyFormatting(self, S: str, K: int) -> str:
        S = S.replace("-","").upper()
        length = len(S)
        list_k = [S[0:len(S)% K]]
        S = S[len(S) % K:]
        i = 0
        while i < length:
            list_k.append(S[i:i+K])
            i += K
        list_k = [x for x in list_k if x]
        return "-".join(list_k)