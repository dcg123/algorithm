package 图论;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by user on 2017/10/7.
 */
public class Main188 {
    static int n,m;
    static double map[][]=new double[35][35];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=0;
        while (scanner.hasNext()){
            n=scanner.nextInt();
            if (n==0){
                break;
            }
            scanner.nextLine();
            HashMap<String,Integer> hashMap=new HashMap<String, Integer>();
            init();
            int count=1;
            for (int i=0;i<n;i++){
                String str=scanner.nextLine();
                if (hashMap.get(str)==null){
                    hashMap.put(str,count);
                    count++;
                }
            }
            m=scanner.nextInt();
            scanner.nextLine();
            for (int i=0;i<m;i++){
                String str=scanner.nextLine();
                String  a[]=str.split(" ");
                int u=hashMap.get(a[0]);
                int v=hashMap.get(a[2]);
                double cost=Double.valueOf(a[1]);
                map[u][v]=cost;
            }
            ++t;
            if (floyd()){
                System.out.println("Case "+t+": Yes");
            }else {
                System.out.println("Case "+t+": No");
            }
        }
    }

    private static boolean floyd() {
        for (int k=1;k<=n;k++){
            for (int i=1;i<=n;i++){
                for (int j=1;j<=n;j++){
                    if (map[i][j]<map[i][k]*map[k][j]){
                        map[i][j]=map[i][k]*map[k][j];
                    }
                }
            }
        }
        for (int i=1;i<=n;i++){
            if (map[i][i]>1){
                return true;
            }
        }
        return false;
    }

    private static void init() {
        for (int i=0;i<35;i++){
            for (int j=0;j<35;j++){
                if (i==j)
                    map[i][j]=1;
                else
                map[i][j]=0;
            }
        }
    }
}
