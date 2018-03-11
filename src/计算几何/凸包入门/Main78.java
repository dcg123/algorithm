package 计算几何.凸包入门;

/**
 * Created by user on 2017/10/10.
 */
public class Main78 {
    public static void main(String[] args) {
        /**
         * 给出n个坐标 将N个点包围起来 面积最小
         *
         * 我们要做的第一步是将给定点按照x从小到大排序，若x相同则按照y从小到大排序。
         * 设排序好之后的点序列为p1，p2，p3，.... ，pn我们需要先将最左边的两个点A，B加入 到凸包集合中，接着对下一个点C进行判断，判断向量AC是否在向量AB的下方，如果是，那么将B点从凸包集合中删除，加入新的点，如图1，C符合条件，所以我们将B点删除。
         接着再对下一个点进行判断，
         将它与凸包集合里的后两个点进行比较，还是判断新形成的向量是否在下方，是的话则删除凸包集合的最后一个点，接着继续将新的点加入到集合（不管凸包集合的最后一个点是否被删除，都加入新的点），如图2，新的点不符合条件，所以我们凸包集合中的最后一个点不用删除，直接将新点加入到凸包集合中。
         那么我们循环n次之后就可以得到凸包的下半部分
         (图5)。于是我们再反着求一次，就可以得到凸包的上部分了，凸包就完成了。。


         这里计算两个向量Vector1和Vector2的位置关系我们可以利用两个向量的叉积，如果叉积大于0，则说明Vector1在Vector2的上方

         #include <cstdio>
         #include <algorithm>
         #include <iostream>

         using namespace std;

         struct point
         {
         int x;
         int y;
         }p[105], s[105];

         bool cmp(point a, point b)
         {
         return a.x < b.x || (a.x == b.x && a.y < b.y);
         }

         /*
         int dis(point a, point b)
         {
         return (a.x-b.x)*(a.x-b.x) + (a.y-b.y)*(a.y-b.y);
         }


        bool judge(point a, point b, point c)
        {
            int abx = b.x-a.x;
            int aby = b.y-a.y;
            int acx = c.x-a.x;
            int acy = c.y-a.y;
            if(abx*acy - aby*acx > 0)  // a、b、c成逆时针
                return true;
            return false;
        }

        int main()
        {
            int T, n, top, t;
            scanf("%d", &T);
            while(T--)
            {
                scanf("%d", &n);
                for(int i = 0; i < n; ++i)
                    scanf("%d%d", &p[i].x, &p[i].y);
                sort(p, p+n, cmp);

                top = 0;
                for(int i = 0; i < n; ++i)  //求下凸包
                {
                    while(top >= 2 && !judge(s[top-2], s[top-1], p[i]))
                        top--;
                    s[top++] = p[i];
                }
                t = top-1;
                for(int i = n-1; i >= 0; --i)  // 求上凸包
                {
                    while(top >= t+2 && !judge(s[top-2], s[top-1], p[i]))
                        top--;
                    s[top++] = p[i];
                }
                --top;  // 下凸包和上凸包的首尾点肯定是重叠的，所以删去

                sort(s, s+top, cmp);
                for(int i = 0; i < top; ++i)
                    printf("%d %d\n", s[i].x, s[i].y);
            }
            return 0;
        }

        **/
    }
}
