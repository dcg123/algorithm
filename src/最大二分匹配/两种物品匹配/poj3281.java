package 最大二分匹配.两种物品匹配;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by user on 2017/10/16.
 */
public class poj3281 {
    /**
     * 约翰 为他的N头牛准备了F中食物材料和D中饮料 每头牛都有各自喜欢的食物和饮料 而每种食物或者饮料
     * 只能分配给一头牛 最多能有图头牛可以同时得到喜欢的食物和饮料
     */
    //思路 两次匹配 求最大流
    /**
     * 解题思路：建图,有2*n+f+d+2个顶点
     0表示源点,2*n+f+d+1表示汇点
     由源点指向食物,再由食物指向牛,牛再指向对应的饮料,饮料再指向汇点
     当然要使每一头牛都对应每一份食物与饮料,所以应该牛i指向牛i再指向饮料,这样就可以避免一头牛只占用多份食物与饮料了
     全部是有向的边,而且权值全部为1
     我在这里是1到f为食物点，f+1到f+2*n为牛点，f+2*n+1到f+2*n+d为饮料点
     */
    static int MAXV =410;
    static int INF=999999;
    static int res[][]=new int[MAXV][MAXV];		//残量
    static int	dis[]=new int[MAXV];				//表示多少层
    static int source,sink,n,maxflow;	//n为总的点数
    static int bfs(){
        int k;
        Queue<Integer> q=new LinkedList<Integer>();
        Arrays.fill(dis,-1);
        dis[sink]=0;
        q.offer(sink);
        while(q.size()!=0){
            k=q.poll();
            for(int i=0;i<n;i++){
                if(dis[i]==-1 && res[i][k]==1){
                    dis[i] = dis[k] + 1;
                    q.offer(i);
                }
            }
            if(k==source) return 1;
        }
        return 0;
    }

    static int dfs(int cur,int cp){
        if(cur==sink)	return cp;

        int tmp=cp,t;
        for(int i=0;i<n && tmp!=0;i++){
            if(dis[i]+1==dis[cur] && res[cur][i]==1){
                t=dfs(i,Math.min(res[cur][i],tmp));
                res[cur][i]-=t;
                res[i][cur]+=t;
                tmp-=t;
            }
        }
        return cp-tmp;
    }

    static void dinic(){
        maxflow=0;
        while(bfs()>0) maxflow+=dfs(source,INF);
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int f,d;
        int i,j,f_sum,d_sum,tmp;
        n=scanner.nextInt();
        f=scanner.nextInt();
        d=scanner.nextInt();
            for (i=0;i<MAXV;i++){
                for (j=0;j<MAXV;j++){
                    res[i][j]=0;
                }
            }
            source=0;
            sink=2*n+f+d+1;

            for(i=1;i<=f;i++) res[source][i]=1;		//源点指向食物
            for(i=1;i<=d;i++) res[2*n+f+i][sink]=1;		//饮料指向汇点
            for(i=1;i<=n;i++) res[f+i][f+n+i]=1;	//牛指向牛
            //点的顺序，食物，奶牛，饮料

            for(i=1;i<=n;i++){
                f_sum=scanner.nextInt();
                d_sum=scanner.nextInt();
                for(j=1;j<=f_sum;j++){
                    tmp=scanner.nextInt();
                    res[tmp][f+i]=1;		//食物指向牛
                }
                for(j=1;j<=d_sum;j++){
                    tmp=scanner.nextInt();
                    res[i+f+n][2*n+f+tmp]=1;	//牛指向饮料
                }
            }
            n=sink+1;				//代表总的点数了

            dinic();
            System.out.printf("%d\n",maxflow);


    }
}
