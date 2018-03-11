package 博弈论;

/**
 * Created by user on 2017/10/16.
 */

import java.util.Scanner;

/**
 * 题意：一开始有X枚硬币，有K种取法，a[1]，a[2]......a[k]，取走最后一枚硬币为胜利者，两个人取硬币，都以最优策略取硬币，Alice先取，问最终谁是胜利者。

 动态规划的思想（轮到Alice取硬币）：

 1.剩下0枚硬币，Alice为必败态。

 2.剩下i枚硬币，存在一种情况 i - a[ j ] 为必败态，Alice为必胜态。

 3.剩下i枚硬币，任何情况 i - a[ j ] 为必胜态，Alice为必败态。
 */
public class 硬币 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int x,k;
        int a[]=new int[100+20];
        boolean win[]=new boolean[10000+10];
        x=scanner.nextInt();
        k=scanner.nextInt();
        for (int i=0;i<k;i++){
            a[i]=scanner.nextInt();
        }
        win[0]=false;
        for (int j=1;j<=x;j++){
            win[j]=false;
            for (int i=0;i<k;i++){
                win[j]|=a[i]<=j&&!win[j-a[i]];
            }
        }
        if (win[x]){
            System.out.println("Alice");
        }else {
            System.out.println("Bob");
        }
    }
}
