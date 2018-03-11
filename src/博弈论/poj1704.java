package 博弈论;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by user on 2017/10/16.
 */
public class poj1704 {
    /**
     * 排在直线的格子上放有n个旗子 旗子i在左树的第pi个格子上 两个人
     * 轮流选择一个旗子想走移动 每次可以移动一格及其以上任意多个 单是不徐云反超其他的旗子 也不允许将两个
     * 旗子放在同一个格子内
     * 无法进行移动操作的一方失败  江苏Ge先进性移动
     *
     * 思路 转化成Nim游戏
     * 当旗子个数是偶数时 每两个旗子构成一堆  当对其中给一个其中进行操作时 石子堆里面进行相应的增加或者减少
     * 如果为奇数时 第一个旗子单独成堆
     */
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int p[]=new int[1000];
        for (int i=0;i<n;i++){
            p[i]=scanner.nextInt();
        }
        if (n%2==0){
            p[n++]=0;
        }
        Arrays.sort(p,0,n);
        int x=0;
        for (int i=0;i+1<n;i+=2){
            x^=(p[i+1]-p[i]-1);
        }
        if (x==0){
            System.out.println("Bob");
        }else
        System.out.println("Georgia");
    }
}
