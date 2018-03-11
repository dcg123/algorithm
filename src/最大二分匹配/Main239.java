package 最大二分匹配;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by user on 2017/10/7.
 * k=10000*t =4000000  临街矩形超时
 * 使用邻接表
 */
public class Main239 {
    static int n,k;
    static Vector<Integer> vector[]=new Vector[510];
    static int used[]=new int[510];
    static int girl[]=new int[510];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while (t-->0){
            n=scanner.nextInt();
            k=scanner.nextInt();
            init();
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
                if (girl[t]==0||found(girl[t])){
                    girl[t]=x;
                    return true;
                }
            }
        }
        return false;
    }

    private static void init() {
        Arrays.fill(girl,0);
        for (int i=0;i<=n;i++){
            vector[i]=new Vector<Integer>();
        }
    }
}
