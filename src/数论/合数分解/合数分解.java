package 数论.合数分解;



        import java.util.Scanner;

public class 合数分解 {

    /**
     * @param args
     * 将该合数分解成质因数，统计出出现不同的质因数的个数，分别出现过的质因数为哪几个
     * ，以及出现过的质因数的数量。
     */

    /**
     *  合数的分解需要先进行素数的筛选
     *  factor[i][0]存放分解的素数
     *  factor[i][1]存放对应素数出现的次数
     *  fatCnt存放合数分解出的素数个数(相同的素数只算一次)
     */

    private static int MAXN=10010;
    private static int prime[]=new int[MAXN+1];
    static long  factor[][]=new long[100][2];
    static int fatCnt;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        long n=scan.nextInt();
        /**
         * 在该函数中需要先使用到素数表，prime[]保存的是2,3,5,7等从小到大的素数，
         */

        getprime();
        int x= getFactors(n);
        System.out.println(x);
        for(int i =0;factor[i][0]!=0;i++){
            System.out.print(factor[i][0]+" ");
        }
        System.out.println();
        for(int i =0;factor[i][1]!=0;i++){
            System.out.print(factor[i][1]+" ");
        }
    }

    private static int getFactors(long n) {
        // TODO Auto-generated method stub
        fatCnt = 0;
        long tmp = n;
        for(int i = 1; prime[i]<=tmp/prime[i];i++)
        {
            factor[fatCnt][1] = 0;
            if(tmp % prime[i] == 0)
            {
                factor[fatCnt][0] = prime[i];
                while(tmp%prime[i]==0)
                {
                    factor[fatCnt][1]++;
                    tmp /= prime[i];
                }
                fatCnt++;
            }
        }
        if (tmp != 1)
        {
            factor[fatCnt][0] = tmp;
            factor[fatCnt++][1] = 1;
        }
        return fatCnt;
    }

    private static void getprime() {
        // TODO Auto-generated method stub
        for(int i = 2; i<=MAXN;i++)
        {
            if (prime[i]==0) prime[++prime[0]]=i;
            for(int j = 1;j<=prime[0] &&prime[j] <= MAXN/i;j++)
            {
                prime[prime[j]*i] = 1;
                if(i % prime[j] ==0) break;
            }
        }
    }

}
