package 剑指offer;

/**
 * Created by user on 2017/11/29.
 */
public class Main10 {
    public static void main(String[] args) {

    }
    public int RectCover(int target) {
        if(target==0){
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return RectCover(target - 1) + RectCover(target - 2);
    }

}
