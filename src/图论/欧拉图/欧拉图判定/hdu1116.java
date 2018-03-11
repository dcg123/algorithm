package 图论.欧拉图.欧拉图判定;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by user on 2017/10/11.
 */
public class hdu1116 {
    //首要条件欧拉图
    //无向图中 欧拉图 当且仅当每个点的度都为偶数
    //无向图中 欧拉回路 当且仅当有0个或者两个奇数的点
    //有向图中 欧拉图 每个点的出度等于入度
    //有向图中 欧拉回路 除两个节点以外  每个节点出度等于入度 一个点入度=出度-1  一个点出度=入度+1

    static int n;
    static int pre[]=new int[30];
    static int in[]=new int[30];
    static int out[]=new int[30];
    static boolean vis[]=new boolean[30];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while (t-->0){
            n=scanner.nextInt();
            scanner.nextLine();
            Arrays.fill(out,0);
            Arrays.fill(in,0);
            Arrays.fill(vis,false);
            for (int i=0;i<30;i++){
                pre[i]=i;
            }
            for (int i=0;i<n;i++){
                String str=scanner.nextLine();
                int x=str.charAt(0)-'a';
                int y=str.charAt(str.length()-1)-'a';
                out[x]++;
                in[y]++;
                pre[x]=pre[y]=find(x);
                vis[x]=vis[y]=true;
            }
            int r=0;
            for (int i=0;i<30;i++){
                if (vis[i]&&pre[i]==i){
                    r++;
                }
            }
            if (r>1){
                System.out.println("The door cannot be opened.");
                continue;
            }
            boolean flag=false;
            int x=0,y=0,z=0;
            for (int i=0;i<30;i++){
                if(vis[i]&&in[i]!=out[i])
                {
                    if(in[i]==out[i]+1)
                    {
                        x++;
                    }
                    else if(in[i]+1==out[i])
                    {
                        y++;
                    }
                    else z++;
                }
            }
            if (z>0){
                System.out.println("The door cannot be opened.");
                continue;
            }
            if ((x==1&&y==1)||(x==0&&y==0)){
                System.out.println("Ordering is possible.");
                continue;
            }else {
                System.out.println("The door cannot be opened.");
            }
        }
    }

    private static int find(int x) {
        int r=x;
        while (r!=pre[r]){
            r=pre[r];
        }
        return r;
    }
}
