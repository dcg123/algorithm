package 并查集.带权并查集;

/**
 * Created by user on 2017/10/11.
 */
public class hdu3047 {
    public static void main(String[] args) {
        /**
         * 有n个人坐在zjnu体育馆里面，然后给出m个他们之间的距离， A B X， 代表B的座位比A多X.
         * 然后求出这m个关系之间有多少个错误，所谓错误就是当前这个关系与之前的有冲突。

         分析与总结：
         题目有一句话：we assume the number of rows were infinite. 就是假设这个体育馆是无限大的，
         所以不用考虑圆圈循环的情况。
         用带权并查集做， 对于并查集中的每一棵数， 树根的距离为0，然后以树根作为参照，
         每个结点的权值代表与树根的距离。
         合并A，B时，假设A，B属于不同的树，那么就要合并这两棵树， 把A树合并到B树上，
         这时要给A树的跟结点root_a赋值，关键是给root_a附上一个什么值。 由于A点和B点的权值rank[A]和
         rank[B]都是相对跟结点的距离，所以分析A，B之间的相对距离，可以得到rank[root_a] = rank[A]+x-rank[B]。 注意到这时，对于原来的A的树，
         只跟新了root_a跟结点的权值， 那么其它结点的跟新在查找的那一步里面实行了。
         */
//        #include<cstdio>
//#include<cmath>
//        using namespace std;
//#define N 50005
//        int f[N], rank[N], n, m;
//
//        void init(){
//            for(int i=0; i<=n; ++i)
//                f[i]=i, rank[i]=0;
//        }
//        int find(int x){
//            if(x==f[x]) return f[x];
//            int t=f[x];
//            f[x] = find(f[x]);
//            rank[x] += rank[t];
//            return f[x];
//        }
//        bool Union(int x,int y, int m){
//            int a=find(x), b=find(y);
//            if(a==b){
//                if(rank[x]+m!=rank[y])
//                    return false;
//                return true;
//            }
//            f[b] = a;
//            rank[b] = rank[x]+m-rank[y];
//            return true;
//        }
//
//        int main(){
//            int a,b,x;
//            while(~scanf("%d%d",&n,&m)){
//                init();
//                int cnt=0;
//                for(int i=0; i<m; ++i){
//                    scanf("%d%d%d",&a,&b,&x);
//                    if(!Union(a, b, x)){
//                        ++cnt;
//                    }
//                }
//                printf("%d\n",cnt);
//            }
//            return 0;
//        }
    }
}
