package 图论.最小树形图.朱刘算法;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by user on 2017/9/26.
 */
public class Main {
    static int maxn=100;
    static double g[][]=new double[maxn][maxn];//图的信息
    static int used[]=new int[maxn];//判断边是否已经被使用
    static int pass[]=new int[maxn];
    static int eg[]=new int[maxn];
    static int more,queue[]=new int[maxn],n,m;
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        //
        double ans=mdst(1);
    }

    private static double mdst(int root) {

        int i,j,k;
        double sum=0;
        Arrays.fill(used,0);
        for (more=1;more!=0;){
            more=0;
            Arrays.fill(eg,0);
            for ( i=1;i<=n;i++){
                if (used[i]==0&&i!=root){
                    for ( j=1,k=0;j<=n;j++){
                        if (used[j]==0&&i!=j){
                            if (k==0||g[j][i]<g[k][i]){
                                k=j;
                            }
                        }
                    }
                    eg[i]=k;
                }
            }
            Arrays.fill(pass,0);
            for ( i=1;i<=n;i++){
                if (used[i]==0&&pass[i]==0&&i!=root){
                    combine(i,sum);
                }
            }

        }
        for ( i=1;i<=n;i++){
            if (used[i]==0&&i!=root){
                sum+=g[eg[i]][i];
            }
        }
        return sum;
    }

    private static void combine(int id, double sum) {
        int tot=0,from,i,j,k;
        for (;id!=0&&pass[id]==0;id=eg[id]){
            queue[tot++]=id;
            pass[id]=1;
        }

    }
}
