package 并查集;

import java.util.Scanner;

/**
 * Created by user on 2017/10/11.
 */
public class hdu1272 {
    /**
     * 上次Gardon的迷宫城堡小希玩了很久（见Problem B），
     * 现在她也想设计一个迷宫让Gardon来走。但是她设计迷宫的思路不一样，
     * 首先她认为所有的通道都应该是双向连通的，就是说如果有一个通道连通了房间A和B，
     * 那么既可以通过它从房间A走到房间B，也可以通过它从房间B走到房间A，为了提高难度，
     * 小希希望任意两个房间有且仅有一条路径可以相通（除非走了回头路）。小希现在把她的设计图给你，
     * 让你帮忙判断她的设计图是否符合她的设计思路。
     * 比如下面的例子，前两个是符合条件的，但是最后一个却有两种方法从5到达8。
     */
    static int Max=100000+10;
    static int pre[]=new int[Max];
    static boolean vis[]=new boolean[Max];
    static boolean flag;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextLine()){
            String str=scanner.nextLine();
            String c[]=str.split("\\s+");
            int a=Integer.valueOf(c[0]);
            int b=Integer.valueOf(c[1]);
            if (a==0&&b==0){
                System.out.println("Yes");
                continue;
            }
            if (a==-1&&b==-1){
                break;
            }
            Union(a,b);
            for (int i=0;i<Max;i++){
                pre[i]=i;
                vis[i]=false;
            }
            flag=true;
            vis[a]=vis[b]=true;
            int k=(c.length-2)/2;
            int count=2;
            for (int i=1;i<=k;i++){
                 a=Integer.valueOf(c[count++]);
                 b=Integer.valueOf(c[count++]);
                Union(a,b);
                vis[a]=vis[b]=true;
            }
            int ans=0;
            for (int i=1;i<Max;i++){
                if (vis[i]&&pre[i]==i){
                    ans++;
                }
                if (ans>1){
                    flag=false;
                    break;
                }
            }
            if (flag){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
    }

    private static void Union(int a, int b) {
        int x=find(a);
        int y=find(b);
        if (a!=b){
            pre[x]=y;
        }else {
            flag=false;
        }
    }

    private static int find(int a) {
        int r=a;
        while (r!=pre[r]){
            r=pre[r];
        }
        return r;
    }
}
