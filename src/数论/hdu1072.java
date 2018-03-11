package 数论;



        import java.util.Scanner;

public class hdu1072 {

    /**
     * @param
     * 猜数字游戏是gameboy最喜欢的游戏之一。游戏的规则是这样的：计算机随机产生一个四位数，然后玩家猜这个四位数是什么。每猜一个数，计算机都会告诉玩家猜对几个数字，其中有几个数字在正确的位置上。
    比如计算机随机产生的数字为1122。如果玩家猜1234,因为1,2这两个数字同时存在于这两个数中，而且1在这两个数中的位置是相同的，所以计算机会告诉玩家猜对了2个数字，其中一个在正确的位置。如果玩家猜1111,那么计算机会告诉他猜对2个数字，有2个在正确的位置。
    现在给你一段gameboy与计算机的对话过程，你的任务是根据这段对话确定这个四位数是什么。
     */
    class Node{
        int a;
        int b;
        int c;
    }
    static Node node[]=new Node[105];
    static int n;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        hdu1072 hdu=new hdu1072();
        while((n=scan.nextInt())!=0){
            for(int i=1;i<=n;i++){
                Node node1=hdu.new Node();
                node1.a=scan.nextInt();
                node1.b=scan.nextInt();
                node1.c=scan.nextInt();
                node[i]=node1;
            }
            int count=0,result = 0;
            boolean flag=true;
            for(int i=1000;i<=9999;i++){
                for(int j=1;j<=n;j++){
                    flag=check(j,i);
                    if(!flag){
                        break;
                    }
                }
                if(flag){
                    count++;
                    result=i;
                }
            }
            if(count==1){
                System.out.println(result);
            }else{
                System.out.println("Not sure");
            }

        }

    }
    private static boolean check(int k, int number) {
        // TODO Auto-generated method stub
        int count=0;
        int num1[]=new int[5];
        int num2[]=new int[5];
        boolean mark[]=new boolean[5];
        num1[1]=node[k].a/1000;
        num1[2]=(node[k].a%1000)/100;
        num1[3]=(node[k].a%100)/10;
        num1[4]=(node[k].a%10);

        num2[1]=number/1000;
        num2[2]=(number%1000)/100;
        num2[3]=(number%100)/10;
        num2[4]=(number%10);

        for(int i=1;i<=4;i++){
            if(num1[i]==num2[i]){
                count++;
            }
        }
        if(count!=node[k].c){
            return false;
        }
        //找出相同数字个数
        count=0;
        for(int i=1;i<=4;i++){
            for(int j=1;j<=4;j++){
                if(num1[i]==num2[j]&&!mark[j]){
                    mark[j]=true;
                    count++;
                    break;
                }
            }
        }
        if(count!=node[k].b){
            return false;
        }
        return true;
    }

}
