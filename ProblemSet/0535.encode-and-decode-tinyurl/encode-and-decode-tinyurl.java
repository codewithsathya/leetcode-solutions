public class Codec {

    List<String> table = new ArrayList<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        table.add(longUrl);
        return "http://tinyurl.com/" + (table.size() - 1);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String str = shortUrl.replace("http://tinyurl.com/", "");
        int index = Integer.valueOf(str);
        return table.get(index);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));