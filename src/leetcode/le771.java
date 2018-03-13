package leetcode;

/**
 * @author dcg
 *         Created by user on 2018/3/13.
 */
public class le771 {
    /**
     * 通过遍历字符串S和J，两两进行比较，判断stone中有多少颗jewel。
     */
    public int numJewelsInStones(String J, String S) {
        int count=0;
        for (int i=0;i<S.length();i++){
            for (int j=0;j<J.length();j++){
                if (S.charAt(i)==J.charAt(j)){
                    count++;
                }
            }
        }
        return count;
    }
}
