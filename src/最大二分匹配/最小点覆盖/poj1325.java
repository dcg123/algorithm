package 最大二分匹配.最小点覆盖;

/**
 * Created by user on 2017/10/19.
 */
public class poj1325 {
    /**
     *
     题目大意：有两个机器A和B，A机器有n个模式，B机器有m个模式,两个机器最初在0模式
     然后有k个作业，每个作业有三个参数i，a，b
     i代表作业编号，a和b代表第i作业要么在A机器的a模式下完成【或者】在B机器的b模式下完成
     问两个机器总共最少变换多少次可以完成所有作业
     解题思路：很水的一个二分图的最小点覆盖
     建立一个二分图，左边代表A机器，有n个点，代表有n个模式
     右边代表B机器，有m个点，代表有m个模式
     现在对于每个作业，i,a,b都使左边a点指向右边b点即可
     这样如果我们要把所有的作业做完，是不是找出最小的点覆盖将所有的边都覆盖掉即可
     然后最小点覆盖等于最大匹配，用匈牙利直接过
     */

//    /*
//Memory 212K
//Time   32MS
//*/
//#include <iostream>
//    using namespace std;
//#define MAXV 110
//
//    int n,m,k;
//    int map[MAXV][MAXV];
//    int link[MAXV],use[MAXV];
//
//    int dfs(int x){
//        int i,j;
//        for(i=1;i<=m;i++)
//            if(map[x][i] && !use[i]){
//                j=link[i];
//                use[i]=1;
//                link[i]=x;
//                if(j==-1 || dfs(j)) return true;
//                link[i]=j;
//            }
//        return false;
//    }
//
//    int hungary(){
//        int num=0;
//        int i,j;
//        memset(link,-1,sizeof(link));
//        for(i=1;i<=n;i++){
//            for(j=1;j<=m;j++) use[j]=0;
//            if(dfs(i)) num++;
//        }
//        return num;
//    }
//
//    int main(){
//        int a,b,c,i;
//        while(scanf("%d",&n) && n){
//            scanf("%d%d",&m,&k);
//            memset(map,0,sizeof(map));
//            for(i=0;i<k;i++){
//                scanf("%d%d%d",&a,&b,&c);
//                map[b][c]=1;
//            }
//            printf("%d\n",hungary());
//        }
//        return 0;
//    }
}
