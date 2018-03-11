package 博弈论;

import java.util.Scanner;

/**
 * Created by user on 2017/10/16.
 */
public class Nim经典题目 {
    /**
     * 有N堆石子 每堆有ai颗石子 alice和bob轮流从非空的石子堆中取走至少一颗石子
     * alice先去 去逛所有石子的一方获胜 当双方读才去最优策虐是 谁会获胜
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n;
        int a[]=new int[10000];
        n=scanner.nextInt();
        for (int i=0;i<n;i++){
            a[i]=scanner.nextInt();
        }
        int x=0;
        for (int i=0;i<n;i++){
            x^=a[i];
        }
        if (x!=0){
            System.out.println("Alice");
        }else {
            System.out.println("Bob");
        }
    }
}
