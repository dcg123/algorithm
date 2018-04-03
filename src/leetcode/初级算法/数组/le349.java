package leetcode.初级算法.数组;

import java.util.Arrays;

public class le349 {
    public static void main(String[] args) {
        int a[]={7,2,2,4,7,0,3,4,5};
        int b[]={3,9,8,6,1,9};
        intersect(a,b);
    }
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int nums3[]=new int[nums1.length>nums2.length?nums1.length:nums2.length];
        int begin1=0;
        int begin2=0;
        int begin3=0;
        boolean flag=false;
        while (true){
            if (begin1>=nums1.length||begin2>=nums2.length){
                break;
            }
            if (nums1[begin1]==nums2[begin2]){
                nums3[begin3]=nums1[begin1];
                begin1++;begin2++;begin3++;
                continue;
            }
            while ((nums1[begin1]<nums2[begin2])){
                begin1++;
                if (begin1>=nums1.length){
                    flag=true;
                    break;
                }
            }
            if (flag){
                break;
            }
            while ((nums1[begin1]>nums2[begin2])){
                begin2++;
                if (begin2>=nums2.length){
                    flag=true;
                    break;
                }
            }
        }
//        for (int i=0;i<begin3;i++){
//            System.out.println(nums3[i]);
//        }

        return nums3;

    }
}
