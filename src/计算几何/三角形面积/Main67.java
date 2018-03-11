package 计算几何.三角形面积;

/**
 * Created by user on 2017/10/10.
 */
public class Main67 {
    //直接用海伦公式
    /**
     * #include <stdio.h>
     #include <math.h>

     int main()
     {
     double res;
     int x1,x2,x3,y1,y2,y3;
     while(scanf("%d%d%d%d%d%d",&x1,&y1,&x2,&y2,&x3,&y3)&&(x1||x2||x3||y1||y2||y3))
     {
     double a,b,c,p;
     a=sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
     b=sqrt((x2-x3)*(x2-x3)+(y2-y3)*(y2-y3));
     c=sqrt((x1-x3)*(x1-x3)+(y1-y3)*(y1-y3));
     p=(a+b+c)/2;
     res=sqrt(p*(p-a)*(p-b)*(p-c));
     printf("%.1f\n",res);
     }
     return 0;
     }
     */
}
