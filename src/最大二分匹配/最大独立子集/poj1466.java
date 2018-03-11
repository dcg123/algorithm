package 最大二分匹配.最大独立子集;

/**
 * Created by user on 2017/10/16.
 */
public class poj1466 {
    /**
     * 题目大意：有n个学生，每个学生都和一些人又关系，现在要你找出最大的人数，使得这些人之间没关系
     解题思路：裸的最大独立集，最大独立集=点数-最大匹配数
     这里注意因为是两两匹配，所以求出的匹配值要除上个2
     */
//#include <iostream>
//    using namespace std;
//#define MAXV 505
//
//    int map[MAXV][MAXV];
//    int n;
//    int link[MAXV],use[MAXV];
//
//    bool dfs(int x){
//        int i,j;
//        for(i=0;i<n;i++){
//            if(!use[i] && map[x][i]){
//                use[i]=1;
//                if(link[i]==-1 || dfs(link[i])){
//                    link[i]=x;
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    int hungary(){
//        int num=0,i;
//        memset(link,-1,sizeof(link));
//        for(i=0;i<n;i++){
//            memset(use,0,sizeof(use));
//            if(dfs(i)) num++;
//        }
//        return n-num/2;
//    }
//
//    int main(){
//        int i,j,cnt;
//        int a,b;
//        while(~scanf("%d",&n)){
//            memset(map,0,sizeof(map));
//            for(i=0;i<n;i++){
//                scanf("%d: (%d)",&a,&cnt);
//                for(j=0;j<cnt;j++){
//                    scanf("%d",&b);
//                    map[a][b]=1;
//                }
//            }
//            printf("%d\n",hungary());
//        }
//        return 0;
//    }
}
