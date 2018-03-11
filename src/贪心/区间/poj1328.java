package 贪心.区间;

/**
 * Created by user on 2017/10/17.
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class poj1328 {

    /**
     * 假设陆地的海岸线是一条无限延长的直线，海岛是一个个的点，现需要在海岸线上安装雷达，使整个雷达系统能够覆盖到所有的海岛。雷达所能覆盖的区域是以雷达为圆心半径为d的圆，我们用指标坐标系来描述，海岸线就是x轴，现在给出每个海岛的坐标与雷达的半径d，请编写一个程序计算出最少需要多少个雷达才能够将所有海岛全部覆盖？

     */
//    <pre name="code" class="cpp">#include<cstdio>
//#include<cstring>
//#include<algorithm>
//#include<iostream>
//#include<math.h>
//    using namespace std;
//    struct seg{
//        double a,b;
//    }x[1001];//每一条线段
//    int n;
//    double d;
//    bool cmp(seg a,seg b)
//    {
//        if(a.b!=b.b)return a.b<b.b;
//        return a.a>b.a;
//    }//按照每一条线段的右端点排序
//    int work(double a,double b,int i)
//    {
//        if(b>d||b<-d)return 1;//雷达不能覆盖
//        double dis=sqrt(d*d-b*b);
//        x[i].a=a-dis,x[i].b=a+dis;
//        return 0;
//    }
//    int main()
//    {
//        int num=0;
//        while(cin>>n>>d)
//        {
//            num++;
//            int i,cnt=0,f=0,f1;
//            double j,k;
//            if(!n&&!d)break;
//            memset(x,0,sizeof(x));
//            for(i=1;i<=n;i++)
//            {
//                cin>>j>>k;
//                f1=work(j,k,i);
//                if(f1)f=1;
//            }
//            if(d<0||f)//雷达半径为负数......也是不能到达的
//            {
//                cout<<"Case "<<num<<": "<<-1<<endl;
//                continue;
//            }
//            sort(x+1,x+n+1,cmp);
//            double end=-0x3f3f3f3f;//横坐标要很小....因为..你懂的
//            for(i=1;i<=n;i++)
//            {
//                if(end<x[i].a)
//                {
//                    end=x[i].b;
//                    cnt++;
//                }
//            }
//            cout<<"Case "<<num<<": "<<cnt<<endl;
//        }
//    }





        /**
         * @param args
         */
        static poj1328 poj=new poj1328();
        static Node[] node;
        static Region region[];
        static int n,d;
        class Node{
            int begin;
            int end;
        }
        class Region{
            double x,y;
        }
        class cmp implements Comparator<Region>{

            @Override
            public int compare(Region o1, Region o2) {
                // TODO Auto-generated method stub
                if(o1.x>o2.x){
                    return 1;
                }else if(o1.x<o2.x){
                    return -1;
                }else{
                    return 0;
                }
            }

        }
        public static void main(String[] args) {
            // TODO Auto-generated method stub
            Scanner scan=new Scanner(System.in);
            int t=1;
            while(scan.hasNext()){
                n=scan.nextInt();
                d=scan.nextInt();
                if(n==0&&d==0){
                    break;
                }
                node=new Node[n];
                region=new Region[n];
                for(int i=0;i<n;i++){
                    node[i]=poj.new Node();
                    node[i].begin=scan.nextInt();
                    node[i].end=scan.nextInt();
                }
                int min = calMin();
                System.out.println("Case "+t+": "+min);
                t++;
                scan.nextLine();
            }
        }
        private static int calMin() {
            // TODO Auto-generated method stub
            int t=0;
            for(int i=0;i<n;i++){//计算每个岛屿在横坐标的区域
                Node ss=node[i];
                if(ss.end<0||ss.end>d||d<0){
                    return -1;
                }
                double x=Math.sqrt(Math.pow(d, 2)-Math.pow(ss.end, 2));
                region[t]=poj.new Region();
                region[t].x=ss.begin-x;
                region[t].y=ss.begin+x;
                t++;
            }
            //排序
            Arrays.sort(region,0,t,poj.new cmp());
            int num = 0;
            double right = -1;
            for(int i=0;i<t;i++){
                Region s=region[i];
                if(i==0){
                    num++;
                    right=s.y;
                }
                else{
                    if(s.x<=right){
                        if(s.y<right){
                            right=s.y;
                        }

                    }else{
                        num++;
                        right=s.y;
                    }
                }
            }
            return num;
        }



}
