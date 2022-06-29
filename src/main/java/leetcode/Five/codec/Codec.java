package leetcode.Five.codec;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/6/29 4:57 PM
 * @Version: 1.initial version; 2022/6/29 4:57 PM
 */
public class Codec {
    Map<String, String> urls = new HashMap<>();
    AtomicInteger index = new AtomicInteger(0);
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String shortString = String.valueOf(index.get());
        urls.put(String.valueOf(index.get()), longUrl);
        index.getAndIncrement();
        return shortString;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return urls.get(shortUrl);
    }
}
