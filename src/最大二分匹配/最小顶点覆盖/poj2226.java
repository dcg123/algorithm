package 最大二分匹配.最小顶点覆盖;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by user on 2017/10/16.
 */
public class poj2226 {
    /**
     * 题目大意：用木板将'*'覆盖，同一行或同一列的'*'可以用一块木板覆盖，
     * '.'不能被覆盖。问最少用多少块木板可以把全部的'*'覆盖?
     木板只能够覆盖连续的横着的泥巴和竖着的泥巴,中间有草地就要隔开
     解题思路：二分匹配的经典构图题目
     构图思路：
     将横着的木板和看成一边的点的集合,将竖着的木板看成另外一边的点的集合,如果他们相交于一点就连边
     如果要把所有的泥巴覆盖,又要所需要的木板最少，那么就是求最小点覆盖
     所以用匈牙利求最大匹配数即可
     */
    static int MAX=100;
    static boolean map[][]=new boolean[MAX][MAX];
    static int tmp[][]=new int[MAX][MAX];
    static int n,m,cvsum,rvsum;
    static int link[]=new int[MAX],use[]=new int[MAX];
    static String s[]=new String[MAX];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        m=scanner.nextInt();
        scanner.nextLine();
        for (int i=1;i<=n;i++){
            s[i]=scanner.nextLine();
        }
        build_graph();
        System.out.printf("%d\n",hungary());
    }

    private static int hungary() {
        int num=0,i,j;
        Arrays.fill(link,-1);
        for(i=1;i<=cvsum;i++){
            for(j=1;j<=rvsum;j++) use[j]=0;
            if(dfs(i)) num++;
        }
        return num;
    }

    private static boolean dfs(int x) {
        int i,j;
        for(i=1;i<=rvsum;i++)
            if(use[i]==0 && map[x][i]){
                use[i]=1;j=link[i];link[i]=x;
                if(j==-1 || dfs(j)) return true;
                link[i]=j;
            }
        return false;
    }

    private static void build_graph() {
        cvsum=rvsum=0;
        for (int i=0;i<MAX;i++){
            for (int j=0;j<MAX;j++){
                map[i][j]=false;
                tmp[i][j]=0;
            }
        }
        boolean flag=false;
        for (int i=1;i<n;i++){
            flag=false;
            for (int j=1;j<=m;j++){
                if (!flag&&s[i].charAt(j-1)=='*'){
                    flag=true;
                    cvsum++;
                }
                if (flag&&s[i].charAt(j-1)=='*'){
                    tmp[i][j]=cvsum;
                }
                if (s[i].charAt(j-1)=='.'){
                    flag=false;
                }
            }
        }
        for (int i=1;i<=m;i++){
            flag=false;
            for (int j=1;j<=n;j++){
                if(!flag && s[j].charAt(i-1)=='*'){ flag=true; rvsum++; }
                if(flag&& s[j].charAt(i-1)=='*') map[tmp[j][i]][rvsum]=true;
                if(s[j].charAt(i-1)=='.') flag=false;
            }
        }
    }
}
