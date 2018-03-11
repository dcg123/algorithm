package 最大二分匹配;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by user on 2017/8/21.
 */
public class poj1274 {
    /**
     * n牛，m个房子，每个牛都只住在自己想住的房子里面，一个房子只能住一个牛，问最多可以安排多少头牛入住；
     像案例里的，第一头牛只愿意住2,5；第二头牛，只住2,3,4；第三头只住1,5；第四头只住1,2,5；第五头住2；
     */
    static int MAX_N=200+10;
    static int map[][]=new int[MAX_N][MAX_N];
    static int n,m;
    static int link[]=new int[MAX_N];
    static int used[]=new int[MAX_N];
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            n=scanner.nextInt();
            m=scanner.nextInt();
            init();
            for(int i=1;i<=n;i++){
                int x=scanner.nextInt();
                for(int j=1;j<=x;j++){
                    int to=scanner.nextInt();
                    map[i][to]=1;
                }
            }
            System.out.println(hungary());
        }

    }

    private static int  hungary() {
        int num=0;

        Arrays.fill(link,-1);
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++)
                used[j]=0;
            if(dfs(i)){
                num++;
            }
        }
        return num;
    }

    private static boolean dfs(int s) {
        int j=0;
        for(int i=1;i<=m;i++){
            if(map[s][i]==1&&used[i]==0){
                used[i]=1;
                j=link[i];
                link[i]=s;
                if(j==-1||dfs(j)){
                    return true;
                }
                link[i]=j;
            }
        }
        return false;
    }

    private static void init() {
        for(int i=0;i<=n;i++){
            for(int j=1;j<=m;j++){
                map[i][j]=0;
            }
        }
    }
}
