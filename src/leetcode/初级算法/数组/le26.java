package leetcode.初级算法.数组;

public class le26 {
    /**
     * 给定一个有序数组，你需要原地删除其中的重复内容，使每个元素只出现一次,并返回新的长度。

     不要另外定义一个数组，您必须通过用 O(1) 额外内存原地修改输入的数组来做到这一点。
     */


    public static void main(String[] args) {

        int []num = {0,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(num));
    }
    public static int removeDuplicates(int[] nums) {
        if (nums.length==0) {
            return 0;
        }
        int j = 0, n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] != nums[j]){
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }
}
