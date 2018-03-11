package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by user on 2017/10/4.
 */
public class Main999 {
    static int n,m,t;
    class Node{
        int x,y,time;
    }
    static Main999 main999=new Main999();
    static int d[][]={{0,-1},{0,1},{-1,0},{1,0}};
    static char map[][]=new char[110][110];
    static boolean vis[][]=new boolean[110][110];
    static int ex,ey,eex,eey;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            n=scanner.nextInt();
            m=scanner.nextInt();
            if (n+m==0){
                break;
            }
            t=scanner.nextInt();
            scanner.nextLine();
            int sx=0,sy=0;
            for (int i=0;i<n;i++){
                String str=scanner.nextLine();
                char a[]=str.toCharArray();
                for (int j=0;j<m;j++){
                    map[i][j]=a[j];
                    if (map[i][j]=='S'){
                        sx=i;
                        sy=j;
                        map[i][j]='.';
                    }
                    if (map[i][j]=='D'){
                        ex=i;
                        ey=j;
                    }
                    if (map[i][j]=='E'){
                        eex=i;
                        eey=j;
                    }
                }
            }
            int ans=bfs(sx,sy);
        }
    }

    private static int bfs(int x, int y) {
        Queue<Node> queue=new LinkedList<Node>();
        init();
        vis[x][y]=true;
        Node temp=main999.new Node();
        temp.x=x;
        temp.y=y;
        temp.time=0;
        queue.offer(temp);
        int count=0;
        return 0;
    }

    private static void init() {
        for (int i=0;i<110;i++){
            for (int j=0;j<110;j++){
                vis[i][j]=false;
            }
        }
    }
}
/**
 * #include<cstdio>
 #include<cstring>
 #include<iostream>
 #include<algorithm>
 #include<queue>
 #include<cmath>
 using namespace std;
 const int dx[] = {1,-1,0,0};
 const int dy[] = {0,0,1,-1};
 bool vis[105][105][5];
 char map[105][105];
 int n,m,t;
 struct node{
 int x,y;
 int step,st;
 };
 bool ok(int x,int y){//判断的是否能走，可以把师傅或二师兄看做墙即不能走
 if(map[x][y] == 'E'|| map[x][y] == 'D' || map[x][y] == 'X')
 return false;
 return true;
 }
 char graph(char c,int Bool){//师傅或二师兄所在的行和列标记有多不同

 if((Bool && c == 'e') || (!Bool && c == 'd'))
 return 'x';//'x'可以记为把师傅和二师兄都被找到的状态
 return Bool?'d':'e';
 }
 void solve(int x,int y,int Bool)//处理师傅或二师兄所在的行和列
 {
 for(int i = x + 1;i < n && ok(i,y);i++)
 map[i][y] = graph(map[i][y],Bool);
 for(int i = x - 1;i >= 0 && ok(i,y);i--)
 map[i][y] = graph(map[i][y],Bool);
 for(int i = y + 1;i < m && ok(x,i);i++)
 map[x][i] = graph(map[x][i],Bool);
 for(int i = y - 1;i >= 0 && ok(x,i);i--)
 map[x][i] = graph(map[x][i],Bool);
 }
 int getST(char c,int st){//处理当前所走的状态
 if(c == 'd') st |= 1;
 else if(c == 'e') st |= 2;
 else if(c == 'x') st |= 3;
 return st;
 }
 bool find(int x,int y,int st){
 if(!ok(x,y)) return false;
 if(vis[x][y][st]) return false;
 if(x < 0 || x > n || y < 0 || y > m) return false;
 return true;
 }
 int bfs(int sta,int end){
 memset(vis,false,sizeof(vis));
 node p,q;
 queue<node> Q;
 p.x = sta,p.y = end,p.step = 0;
 p.st = getST(map[sta][end],0);
 vis[p.x][p.y][p.st] = true;
 Q.push(p);

 while(!Q.empty()){

 q = Q.front();Q.pop();
 if(q.st == 3) return q.step;//问是否能达到3的状态，即师傅和二师兄都被找到
 for(int i = 0;i < 4;i++){
 p.x = dx[i] + q.x;
 p.y = dy[i] + q.y;
 p.st = q.st;
 if(find(p.x,p.y,p.st))
 {
 p.st = getST(map[p.x][p.y],p.st);
 p.step = q.step + 1;
 vis[p.x][p.y][p.st] = true;
 Q.push(p);
 }
 }
 }
 return 900;
 }
 int main(){
 int sx,sy,ca = 1;
 while(~scanf("%d%d%d",&n,&m,&t)){
 getchar();
 for(int i = 0;i < n;i++){
 cin >> map[i];
 for(int j = 0;j < m;j++)
 if(map[i][j] == 'S')
 sx = i,sy = j;
 }
 for(int i = 0;i < n;i++){
 for(int j = 0;j < m;j++)
 {
 if(map[i][j] == 'D')
 solve(i,j,1);
 else if(map[i][j] == 'E')
 solve(i,j,0);
 }
 }
 printf("Case %d:\n",ca++);
 int ans = bfs(sx,sy);
 if(ans <= t)
 printf("%d\n",ans);
 else puts("-1");
 }
 }

 */
