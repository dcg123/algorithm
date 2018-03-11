package 表达式计算.表达式求值;



        import java.util.Scanner;
        import java.util.Stack;

public class ny305 {

    /**
     * @param args
     * Dr.Kong设计的机器人卡多掌握了加减法运算以后，最近又学会了一些简单的函数求值，比如，它知道函数min(20,23)的值是20 ，add(10,98) 的值是108等等。经过训练，Dr.Kong设计的机器人卡多甚至会计算一种嵌套的更复杂的表达式。
    假设表达式可以简单定义为:
    1. 一个正的十进制数 x 是一个表达式。
    2. 如果 x 和 y 是 表达式，则 函数min(x,y )也是表达式,其值为x,y 中的最小数。
    3. 如果 x 和 y 是 表达式，则 函数max(x,y )也是表达式,其值为x,y 中的最大数。
    4．如果 x 和 y 是 表达式，则 函数add(x,y )也是表达式,其值为x,y 之和。
    例如， 表达式 max(add(1,2),7) 的值为 7。
    请你编写程序，对于给定的一组表达式，帮助 Dr.Kong 算出正确答案，以便校对卡多计算的正误。

    max(1,999)
    add(min(1,1000),add(100,99))
    200
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Stack a=new Stack();
        Stack<Integer> b=new Stack<Integer>();
        Scanner scan=new Scanner(System.in);
        int t,op_num;
        String str;
        t=scan.nextInt();
        while(t>0){
            str=scan.next();
            char c[]=str.toCharArray();
            int state=0;
            for(int i=0;i<c.length;i++){
                if(c[i]>='a'&&c[i]<='z'){
                    state=1;
                    a.push(c[i+1]);
                    i+=2;
                }
                if(c[i]>='0'&&c[i]<='9'){
                    op_num=0;
                    for(int j=i;j<c.length;j++){
                        if(c[j]>='0'&&c[j]<='9'){
                            op_num=op_num*10+(c[j]-'0');
                        }else{
                            b.push(op_num);
                            i=j-1;
                            break;
                        }
                    }
                }
                if(c[i]==')'){
                    int x1=b.peek();
                    int x2=b.peek();
                    char c1=(char) a.peek();
                    a.peek();
                    int temp;
                    if(c1=='a'){
                        if(x1>x2){
                            temp=x1;
                        }else{
                            temp=x2;
                        }
                        b.push(temp);
                    }
                    if(c1=='i'){
                        if(x1>x2){
                            temp=x1;
                        }else{
                            temp=x2;
                        }
                        b.push(temp);
                    }
                    if(c1=='d'){
                        b.push(x1+x2);
                    }
                }

            }
            if(state!=0){
                System.out.println(b.peek());
                b.pop();
            }else{
                System.out.println(str);
            }
            t--;
        }
    }
}
