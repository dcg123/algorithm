package 贪心;



        import java.util.Scanner;

public class hdu1050 {

    /**
     * @param args
     * 题意很简单，就说有一些桌子需要从某些房间搬到另一些房间，
     * 但中间只有一条走廊，且走廊中任何一段只能同时进行一次搬运，如图中若需要把桌子从房间1搬到房间5
     * ，则不能同时进行房间2到4之间的搬运，因为搬运路线中有重叠部分。
     */
    static int e[]=new int[400+5];
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        int t,n;
        t=scan.nextInt();
        while(t>0){
            for(int i=0;i<400+5;i++){
                e[i]=0;
            }
            int max=0;
            n=scan.nextInt();
            for(int i=0;i<n;i++){
                int a=scan.nextInt();
                int b=scan.nextInt();
                if(a>b){
                    int temp=a;
                    a=b;
                    b=temp;
                }
                for(int j=a+1;j<=b+1;j++){
                    e[j]++;
                    if(e[j]>max){
                        max=e[j];
                    }
                }
            }
            System.out.println(max*10);
            t--;
        }


    }

}
