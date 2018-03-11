package 图论.欧拉图;

import java.util.Scanner;
import java.util.Stack;

public class usaco3 {

	/**
	 * @param
	 * 很久以前，亚瑟王和他的骑士习惯每年元旦去庆祝他们的友谊。为了纪念上述事件，
	 *        我们把这些故事看作是一个棋盘游戏。有一个国王和若干个骑士被放置在一个由许多方格
	 *        组成的棋盘上，没有两个骑士在同一个方格内。
	这个例子是标准的 8*8 棋盘
	国王可以移动到任何一个相邻的方格，从下图中黑子位置到下图中白子位置前提是他 不掉出棋盘之外。
	一个骑士可以从下图中黑子位置移动到下图中白子位置(走“日”字形） 但前提是他 不掉出棋盘之外。
	在游戏中，玩家可在每个方格上放不止一个棋子，假定方格足够大，
	任何棋子都不会 阻碍到其他棋子正常行动。
	玩家的任务就是把所有的棋子移动到同一个方格里——用最小的步数。为了完成这个 任务，
	他必须按照上面所说的规则去移动棋子。另外，玩家可以选择一个骑士跟国王从他 们两个
	相遇的那个点开始一起行动，这时他们按照骑士的行动规则行动，其他的单独骑士
	则自己一直走到集中点。骑士和国王一起走的时候，只算一个人走的步数。
	请计算他们集中在一起的最小步数，而且玩家必须自己找出这个集中点。当然，这些
	棋子可以在棋盘的任何地方集合。
	 */
	static int MAXN = 501; // ����
	static int MAXM = 1030; // ����
	static int min_n, max_n, cnt;
	static int map[][] = new int[MAXN][MAXN], path[] = new int[MAXN],
			degree[] = new int[MAXN];
	static Stack<Integer> s;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int m, u, v;
		while (scan.hasNext()) {
			s=new Stack<>();
			m = scan.nextInt();
			min_n = 520;
			max_n = 0;
			for (int i = 0; i < m; i++) {
				u = scan.nextInt();
				v = scan.nextInt();
				map[u][v]++;
				map[v][u]++;
				degree[u]++;
				degree[v]++;
				min_n = Math.min(min_n, u);
				min_n = Math.min(min_n, v);
				max_n = Math.max(max_n, u);
				max_n = Math.max(max_n, v);
			}
			u = 520;
			for (int i = min_n; i <= max_n; i++) {
				if (degree[i] % 2 == 1)
					u =Math. min(u, i);
			}
			cnt=0;
	        if(u==520) fleury(min_n); //���ж�Ϊż��
	        else fleury(u);           //���л�����
	        for(int i=cnt-1;i>=0;i--)
	        {
	            System.out.printf("%d\n",path[i]);
	        }
		}
	}

	private static void fleury(int u) {
		// TODO Auto-generated method stub
		if(!s.isEmpty()){
			s.clear();
		}
		int v;
	    boolean flag;
	    s.push(u);
	    while(!s.empty())
	    {
	        flag=false;
	        u=s.pop();
	        for(v=min_n;v<=max_n;v++)
	        {
	            if(map[u][v]>=1)
	            {
	                flag=true;
	                break;
	            }
	        }
	        if(flag)
	        {
	            DFS(u);
	        }
	        else
	        {
	            path[cnt++]=u;
	        }
	    }
	}

	private static void DFS(int u) {
		// TODO Auto-generated method stub
		 int v;
		    s.push(u);
		    for(v=min_n;v<=max_n;v++)
		    {
		        if(map[u][v]>=1)
		        {
		            map[u][v]--;
		            map[v][u]--;
		            DFS(v);
		            break;
		        }
		    }
	}

}
