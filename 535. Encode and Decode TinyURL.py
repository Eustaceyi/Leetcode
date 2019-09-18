class Codec:
    def __init__(self):
        self.short2long = {}
        self.long2short = {}
        self.clist = 'ABCDEFGIJKLMNOPQRSTUVWXYZabcdefghijlmnopqrstuvwxyz1234567890'

    def encode(self, longUrl):
        """Encodes a URL to a shortened URL.
        
        :type longUrl: str
        :rtype: str
        """
        while longUrl not in self.long2short:
            short = ''.join([random.choice(self.clist) for _ in range(6)])
            if short not in self.short2long:
                self.short2long[short] = longUrl
                self.long2short[longUrl] = short
        return 'http://tinyurl.com/' + short
        

    def decode(self, shortUrl):
        """Decodes a shortened URL to its original URL.
        
        :type shortUrl: str
        :rtype: str
        """
        return self.short2long[shortUrl.split('/')[-1]]
        

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.decode(codec.encode(url))