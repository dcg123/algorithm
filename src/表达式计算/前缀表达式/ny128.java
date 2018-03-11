package 表达式计算.前缀表达式;

/**
 * Created by user on 2017/10/17.
 */
public class ny128 {
    /**
     * 先说明一下什么是中缀式：

     如2+(3+4)*5这种我们最常见的式子就是中缀式。

     而把中缀式按运算顺序加上括号就是：(2+((3+4)*5))

     然后把运算符写到括号前面就是+(2 *( +(3 4) 5) )

     把括号去掉就是：+ 2 * + 3 4 5

     最后这个式子就是该表达式的前缀表示。

     给你一个前缀表达式，请你计算出该前缀式的值。

     比如：

     + 2 * + 3 4 5的值就是 37
     */
//    #include<iostream>
//#include<cstdio>
//#include<cstring>
//#include<sstream>
//    using namespace std;
//    stringstream ss;
//    double value;
//    char ch;
//    double val()
//    {
//        ss>>ch;
//        switch(ch)
//        {
//            case '+':return val()+val();
//            case '-':return val()-val();
//            case '*':return val()*val();
//            case '/':return val()/val();
//            default:ss.unget();ss>>value;return value;
//        }
//    }
//
//    int main()
//    {
//        string str;
//        while(getline(cin,str))
//        {
//            ss.clear();
//            ss<<str;
//            printf("%.1f\n",val());
//        }
//    }
}
