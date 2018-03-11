package 最大二分匹配.最小点覆盖;

/**
 * Created by user on 2017/10/19.
 */
public class poj2226 {
    /**
     * 题目大意：用木板将'*'覆盖，同一行或同一列的'*'可以用一块木板覆盖，'.'不能被覆盖。问最少用多少块木板可以把全部的'*'覆盖?
     木板只能够覆盖连续的横着的泥巴和竖着的泥巴,中间有草地就要隔开
     解题思路：二分匹配的经典构图题目
     构图思路：
     将横着的木板和看成一边的点的集合,将竖着的木板看成另外一边的点的集合,如果他们相交于一点就连边
     如果要把所有的泥巴覆盖,又要所需要的木板最少，那么就是求最小点覆盖
     所以用匈牙利求最大匹配数即可
     */


//#include <iostream>
//    using namespace std;
//#define MAXV 1000
//            #define MAXS 60
//
//    char s[MAXS][MAXS];
//    bool map[MAXV][MAXV];
//    int tmp[MAXS][MAXS],n,m,cvsum,rvsum;
//    int link[MAXV],use[MAXV];
//
//    void build_gragh(){
//        int i,j,flag=0;
//        cvsum=rvsum=0;
//        memset(map,0,sizeof(map));
//        memset(tmp,0,sizeof(tmp));
//
//        for(i=1;i<=n;i++){
//            flag=0;
//            for(j=1;j<=m;j++){
//                if(flag==0 && s[i][j]=='*'){ flag=1; cvsum++; }
//                if(flag==1 && s[i][j]=='*') tmp[i][j]=cvsum;
//                if(s[i][j]=='.') flag=0;
//            }
//        }
//
//        for(i=1;i<=m;i++){
//            flag=0;
//            for(j=1;j<=n;j++){
//                if(flag==0 && s[j][i]=='*'){ flag=1; rvsum++; }
//                if(flag==1 && s[j][i]=='*') map[tmp[j][i]][rvsum]=1;
//                if(s[j][i]=='.') flag=0;
//            }
//        }
//    }
//
//    int dfs(int x){
//        int i,j;
//        for(i=1;i<=rvsum;i++)
//            if(!use[i] && map[x][i]){
//                use[i]=1;j=link[i];link[i]=x;
//                if(j==-1 || dfs(j)) return true;
//                link[i]=j;
//            }
//        return false;
//    }
//
//    int hungary(){
//        int num=0,i,j;
//        memset(link,-1,sizeof(link));
//        for(i=1;i<=cvsum;i++){
//            for(j=1;j<=rvsum;j++) use[j]=0;
//            if(dfs(i)) num++;
//        }
//        return num;
//    }
//
//    int main(){
//        int i;
//        while(~scanf("%d%d\n",&n,&m)){
//            for(i=1;i<=n;i++) gets(s[i]+1);
//            build_gragh();
//            printf("%d\n",hungary());
//        }
//        return 0;
//    }
}
