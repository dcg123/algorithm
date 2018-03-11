package 数论.素数;



        import java.util.Scanner;

public class 判断是否是素数 {

    /**
     * @param args
     */
    static int MAXN=1000010;
    static boolean notprime[]=new boolean[MAXN];
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        notprime[0] = notprime[1] = true;
        for(int i=2;i<MAXN;i++){
            if(!notprime[i]){
                if(i>MAXN/i){
                    break;
                }
            }
            //  直接从i * i开始就可以，小于i倍的已经筛选过了
            for(int j=i*i;j<MAXN;j+=i){
                notprime[j]=true;
            }
        }
        System.out.println(notprime[n]);

    }

}
