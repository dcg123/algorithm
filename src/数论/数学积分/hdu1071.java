package 数论.数学积分;

/**
 * Created by user on 2017/10/17.
 */
public class hdu1071 {
    /**
     * 题意：给出抛物线的顶点和它与一直线的两交点，求他们围成的面积；
     *
     * 设抛物线y=a(x-b)^2+c
     直线方程y=kx+d;
     带几个点吧方程写出来。。
     面积就是a(x-b)^2+c-kx-d的积分（p2-p3）;
     */
//    #include<bits/stdc++.h>
//    using namespace std;
//#define LL long long
//    //y=a(x-b)^2+c
////y=kx+d;
//    double a,b,c,k,d;
//    double jifen(double x){
//        //y=ax^2-(2ab+k)x+ab^2+c-d
//        return a*x*x*x/3-(2*a*b+k)*x*x/2+(a*b*b+c-d)*x;
//    }
//
//    int main(){
//        int t;
//        cin>>t;
//        while(t--){
//            double x1,y1,x2,y2,x3,y3;
//            cin>>x1>>y1;
//            cin>>x2>>y2;
//            cin>>x3>>y3;
//
//            c=y1;
//            b=x1;
//            a=(y2-c)/((x2-b)*(x2-b));
//            k=(y3-y2)/(x3-x2);
//            d=y2-k*x2;
//            cout<<setprecision(2)<<std::fixed<<jifen(x3)-jifen(x2)<<endl;
//        }
//        return 0;
//    }
}
