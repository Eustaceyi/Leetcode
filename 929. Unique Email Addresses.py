class Solution:
    def numUniqueEmails(self, emails: List[str]) -> int:
        ans = set()
        for email in emails:
            em = email.split('@')
            fp = "".join(em[0].split('+')[0].split('.'))
            ans.add(fp+"@"+em[1])
        return len(ans)