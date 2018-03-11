package 计算几何.三点顺序;

/**
 * Created by user on 2017/10/10.
 */
public class Main68 {

    /**
     * 现在给你不共线的三个点A,B,C的坐标，它们一定能组成一个三角形，
     * 现在让你判断A，B，C是顺时针给出的还是逆时针给出的？
     *
     *
     * 考察数学知识（百度了好久才找到这个数学知识点）：
     在平面上作向量AB、AC

     AB叉乘AC为正,则是逆时针,为负为顺时针.

     记向量AB为(dx1, dy1) = (x2-x1, y2-y1)向量AC为(dx2, dy2) = (x3-x1, y3-y1)

     叉积为
     |dx1 dy1|
     |dx2 dy2|

     即:
     dx1 * dy2 - dy1 * dx2

     #include <stdio.h>

     int main(){
     int x1, y1, x2, y2, x3, y3, x4, y4, x5, y5, t;
     while(scanf("%d%d%d%d%d%d", &x1, &y1, &x2, &y2, &x3, &y3),
     x1 || y1 || x2 || y2 || x3 || y3){
     x4 = x2 - x1;
     y4 = y2 - y1;
     x5 = x3 - x1;
     y5 = y3 - y1;
     t = x4*y5 - y4*x5;
     if(t > 0)printf("0\n");
     else printf("1\n");
     }
     return 0;
     }
     */
}
