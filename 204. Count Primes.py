class Solution(object):
    def countPrimes(self, n):
        """
        Sieve of Eratosthenes: https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes#Algorithm_complexity
        """
        if n <= 2:
            return 0
        
        prime = [True] * n
        prime[:2] = [False, False]
        for base in range(2, int((n - 1) ** 0.5) + 1):
            if prime[base]:
                prime[base ** 2::base] = [False] * len(prime[base ** 2::base])
        return sum(prime)