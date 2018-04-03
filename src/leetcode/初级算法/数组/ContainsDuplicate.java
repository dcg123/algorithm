package leetcode.初级算法.数组;

import java.util.Arrays;

public class ContainsDuplicate{

    /**
     * 给定一个整数数组，判断是否存在重复元素。

     如果任何值在数组中出现至少两次，函数应该返回 true。如果每个元素都不相同，则返回 false。
     * @param args
     */
    public static void main(String[] args) {
        int nums[]={3,3};
        System.out.println(containsDuplicate(nums));
    }
    public static boolean containsDuplicate(int[] nums) {
        if (nums.length==0){
            return false;
        }
        Arrays.sort(nums,0,nums.length);
        for (int i=1;i<nums.length;i++){
            if (nums[i]==nums[i-1]){
                return true;
            }
        }
        return false;
    }

}
