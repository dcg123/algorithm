package leetcode.数组;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dcg
 * Created by user on 2018/4/1.
 */
public class le78 {
    /**
     * 给定一组不同的整数 nums，返回所有可能的子集（幂集）。
     */
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> temp = new ArrayList();
        dfs(result,temp,nums,0);
        return result;
    }

    private static void dfs(List<List<Integer>> result, List<Integer> temp, int[] nums, int j) {
        result.add(new ArrayList<Integer>(temp));
        for (int i=j;i<nums.length;i++){
            temp.add(nums[j]);
            dfs(result,temp,nums,i+1);
            temp.remove(temp.size()-1);
        }

    }
}
