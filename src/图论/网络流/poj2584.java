package 图论.网络流;

/**
 * Created by user on 2017/10/19.
 */
public class poj2584 {
    /**
     * X个参赛选手，每个选手有衣服大小的范围，
     * 5种大小的队服，求是否能使每个选手都拿到符合自己大小范围的衣服。
     思路：
     源点向每种T-shirt连边， 权值为个数。 将人拆成两个点u和u'，
     T-shirt向u连边， 权值为1， u向u'连边， 权值为1， u'向汇点连边，
     权值为inf。 跑一遍最大流， 看结果是否等于n就可以了。
     */
//    #include <queue>
//#include <queue>
//#include <cstdio>
//#include <cstring>
//#include <iostream>
//#include <algorithm>
//#define inf 99999999
//    using namespace std;
//    int n,mmap[30][30],m,l[30],t;
//    int T_shirt[30];
//    int bfs()
//    {
//        queue<int >Q;
//        Q.push(0);
//        memset(l,-1,sizeof(l));
//        l[0]=0;
//        while(!Q.empty()) {
//            int u=Q.front();
//            Q.pop();
//            for(int i=0; i<=m; i++) {
//                if(l[i]==-1&&mmap[u][i]) {
//                    l[i]=l[u]+1;
//                    Q.push(i);
//                }
//            }
//        }
//        if(l[m]>1)return 1;
//        else return 0;
//    }
//    int dfs(int x,int f)
//    {
//        int a;
//        if(x==m)return f;
//        for(int i=0; i<=m; i++) {
//            if(mmap[x][i]&&l[i]==l[x]+1&&(a=dfs(i,min(f,mmap[x][i])))) {
//                mmap[x][i]-=a;
//                mmap[i][x]+=a;
//                return a;
//            }
//        }
//        l[x]=-1;
//        return 0;
//    }
//    int main()
//    {
//        int i,j;
//        char str[100];
//        char s[10];
//        T_shirt['S'-'A']=1;
//        T_shirt['M'-'A']=2;
//        T_shirt['L'-'A']=3;
//        T_shirt['X'-'A']=4;
//        T_shirt['T'-'A']=5;
//        while(cin>>str) {
//            memset(mmap,0,sizeof(mmap));
//            if(!strcmp(str,"ENDOFINPUT"))
//                break;
//            if(!strcmp(str,"END"))
//                continue;
//            cin>>n;
//            m=n+5+1;
//            for(i=1; i<=n; i++) {
//                cin>>s;
//                int a=T_shirt[s[0]-'A'];
//                int b=T_shirt[s[1]-'A'];
//                if(a>b)
//                    swap(a,b);
//                for(j=a; j<=b; j++) {
//                    mmap[j][i+5]=1;
//                }
//                mmap[i+5][m]=1;
//            }
//            for(i=1; i<=5; i++) {
//                scanf("%d",&t);
//                mmap[0][i]=t;
//            }
//            int ans=0;
//            cin>>str;
//            while(bfs())
//                while(t=dfs(0,inf))
//                    ans+=t;
//            if(ans==n)
//                cout<<"T-shirts rock!"<<endl;
//            else cout<<"I'd rather not wear a shirt anyway..."<<endl;
//            if(!strcmp(str,"END"))continue;
//        }
//        return 0;
//    }

}
