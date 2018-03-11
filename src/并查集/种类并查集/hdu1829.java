package 并查集.种类并查集;

/**
 * Created by user on 2017/10/11.
 */
public class hdu1829 {
    /**
     * 统计输入的数据是否有相同的根节点，有的话就是违法的，
     * 结果也就出来了，没有相同根节点的话，得分别处理，
     * 这就得麻烦一点，标志一下它们的性别，多定义个sex数组，参考代码：
     */
//   #include <cstdio>
//#include <cstdlib>
//#include <climits>
//#include <cstring>
//#include <algorithm>
//
//    using namespace std;
//
//const int MAX = 2000;
//
//    int pre[2*MAX+5];
//
//    bool mark;
//
//    void init(int n){
//        int i;
//        ////（author：CSDN：凌风）
//        for(i=1;i<=MAX+n;++i)pre[i] = i;
//        mark = true;
//    }
//
//    int root(int x){
//        if(x!=pre[x]){
//            pre[x] = root(pre[x]);
//        }
//        return pre[x];
//    }
//
//    void merge(int x,int y){
//        int fx,fy;
//        fx = root(x);
//        fy = root(y-MAX);
//
//        if(fx==fy){
//            mark = false;
//            return;
//        }
//
//        fy = root(y);
//        if(fx!=fy){
//            pre[fx] = pre[fy];
//        }
//    }
//
//    int main(){
//        //freopen("in.txt","r",stdin);
//        //（author：CSDN：凌风）
//        int t,i,n,m,x,y,k;
//        scanf("%d",&t);
//        for(i=1;i<=t;++i){
//            scanf("%d %d",&n,&m);
//            init(n);
//            for(k=1;k<=m;++k){
//                scanf("%d %d",&x,&y);
//                if(mark){
//                    merge(x,y+MAX);
//                    merge(y,x+MAX);
//                }
//            }
//            printf("Scenario #%d:\n",i);
//            if(mark){
//                printf("No suspicious bugs found!\n");
//            }else{
//                printf("Suspicious bugs found!\n");
//            }
//            printf("\n");
//        }
//        return 0;
//    }

}
