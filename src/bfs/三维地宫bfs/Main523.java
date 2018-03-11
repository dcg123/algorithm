package bfs.三维地宫bfs;

/**
 * Created by user on 2017/10/10.
 */
public class Main523 {
    /**
     * #include <cstdio>

     #include <cstring>

     using namespace std;

     int A,B,C,T;
     typedef struct Node{
     int x,y,z;
     int step;
     }Node;
     Node q[500000];

     struct M{
     int s[55][55];
     }a[55];

     int v[55][55][55];

     int dx[] = {-1,0,1,0,0,0};
     int dy[] = {0,1,0,-1,0,0};
     int dz[] = {0,0,0,0,1,-1};


     int bfs()
     {
     int tail,head;
     tail = head = 0;
     Node t,temp;
     t.x = t.y = t.z = t.step = 0;
     q[tail++] = t;
     while(head < tail)
     {
     t = q[head++];

     for(int i = 0;i < 6;++i)
     {
     temp.x = t.x + dx[i];
     temp.y = t.y + dy[i];
     temp.z = t.z + dz[i];
     temp.step = t.step + 1;
     if(temp.x == B - 1 && temp.y == C - 1 && temp.z == A - 1)
     {
     if(temp.step <= T)
     return temp.step;
     else
     return -1;
     }
     if(temp.x >=0&&temp.x<B&&temp.y>=0&&temp.y<C&&temp.z>=0&&temp.z<A&&a[temp.z].s[temp.x][temp.y] == 0&&!v[temp.x][temp.y][temp.z])
     {
     v[temp.x][temp.y][temp.z] = 1;
     q[tail++] = temp;
     }
     }
     }
     return -1;
     }
     int main()

     {
     int k;
     scanf("%d",&k);
     while(k--)
     {
     scanf("%d%d%d%d",&A,&B,&C,&T);
     memset(v,0,sizeof(v));
     for(int i = 0;i < A;++i)
     {
     for(int j = 0;j < B;++j)
     {
     for(int l = 0;l < C;++l)
     scanf("%d",&a[i].s[j][l]);
     }
     }
     v[0][0][0] = 1;
     if(a[A - 1].s[B - 1][C - 1])
     printf("-1\n");
     else printf("%d\n",bfs());
     }
     return 0;
     }

     */
}
