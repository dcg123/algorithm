package 图论.无向图求桥和割点;

/**
 * Created by user on 2017/10/18.
 */
public class 删除割点求联通分量 {
    /**
     * 拿左边的图举例，有一个网络，在这个网络只能是点对点通信，如果3号节点出故障了，
     * 那么1号节点与2号节点，4号节点和5号节点还是可以通信的，不过1，2号不能和4，5号节点通信了。
     * 这样3号节点就是一个SPF节点,并且当3号节点出故障了分为了2个子网络
     差不多就是说与许多点，有些点之间有无向边，问删除某个点之后，可以将图分为几块
     */
    /*
//Memory 1172K
//Time    16MS
//*/
//#include <iostream>
//    using namespace std;
//#define MAXV 1010
//            #define min(a,b) (a>b?b:a)
//
//    bool map[MAXV][MAXV];		//保存图
//    int rcnt;					//记录输入的结点
//    int dfn[MAXV],low[MAXV];	//深度与最低深度优先数
//    bool vis[MAXV];				//标记结点是否被寻找
//    int son;					//树根的子女结点的个数
//    int subnets[MAXV];			//记录删除i点后的连通分量
//    int count;					//记录访问
//
//    void init(){
//        memset(dfn,0,sizeof(dfn));
//        memset(low,0,sizeof(low));
//        memset(vis,0,sizeof(vis));
//        memset(subnets,0,sizeof(subnets));
//        son=0;
//        count=1;
//        dfn[1]=low[1]=1;	//对根节点初始化
//        vis[1]=1;
//    }
//
//    void dfs(int x){			//tajrjan
//        for(int i=1;i<=rcnt;i++){
//            if(map[x][i]){
//                if(!vis[i]){
//                    vis[i]=1;
//                    dfn[i]=low[i]=++count;
//                    dfs(i);
//                    low[x]=min(low[x],low[i]);
//                    if(low[i]>=dfn[x]){
//                        if(x!=1) subnets[x]++;
//                        if(x==1) son++;
//                    }
//                }else low[x]=min(low[x],dfn[i]);
//            }
//        }
//    }
//
//    void work(){
//        init();
//        dfs(1);
//    }
//    void Output(){
//        int flag=0;
//        if (son>1) subnets[1]=son-1;			//到时候输出要+1
//        for(int i=1;i<=rcnt;i++){
//            if(subnets[i]){
//                printf("  SPF node %d leaves %d subnets\n",i,subnets[i]+1);
//                flag=1;
//            }
//        }
//        if(!flag) printf("  No SPF nodes\n");
//        printf("\n");
//    }
//
//    void cntv(int x){
//        rcnt=(rcnt>x?rcnt:x);
//    }
//
//    int main(){
////	freopen("d:\\test.in","r",stdin);
//        int a,b,Case=0;
//        while(scanf("%d",&a) && a){
//            memset(map,0,sizeof(map));
//            scanf("%d",&b);
//            map[a][b]=map[b][a]=1;
//            rcnt=0;
//            cntv(a),cntv(b);
//            while(scanf("%d",&a) && a){
//                scanf("%d",&b);
//                map[a][b]=map[b][a]=1;
//                cntv(a),cntv(b);
//            }
//            work();
//            printf("Network #%d\n",++Case);
//            Output();
//        }
//        return 0;
//    }
}
