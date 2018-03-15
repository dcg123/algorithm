package leetcode;

/**
 * @author dcg
 *         Created by user on 2018/3/15.
 */
public class le796 {
    public boolean rotateString(String A, String B) {
        for (int i=0;i<A.length();i++){
            if ((A.substring(i,A.length())+A.substring(0,i)).equals(B)){
                return true;
            }
        }
        return false;
    }
}
