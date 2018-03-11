package 数论.素数;



        import java.util.Scanner;

public class 查找素数 {

    /**
     * @param args
     * 查找出小于等于MAXN的素数（生成连续素数表）
     */
    static int MAXN=100000;
    static int prime[]=new int[MAXN+1];
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        for(int i=2;i<=MAXN;i++){
            if (prime[i]==0)
            {
                prime[++prime[0]] = i;
            }
            for(int j=1;j<=prime[0]&&prime[j]<=MAXN;j++){
                prime[prime[j] * i] = 1;
                if (i % prime[j] == 0)
                {
                    break;
                }
            }
        }
    }

}
