package leetcode.初级算法.数组;

public class le260 {
    /**
     * 给定一个整数数组，除了某个元素外其余元素均出现两次。请找出这个只出现一次的元素。
     *
     * 一个整数和它本身异或之后得到值是0，0与其他整数异或得到的是这个整数本身
     */
    public static void main(String[] args) {
        int[] arr = { 0, 1, 1, 2, 2, 3, 0 };
        System.out.println(singleNumber(arr));
    }
    public static int singleNumber(int[] nums) {
        if (nums.length==0){
            return -1;
        }
        int result=0;
        for (int i=0;i<nums.length;i++){
            result=result^nums[i];
        }
        return result;
    }
}
