package 最大二分匹配.最小点覆盖;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by user on 2017/10/7.
 */
public class Main237 {
    /**
     * 最小点覆盖 =最大匹配数
     *
     * 有一位传说级游戏高手，在闲暇时间里玩起了一个小游戏，游戏中，
     * 一个n*n的方块形区域里有许多敌人，玩家可以使用炸弹炸掉某一行或者某一列的所有敌人。
     * 他是种玩什么游戏都想玩得很优秀的人，所以，他决定，使用尽可能少的炸弹炸掉所有的敌人。

     现在给你一个游戏的状态，请你帮助他判断最少需要多少个炸弹才能炸掉所有的敌人吧。
     */
    static int n,k;
    static Vector<Integer> vector[]=new Vector[510];
    static int used[]=new int[510];
    static int gril[]=new int[510];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while (t-->0){
            n=scanner.nextInt();
            k=scanner.nextInt();
            for (int i=0;i<=n;i++){
                    vector[i]=new Vector<Integer>();
            }
            Arrays.fill(gril,0);
            scanner.nextLine();
            for (int i=0;i<k;i++){
                String str=scanner.nextLine();
                String a[]=str.split(" ");
                int x=Integer.valueOf(a[0]),y=Integer.valueOf(a[1]);
                vector[x].add(y);
            }
            int sum=0;
            for (int i=1;i<=n;i++){
                Arrays.fill(used,0);
                if (found(i)){
                    sum++;
                }
            }
            System.out.println(sum);
        }
    }

    private static boolean found(int x) {
        int d=vector[x].size();
        for (int i=0;i<d;i++){
            int t=vector[x].get(i);
            if (used[t]==0){
                used[t]=1;
                if (gril[t]==0||found(gril[t])){
                    gril[t]=x;
                    return true;
                }
            }
        }
        return false;
    }
}
