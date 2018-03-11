package 数论.欧拉素数筛选;



        import java.util.Scanner;

public class 筛法欧拉函数 {

    /**
     * @param args
     */
    static int MAXN=10;
    static int phi[]=new int[MAXN+2];
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan =new Scanner(System.in);
        int n=scan.nextInt();
        shaixuan(n);
        for(int i=0;i<phi.length;i++){
            System.out.print(phi[i]);
        }
        System.out.println();
        System.out.println(phi[n]);
    }
    private static void shaixuan(int n) {
        // TODO Auto-generated method stub
        for(int i=1;i<=MAXN;i++){
            phi[i]=i;
        }
        for(int i=2;i<=MAXN;i+=2){
            phi[i]/=2;
        }
        for(int i=3;i<=MAXN;i+=2){
            if(phi[i]==i){
                for(int j=i;j<=MAXN;j+=i){
                    phi[j] = phi[j] / i * (i - 1);
                }
            }
        }
    }

}
