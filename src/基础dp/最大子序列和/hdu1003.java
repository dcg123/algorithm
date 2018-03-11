package 基础dp.最大子序列和;


        import java.util.Scanner;

public class hdu1003 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        int t;
        t=scan.nextInt();
        for(int j=1;j<=t;j++){
            int n=scan.nextInt();
            int sum=0,maxsum=-1001,first =0, last = 0, temp = 1;
            for(int i=0;i<n;i++){
                int a=scan.nextInt();
                sum+=a;
                if(sum>maxsum){
                    maxsum=sum;
                    first=temp;
                    last=i+1;
                }
                if(sum<0){
                    sum = 0;temp = i+2;
                }
            }
            System.out.println("Case "+j+":");
            System.out.println(maxsum+" "+first+" "+last);
            if (j!=t)
            {
                System.out.println();
            }
        }
    }

}
