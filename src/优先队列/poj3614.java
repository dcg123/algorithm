package 优先队列;

import java.util.Comparator;
import java.util.Scanner;
public class poj3614 {

	/**
	 * @param args
	 * 奶牛美容：有C头奶牛日光浴，每头奶牛分别需要minSPF_i和maxSPF_i单位强度之间的阳光。现有L种防晒霜，
	 * 分别能使阳光强度稳定为SPF_i，其瓶数为cover_i。求最多满足多少头奶牛
	 *
	 * 首先得确定一个贪心策略，在满足minSPF的条件下，
	 * 尽量把SPF小的防晒霜用在maxSPF小的奶牛身上，因为maxSPF大的奶牛有更大的选择空间。
	 * 用一个最小堆q维护maxSPF的最小值，可以高效解决问题。
	 */


//	ifndef ONLINE_JUDGE
//#pragma warning(disable : 4996)
//#endif
//#include <iostream>
//#include <algorithm>
//#include <queue>
//#include <functional>
//	using namespace std;
//
//	pair<int, int> cow[2500 + 16];
//	pair<int, int> bottle[2500 + 16];
//	priority_queue<int, vector<int>, greater<int> > q;	// 优先级队列，小元素优先出队
//
//	///////////////////////////SubMain//////////////////////////////////
//	int main(int argc, char *argv[])
//	{
//#ifndef ONLINE_JUDGE
//		freopen("in.txt", "r", stdin);
//		freopen("out.txt", "w", stdout);
//#endif
//		int C, L;
//		cin >> C >> L;
//		for (int i = 0; i < C; ++i)
//		{
//			cin >> cow[i].first >> cow[i].second;
//		}
//		for (int i = 0; i < L; ++i)
//		{
//			cin >> bottle[i].first >> bottle[i].second;
//		}
//		sort(cow, cow + C);
//		sort(bottle, bottle + L);
//		int cur = 0;	// 现在正等待涂防晒霜的奶牛的index
//		int result = 0;
//		for (int i = 0; i < L; ++i)
//		{
//			while (cur < C && cow[cur].first <= bottle[i].first)
//			{
//				q.push(cow[cur].second);
//				++cur;
//			}
//
//			while (!q.empty() && bottle[i].second)
//			{
//				int maxSPF = q.top(); q.pop();
//				// “奶牛上限”比这一瓶的上限大，说明这头奶牛可以被涂上防晒霜
//				if (maxSPF >= bottle[i].first)
//				{
//					++result;
//					--bottle[i].second;
//				}
//				// else 这头奶牛不能被涂上，因为bottle是按SPF排过序的，没有比这瓶更小的SPF了
//			}
//		}
//		cout << result << endl;
//#ifndef ONLINE_JUDGE
//		fclose(stdin);
//		fclose(stdout);
//		system("out.txt");
//#endif
//		return 0;
//	}

}
