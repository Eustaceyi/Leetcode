public class Codec {
    Map<String, String> stol, ltos;
    int count;
    String pre = "http://tinyurl.com/";
    public Codec() {
        stol = new HashMap<>();
        ltos = new HashMap<>();
        count = 0;
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (ltos.containsKey(longUrl)) {
            return ltos.get(longUrl);
        }
        String shortUrl = pre + count;
        count++;
        ltos.put(longUrl, shortUrl);
        stol.put(shortUrl, longUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return stol.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));