package leetcode;

import java.util.ArrayList;

/**
 * @author dcg
 *         Created by user on 2018/3/13.
 */
public class le535 {
    ArrayList<String> urLs=new ArrayList<String>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int index=urLs.size();
        urLs.add(longUrl);
        return String.valueOf(index);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int index=Integer.parseInt(shortUrl);
        return urLs.get(index);
    }
}
