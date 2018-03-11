package 剑指offer;

/**
 * Created by user on 2017/11/29.
 */
public class Main8 {
    public static void main(String[] args) {

    }
    public int JumpFloor(int target) {
        if (target<=0){
            return -1;
        }
        if (target==1){
            return 1;
        }
        if (target==2){
            return 2;
        }
        else
        return JumpFloor(target-1)+JumpFloor(target-2);
    }
}
