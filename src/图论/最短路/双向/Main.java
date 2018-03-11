package 图论.最短路.双向;

import java.util.*;

/**
 * Created by user on 2017/10/13.
 */
public class Main {
    static int INF= 0x3f3f3f3f;
    static int maxn = 1000000+10;
    class node{
        int v,len;
        node(int b,int c){
            this.v=b;
            this.len=c;
        }
    }
    static Main hdu=new Main();
    static int n,m;
    static Vector<node> G[]=new Vector[maxn];
    static Vector<node>G2[]=new Vector[maxn];
    static int dis[]=new int[maxn],vis[]=new int[maxn];
    static void spfa(Vector<node>G[]){
        Arrays.fill(dis,INF);
        Arrays.fill(vis,0);
        Queue<Integer> queue=new LinkedList<Integer>();
        dis[1]=0;
        vis[1]=1;
        queue.offer(1);
        while (queue.size()!=0){
            int cur=queue.poll();
            vis[cur]=0;
            for (int i=0;i<G[cur].size();i++){
                node temp=G[cur].get(i);
                if (dis[temp.v]>dis[cur]+temp.len){
                    dis[temp.v]=dis[cur]+temp.len;
                    if (vis[temp.v]==0){
                        vis[temp.v]=1;
                        queue.offer(temp.v);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int T;
        T=scanner.nextInt();
        while(T-->0){
            n=scanner.nextInt();
            m=scanner.nextInt();
            scanner.nextLine();
            int a,b,c;
            for(int i=0;i<=n;i++){
                G[i]=new Vector<node>();
                G2[i]=new Vector<node>();
            }
            for(int i=0;i<m;i++){
                String str=scanner.nextLine();
                String ss[]=str.split(" ");
                a=Integer.valueOf(ss[0]);
                b=Integer.valueOf(ss[1]);
                 c=Integer.valueOf(ss[2]);
                G[a].add(hdu.new node(b,c));// 正向建立图
                G2[b].add(hdu.new node(a,c)); //反向建立图
            }
            int ans = 0;
            spfa(G);
            for(int i=1;i<=n;i++)
                ans+= dis[i];
            spfa(G2);
            for(int i=1;i<=n;i++)
                ans+= dis[i];
            System.out.printf("%d\n",ans);
        }

    }
}
