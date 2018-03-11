package 基础dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by user on 2017/10/15.
 */
public class hdu1661 {
    class Node{
        int x,y,h;
    }
    static int N=1000+10;
    static int dp[][]=new int[N][2];
    static Node node[]=new Node[N];
    class cmp implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return 0;
        }
    }
    static hdu1661 hdu=new hdu1661();
    static int n,sx,sy,Hmax;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while (t-->0){
            n=scanner.nextInt();
            sx=scanner.nextInt();
            sy=scanner.nextInt();
            scanner.nextLine();
            for (int i=0;i<n;i++){
                String str=scanner.nextLine();
                String a[]=str.split(" ");
                int x=Integer.valueOf(a[0]);
                int y=Integer.valueOf(a[1]);
                int h=Integer.valueOf(a[2]);
                node[i]=hdu.new Node();
                node[i].x=x;
                node[i].y=y;
                node[i].h=h;
            }
        }
        Arrays.sort(node,0,n,hdu.new cmp());

    }
}
//#include <cstdio>
//#include <vector>
//#include <algorithm>
//#include <cstring>
//
//using namespace std;
//        const int MAXN = 1e3+7;
//        const int inf = 1e9;
//        int dp[MAXN][2];
//        int n,x,y,H;
//        struct node
//        {
//        int x1,x2,h;
//        bool operator < (const node &a)const
//        {
//        return h > a.h;
//        }
//        } p[MAXN];
//        int main()
//        {
//        int t;
//        scanf("%d",&t);
//        while(t--)
//        {
//        scanf("%d%d%d%d",&n,&x,&y,&H);
//        int cnt = 0;
//        for(int i = 0 ; i < n ; ++i)
//        {
//        scanf("%d%d%d",&p[cnt].x1,&p[cnt].x2,&p[cnt].h);
//        if(p[cnt].h < y)cnt++;
//        }
//        //加入当前Jimmy的位置
//        p[cnt].x1 = x;
//        p[cnt].x2 = x;
//        p[cnt++].h=y;
//        sort(p,p+cnt);
//        for(int i = 0 ; i < cnt ; ++i)dp[i][0] = dp[i][1] = inf;//默认为inf
//        dp[0][0] = dp[0][1] = 0;//边界为0
//        int ans = inf;
//        for(int j = 0 ; j < cnt ; ++j)
//        {
//        int flag = 0;
//        //查找左端点降落的板子
//        for(int i = j+1 ; i < cnt ; ++i)
//        {
//        int d = p[j].h - p[i].h;
//        if(d <= H)
//        {
//        if(p[j].x1 >= p[i].x1 && p[j].x1 <= p[i].x2)
//        {
//        dp[i][0] = min(dp[i][0],dp[j][0] + d + p[j].x1 - p[i].x1);
//        dp[i][1] = min(dp[i][1],dp[j][0] + d + p[i].x2 - p[j].x1);
//        flag = 1;
//        break;
//        }
//        }
//        else break;
//        }
//        //如果不存在，并且高度符合条件，更新答案
//        if(!flag && p[j].h <= H)ans = min(ans,dp[j][0] + p[j].h);
//        //同理，右端点
//        flag = 0;
//        for(int i = j+1 ; i < cnt ; ++i)
//        {
//        int d = p[j].h - p[i].h;
//        if(d <= H)
//        {
//        if(p[j].x2 >= p[i].x1 && p[j].x2 <= p[i].x2)
//        {
//        dp[i][0] = min(dp[i][0],dp[j][1] + d + p[j].x2 - p[i].x1);
//        dp[i][1] = min(dp[i][1],dp[j][1] + d + p[i].x2 - p[j].x2);
//        flag = 1;
//        break;
//        }
//        }
//        else break;
//        }
//        if(!flag && p[j].h <= H)ans = min(ans,dp[j][1] + p[j].h);
//        }
//        printf("%d\n",ans);
//        }
//
//        return 0;
//        }
//
