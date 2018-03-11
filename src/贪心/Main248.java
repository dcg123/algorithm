package 贪心;

import java.util.Scanner;

/**
 * Created by user on 2017/10/11.
 */
public class Main248 {
    //题目大意：约翰要将k个物品从起点0运到终点E,已知在0~E上有n个商店，每个商店X[i]最多允许买F个物品。
// 且花费C[i]元钱。且每个物品每运一个单位长度花费1元钱。问最终完成任务需要最少花费的钱数。
//解题思路：首先，已知每个商店的位置和该商店物品的单价。那么就可以先计算出各个商店运送一个物品
//所花费的钱数。按升序排好序。从花费最少的商店开始运送，如果可以一次性运完，那直接运完。
//否则，剩余的交给下一个商店运送，直到所有物品运完为止，同时这样的花费就是最少的花费。
    public static void main(String[] args) {
        Scanner  scanner=new Scanner(System.in);
    }
}
