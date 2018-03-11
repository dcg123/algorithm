package 贪心;



        import java.util.Scanner;

public class hdu1009 {

    /**
     * @param args
     * 题意：一共有n个房子，每个房子里有老鼠喜欢吃的javabeans,
     * 但是每个房间里的javabeans的价格不一样。老鼠用m元，
     * 问m元最多可以卖多少javabeans，其中每个房间里的javabeans可以被分割。
    先求单价，然后排个序就行了。
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        int m,n;
        double sum;
        while(((m=scan.nextInt())!=-1)&&((n=scan.nextInt())!=-1)){
            sum=0;
            double j[]=new double[n];
            double f[]=new double[n];
            double p[]=new double[n];
            for(int i=0;i<n;i++){
                double a=scan.nextDouble();
                double b=scan.nextDouble();
                j[i]=a;
                f[i]=b;
                p[i]=a/b;
            }
            sort(j,f,p,n);

            for(int i=0;i<n;i++){
                if(m>=f[i]){
                    sum+=j[i];
                    m-=f[i];
                }else{
                    sum+=p[i]*m;
                    break;
                }
            }
            System.out.printf("%.3f",sum);
            System.out.println();
        }
    }

    private static void sort(double[] j, double[] f, double[] p, int n) {
        // TODO Auto-generated method stub
        double temp;
        double temp1;
        double temp2;
        for(int i=0;i<n-1;i++){
            for(int k=0;k<n-1-i;k++){
                if(p[k]<p[k+1]){
                    temp=p[k];
                    p[k]=p[k+1];
                    p[k+1]=temp;

                    temp1=f[k];
                    f[k]=f[k+1];
                    f[k+1]=temp1;

                    temp2=j[k];
                    j[k]=j[k+1];
                    j[k+1]=temp2;
                }
            }
        }
    }

}
