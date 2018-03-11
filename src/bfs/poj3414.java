package bfs;

import java.util.Scanner;

public class poj3414 {

	/**
	 * @param args
	 *            给你两个容器 A B 问是否能够经过有限的步骤倒水,
	 *            得到容量为 C 的水 输出最小的步数,同时输出每一步的操作。
	 *            如果不能达到目标状态,则输出 impossible
	 *            题目大意： 有二个水壶，对水壶有三种操作，1)FILL(i)，将i水壶的水填满，2)DROP(i)，将水壶i中的水全部倒掉，3)POUR(i,j)将水壶i中的水倒到水壶j中，若水壶 j 满了，则 i 剩下的就不倒了，问进行多少步操作，并且怎么操作，输出操作的步骤，两个水壶中的水可以达到C这个水量。如果不可能则输出impossible。初始时两个水壶是空的，没有水。
	 */
	/**
	 * #include<stdio.h>
	 #include<string.h>

	 const int maxn = 110;
	 int vis[maxn][maxn]; //标记状态是否入队过
	 int a,b,c; //容器大小
	 int step; //最终的步数
	 int flag; //纪录是否能够成功

	 状态纪录
	struct Status{
		int k1,k2; //当前水的状态
		int op; //当前操作
		int step; //纪录步数
		int pre; //纪录前一步的下标
	}q[maxn*maxn];
	int id[maxn*maxn]; //纪录最终操作在队列中的编号
	int lastIndex; //最后一个的编号

	void bfs()
	{
		Status now, next;

		int head, tail;
		head = tail = 0;

		q[tail].k1 = 0; q[tail].k2 = 0;
		q[tail].op = 0; q[tail].step = 0; q[tail].pre = 0;

		tail++;

		memset(vis,0,sizeof(vis));
		vis[0][0] = 1; //标记初始状态已入队

		while(head < tail) //当队列非空
		{
			now = q[head]; //取出队首
			head++; //弹出队首

			if(now.k1 == c || now.k2 == c) //应该不会存在这样的情况, c=0
			{
				flag = 1;
				step = now.step;
				lastIndex = head-1; //纪录最后一步的编号
			}

			for(int i = 1; i <= 6; i++) //分别遍历 6 种情况
			{
				if(i == 1) //fill(1)
				{
					next.k1 = a;
					next.k2 = now.k2;
				}
				else if(i == 2) //fill(2)
				{
					next.k1 = now.k1;
					next.k2 = b;
				}
				else if(i == 3) //drop(1)
				{
					next.k1 = 0;
					next.k2 = now.k2;
				}
				else if(i == 4) // drop(2);
				{
					next.k1 = now.k1;
					next.k2 = 0;
				}
				else if(i == 5) //pour(1,2)
				{
					if(now.k1+now.k2 <= b) //如果不能够装满 b
					{
						next.k1 = 0;
						next.k2 = now.k1+now.k2;
					}
					else //如果能够装满 b
					{
						next.k1 = now.k1+now.k2-b;
						next.k2 = b;
					}
				}
				else if(i == 6) // pour(2,1)
				{
					if(now.k1+now.k2 <= a) //如果不能够装满 a
					{
						next.k1 = now.k1+now.k2;
						next.k2 = 0;
					}
					else //如果能够装满 b
					{
						next.k1 = a;
						next.k2 = now.k1+now.k2-a;
					}
				}

				next.op = i; //纪录操作
				if(!vis[next.k1][next.k2]) //如果当前状态没有入队过
				{
					vis[next.k1][next.k2] = 1; //标记当前状态入队
					next.step = now.step+1; //步数 +1
					next.pre = head-1; //纪录前一步的编号

					//q.push(next);
					//q[tail] = next; 加入队尾
					q[tail].k1 = next.k1; q[tail].k2 = next.k2;
					q[tail].op = next.op; q[tail].step = next.step; q[tail].pre = next.pre;
					tail++; //队尾延长

					if(next.k1 == c || next.k2 == c) //如果达到目标状态
					{
						flag = 1; //标记成功
						step = next.step; //纪录总步骤数
						lastIndex = tail-1; //纪录最后一步在模拟数组中的编号
						return;
					}
				}
			}
		}


	}

	int main()
	{
		while(scanf("%d%d%d", &a,&b,&c) != EOF)
		{
			flag = 0; //初始化不能成功
			step = 0;

			bfs();
			if(flag)
			{
				printf("%d\n", step);

				id[step] = lastIndex; //最后一步在模拟数组中的编号
				for(int i = step-1; i >= 1; i--)
				{
					id[i] = q[id[i+1]].pre; //向前找前一步骤在模拟数组中的编号
				}

				for(int i = 1; i <= step; i++)
				{
					if(q[id[i]].op == 1)
						printf("FILL(1)\n");

					else if(q[id[i]].op == 2)
						printf("FILL(2)\n");

					else if(q[id[i]].op == 3)
						printf("DROP(1)\n");

					else if(q[id[i]].op == 4)
						printf("DROP(2)\n");

					else if(q[id[i]].op == 5)
						printf("POUR(1,2)\n");

					else if(q[id[i]].op == 6)
						printf("POUR(2,1)\n");
				}
			}
			else printf("impossible\n");
		}
		return 0;
	}
	 */
}
