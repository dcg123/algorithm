package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class poj2688 {

	/**
	 * @param args
	 *
	 */
	class P {
		int x, y, id;

		P() {
		}

		P(int x, int y, int id) {
			this.x = x;
			this.y = y;
			this.id = id;
		}
	}

	class A implements Comparable<A> {
		int x, y, step, score;

		A() {
		};

		A(int x, int y, int step, int score) {//
			this.x = x;
			this.y = y;
			this.step = step;
			this.score = score;
		}

		@Override
		public int compareTo(A o) {
			// TODO Auto-generated method stub
			return (score - o.score);
		}

	}

	static poj2688 poj = new poj2688();
	static char[][] g = new char[25][25];
	static int[][] mat = new int[12][12];
	static int[][] dp = new int[11][1 << 11];
	static int w, h, n;
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static boolean[][] mark = new boolean[25][25];
	static boolean[][] ok = new boolean[11][1 << 11];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			w = scan.nextInt();
			h = scan.nextInt();
			if (w == 0 && h == 0) {
				break;
			}
			scan.nextLine();
			ArrayList<P> v = new ArrayList<>();
			int num = 1;
			for (int i = 1; i <= h; i++) {
				String str = scan.nextLine();
				char a[] = str.toCharArray();
				for (int j = 1; j <= w; j++) {
					g[i][j] = a[j - 1];
					if (g[i][j] == 'o') {
						v.add(poj.new P(i, j, 0));
					}
					if (g[i][j] == '*') {
						v.add(poj.new P(i, j, num++));
					}
				}
			}
			n = v.size();
			for (int i = 0; i < n; i++) {// ���������������֮��ľ���
				for (int j = i + 1; j < n; j++) {
					int x = v.get(i).id;
					int y = v.get(j).id;
					mat[x][y] = mat[y][x] = bfs(v.get(i).x, v.get(i).y,
							v.get(j).x, v.get(j).y);
				}
			}
			
			int ans = 1 << 29;
			System.out.println((1<<n)-1);
			dp[(1 << n) - 1][0] = 0;
			for (int S = (1 << n) - 2; S >= 0; S--) {
				for (int v1 = 0; v1 < n; v1++) {
					for (int u = 0; u < n; u++) {
						if ((S >> u & 1) == 0) {
							dp[S][v1] = Math.min(dp[S][v1], dp[S | 1 << u][u]
									+ mat[v1][u]);
						}
					}
				}
			}
			System.out.println(dp[0][0]);

		}
	}

	private static int bfs(int x1, int y1, int x2, int y2) {
		// TODO Auto-generated method stub
		PriorityQueue<A> q = new PriorityQueue<A>();
		A cur;
		for (int i = 0; i < 25; i++)
			Arrays.fill(mark[i], false);
		mark[x1][y1] = true;
		q.offer(poj.new A(x1, y1, 0, 0));
		while (!q.isEmpty()) {
			cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int dx = dir[i][0] + cur.x;
				int dy = dir[i][1] + cur.y;
				if (dx == x2 && dy == y2) {
					return cur.step + 1;
				}
				if (!mark[dx][dy] && dx >= 1 && dx <= h && dy >= 1 && dy <= w
						&& g[dx][dy] != 'x') {
					q.offer(poj.new A(dx, dy, cur.step + 1, cur.step + 1
							+ dis(dx, dy, x2, y2)));
					mark[dx][dy] = true;
				}
			}
		}
		return -1;
	}

	private static int dis(int x1, int y1, int x2, int y2) {
		// TODO Auto-generated method stub
		return (int) Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}

}


//#include <iostream>
//#include <queue>
//#include <cstring>
//#include <algorithm>
//#include <stdio.h>
//		using namespace std;
//		char mp[50][50];
//		int dis[50][50];
//		int vis[50][50];
//		int tag[50][50];
//		const int inf =99999999;
//		struct node
//		{
//		int x,y,step;
//		}point[500];
//		int w,h,cnt,ans;
//		void bfs(node fir,int pt)
//		{
//		queue <node > s;
//		fir.step=0;
//		while(!s.empty())
//		s.pop();
//		vis[fir.x][fir.y]=1;
//		s.push(fir);
//		while(!s.empty())
//		{
//		node t=s.front();
//		s.pop();
//		if(mp[t.x][t.y]=='*'||mp[t.x][t.y]=='o')
//		dis[ pt ] [ tag[t.x][t.y] ]=t.step;
//		int next[4][2]={0,1,0,-1,1,0,-1,0};
//		for(int i=0;i<4;i++)
//		{
//		node temp=t;
//		temp.x+=next[i][0];
//		temp.y+=next[i][1];
//		if(temp.x<1||temp.y<1||temp.x>h||temp.y>w||vis[temp.x][temp.y]==1||mp[temp.x][temp.y]=='x')
//		{
//		continue;
//		}
//		temp.step+=1;
//		s.push(temp);
//		vis[temp.x][temp.y]=1;
//		}
//
//		}
//		}
//		int vist[50];
//		void dfs(int x,int step,int s)
//		{
//		if(step==cnt)
//		{
//		ans=min(s,ans);
//		return ;
//		}
//		if(s>ans)
//		return ;
//		for(int i=1;i<=cnt;i++)
//		{
//		if(vist[i])
//		continue;
//		vist[i]=1;
//		dfs(i,step+1,s+dis[x][i]);
//		vist[i]=0;
//		}
//		}
//
//		int main()
//		{
//		while(~scanf("%d%d",&w,&h) )
//		{
//		if(w==0&&h==0)
//		break;
//		cnt=0;
//		getchar();
//		memset(point,0,sizeof(point));
//		memset(tag,0,sizeof(tag));
//		memset(dis,0,sizeof(dis));
//		for(int i=1;i<=h;i++)
//		{
//		for(int j=1;j<=w;j++)
//		{
//		scanf("%c",&mp[i][j]);
//		if(mp[i][j]=='*')
//		{
//		point[++cnt].x=i;
//		point[cnt].y=j;
//		tag[i][j]=cnt;
//		}
//		else if(mp[i][j]=='o')
//		{
//		tag[i][j]=0;
//		point[0].x=i;
//		point[0].y=j;
//		}
//		}
//		getchar();
//		}
//        /*for(int i=1;i<=h;i++)
//        {
//            for(int j=1;j<=w;j++)
//                cout<<mp[i][j];
//            cout<<endl;
//        }
//        cout<<"xxxx"<<endl;*/
//		for(int i=0;i<=cnt;i++)
//		{
//		for(int j=0;j<=cnt;j++)
//		{
//		if(i!=j)
//		dis[i][j]=inf;
//		else
//		dis[i][j]=0;
//		}
//		}
//		for(int i=0;i<=cnt;i++)
//		{
//		memset(vis,0,sizeof(vis));
//		bfs( point[i],i );
//		}
//      /*  for(int i=0;i<=cnt;i++)
//        {
//            for(int j=0;j<=cnt;j++)
//                cout<<dis[i][j]<<" ";
//            cout<<endl;
//        }*/
//		bool flag=1;
//		for(int i=0;i<=cnt && flag;i++)
//		for(int j=0;j<=cnt && flag;j++)
//		if(dis[i][j]==inf)
//		flag=0;
//		if(!flag)
//		{
//		printf("-1\n");
//		continue;
//		}
//		memset(vist,0,sizeof(vist));
//		vist[0]=1;
//		ans=inf;
//		dfs(0,0,0);
//		printf("%d\n",ans);
//
//		}
//		}