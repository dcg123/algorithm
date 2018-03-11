package 最大二分匹配;

/**
 * Created by user on 2017/10/16.
 */
public class poj3057 {
    /**
     * 题意：一副迷宫图'.'为空格，'D'为门，'#'为墙；

     现在每个空格处有一人，且每个时刻每个空格只能站一人；当走到门时为离开房间；求所有人撤离的最短时间，否则impossible；

     思路：由于空间中每个只能有一人，所以直接bfs求得的值不是最终值，采用二分图匹配；

     先bfs处理处每个人距离每一扇门的最短距离，并分别保存在单独一扇门对应的集合中；

     若一个人能到达一扇门，则将该人与之后各时刻该门的建边；

     求二分图的最大匹配，看是否能将所有人匹配完；从小时刻向大时刻枚举门，则为最优解；
     */
//    #include<cstdio>
//#include<cstring>
//#include<vector>
//#include<queue>
//#include<algorithm>
//    using namespace std;
//    int V,X,Y;
//    int dir[4][2]={{1,0},{-1,0},{0,1},{0,-1}};
//    vector<int> G[50010];
//    vector<int> dx,dy; //门的坐标
//    vector<int> px,py; //人的坐标
//    int link[50010];
//    int dist[13][13][13][13];
//    bool vis[50010];
//    char field[13][13];
//    void addedge(int u,int v){
//        G[u].push_back(v);
//        G[v].push_back(u);
//    }
//    bool dfs(int v){
//        vis[v]=true;
//        for(int i=0;i<G[v].size();i++){
//            int u=G[v][i];
//            if(link[u]==-1||!vis[link[u]]&&dfs(link[u])){
//                link[v]=u;
//                link[u]=v;
//                return true;
//            }
//        }
//        return false;
//    }
//    void bfs(int x,int y,int d[13][13]){ //传二维数组改变原四位数组
//        queue<int> qx,qy;
//        d[x][y]=0;
//        qx.push(x);qy.push(y);
//        while(!qx.empty()){
//            x=qx.front();qx.pop();
//            y=qy.front();qy.pop();
//            for(int k=0;k<4;k++){
//                int x2=x+dir[k][0];
//                int y2=y+dir[k][1];
//                if(0<=x2&&x2<X&&0<=y2&&y2<Y&&field[x2][y2]=='.'&&d[x2][y2]<0){
//                    d[x2][y2]=d[x][y]+1;
//                    qx.push(x2);
//                    qy.push(y2);
//                }//printf("mmmmmmm\n");
//            }
//        }
//    }
//    void solve(){
//        int n=X*Y;
//        dx.clear();dy.clear();
//        px.clear();py.clear();
//        memset(dist,-1,sizeof(dist));
//        for(int x=0;x<X;x++){
//            for(int y=0;y<Y;y++){
//                if(field[x][y]=='D'){
//                    dx.push_back(x);
//                    dy.push_back(y);
//                    bfs(x,y,dist[x][y]); //每个人能到该点的最小距离
//                }
//                else if(field[x][y]=='.'){ //if中的==要注意
//                    px.push_back(x);
//                    py.push_back(y);
//                }
//            }
//        }
//        int d=dx.size(),p=px.size();
//        V=X*Y*d+p;
//        for(int v=0;v<V;++v) G[v].clear();
//        for(int i=0;i<d;i++){
//            for(int j=0;j<p;j++){
//                if(dist[dx[i]][dy[i]][px[j]][py[j]]>=0){ //若该人能到达该门
//                    for(int k=dist[dx[i]][dy[i]][px[j]][py[j]];k<=n;k++){
//                        addedge((k-1)*d+i,n*d+j); //该人与不同时间的该门建边
//                    }
//                }
//            }
//        }
//        if(p==0) {
//            printf("0\n");
//            return;
//        }
//        int res=0;
//        memset(link,-1,sizeof(link));
//        for(int v=0;v<n*d;v++){//枚举门的集合
//            memset(vis,0,sizeof(vis));
//            if(dfs(v)){
//                if(++res==p){ //若所有人能逃出
//                    printf("%d\n",v/d+1);
//                    return;
//                }
//            }
//        }
//        printf("impossible\n");
//    }
//    int main()
//    {
//        int i,j,k,t;
//        scanf("%d",&t);
//        while(t--){
//            scanf("%d%d",&X,&Y);
//            for(i=0;i<X;i++) scanf("%s",field[i]);
//            solve();
//        }
//    }
}
