package 最大二分匹配.有向图最小路径覆盖;

/**
 * Created by user on 2017/10/19.
 */
public class poj1548 {
    /**
     * 题目大意:给出一个矩阵，从最左上点到最右下点走，并且只能往下走和往右走，在矩阵中的一些格子中有含有一个‘G’，问最少从最左上到最右下走多少次，能把所有的G都走到
     解题思路：
     很明显，要将所有的G都走到，这样可以联想到最小路径匹配，然后就是怎么建图
     建图：
     对于任意两个含有'G'的点，如果a点在b点的左上方，则让a指向b
     这样再求最小路径覆盖，找到最小的路径，将所有点都覆盖了
     而最小路径覆盖=点数-最大匹配数
     */

    /*
//Memory 524K
//Time   32MS
//*/
//#include <iostream>
//    using namespace std;
//#define MAXV 600
//
//    typedef struct{
//        int x,y;
//    }Point;
//
//    Point pt[MAXV];
//    int pt_sum;
//    bool map[MAXV][MAXV],use[MAXV];
//    int link[MAXV];
//
//    int dfs(int x){
//        int i,j;
//        for(i=0;i<pt_sum;i++){
//            if(!use[i] && map[x][i]){
//                use[i]=1;
//                j=link[i];
//                link[i]=x;
//                if(j==-1 || dfs(j)) return true;
//                link[i]=j;
//            }
//        }
//        return false;
//    }
//
//    int hungary(){
//        int i,num=0;
//        memset(link,-1,sizeof(link));
//        for(i=0;i<pt_sum;i++){
//            memset(use,0,sizeof(use));
//            if(dfs(i)) num++;
//        }
//        return pt_sum-num;
//    }
//
//    int main(){
//        int i,j;
//        pt_sum=0;
//        while(scanf("%d%d",&pt[pt_sum].x,&pt[pt_sum].y) && pt[pt_sum].x!=-1 && pt[pt_sum].y!=-1){
//            pt_sum++;
//            while(scanf("%d%d",&pt[pt_sum].x,&pt[pt_sum].y) && pt[pt_sum].x || pt[pt_sum].y) pt_sum++;
//
//            memset(map,0,sizeof(map));
//            for(i=0;i<pt_sum;i++){
//                for(j=i+1;j<pt_sum;j++){
//                    if(pt[i].x<=pt[j].x && pt[i].y<=pt[j].y){
//                        map[i][j]=1;							//如果i在j的左上方
//                    }else{
//                        if(pt[i].x>=pt[j].x && pt[i].y>=pt[j].y){
//                            map[j][i]=1;						//如果j在i的左上方
//                        }
//                    }
//                }
//            }
//
//            printf("%d\n",hungary());
//            pt_sum=0;
//        }
//        return 0;
//    }
}
