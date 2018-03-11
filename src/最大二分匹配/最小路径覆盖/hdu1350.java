package 最大二分匹配.最小路径覆盖;

/**
 * Created by user on 2017/10/12.
 */
public class hdu1350 {
    /**
     * /**
     最小路径覆盖：在图中找尽量少的路径，使得每个节点恰好
     在一条路径上（不同的路径不能有公共点）注：单独的节点
     也可以作为一条路径。
     最小路径覆盖值 k=节点数n-最大匹配数m

#include<stdio.h>
#include<iostream>
#include<string.h>
#include<algorithm>
    using namespace std;
    int n;
const int MAXV = 550;
    bool G[MAXV][MAXV], vis[MAXV];
    int match[MAXV], p_time[MAXV];      //p_time记录该点的出发时间
    int fabs ( int x ) {                //绝对值

        return x >= 0 ? x : -x;
    }
    int cal_dis ( int x1, int y1, int x2, int y2 ) {
        //两节点间的距离
        return  fabs ( x1 - x2 ) + fabs ( y1 - y2 );
    }
    bool find_AP ( int u ) {            //找增广路

        for ( int i = 1; i <= n; i++ ) {

            if ( G[u][i] && !vis[i] ) {

                vis[i] = true;

                if ( !match[i] || find_AP ( match[i] ) ) {

                    match[i] = u;
                    return true;
                }
            }
        }

        return false;
    }
    int main() {

        int t, a, b, c, d;
        scanf ( "%d", &t );

        while ( t-- ) {

            int st_x[MAXV], st_y[MAXV], en_x[MAXV], en_y[MAXV];
            int ans = 0, dis_st_en, dis_en_st, tmph, tmpm;
            memset ( G, 0, sizeof ( G ) );
            memset ( match, 0, sizeof ( match ) );
            memset ( p_time, 0, sizeof ( p_time ) );
            scanf ( "%d", &n );

            for ( int i = 1; i <= n; i++ ) {
                scanf ( "%d:%d%d%d%d%d", &tmph, &tmpm, &a, &b, &c, &d );
                p_time[i] = tmph * 60 + tmpm;
                st_x[i] = a;
                st_y[i] = b;
                en_x[i] = c;
                en_y[i] = d;
            }

            for ( int i = 1; i <= n; i++ ) {    //建图

                for ( int j = i + 1; j <= n; j++ ) {

                    dis_st_en = cal_dis ( st_x[i], st_y[i], en_x[i], en_y[i] );
                    dis_en_st = cal_dis ( en_x[i], en_y[i], st_x[j], st_y[j] );

                    if ( p_time[i] + dis_st_en + dis_en_st + 1 <= p_time[j] ) {
                        //将客人当做节点，如果送完客人i后还能接到客人j，连一条路
                        G[i][j] = true;
                    }
                }
            }

            for ( int i = 1; i <= n; i++ ) {
                memset ( vis, 0, sizeof ( vis ) );

                if ( find_AP ( i ) )
                    ans++;

            }
            printf ( "%d\n", n - ans );
        }
        return 0;
    }

     */
}
