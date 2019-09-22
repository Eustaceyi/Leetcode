class Solution:
    def findMinDifference(self, timePoints: List[str]) -> int:
        ts = sorted([self.timetoint(time) for time in timePoints])
        mindiff = 2**31-1
        for i, tm in enumerate(ts):
            if i < len(ts)-1:
                mindiff = min(mindiff, ts[i+1]-tm)
            else:
                diff = 23*60+59-tm + 1 + ts[0]
                mindiff = min(mindiff, diff)
        return mindiff
        
    def timetoint(self, time):
        t = time.split(':')
        return int(t[0])*60+int(t[1])