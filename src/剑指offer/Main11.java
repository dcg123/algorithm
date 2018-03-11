package 剑指offer;

/**
 * Created by user on 2017/11/29.
 */
public class Main11 {
    public static void main(String[] args) {
        System.out.println(NumberOf1(302));
    }
    public static int NumberOf1(int n) {
        int count = 0;
        if(n == 0)
            return count;
        while(n != 0){
            ++count;
            n = (n-1) & n;
        }
        return count;
    }
}
