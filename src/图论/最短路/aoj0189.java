package 图论.最短路;

import java.util.Scanner;

/**
 * Created by user on 2017/8/12.
 */
public class aoj0189 {
    /**
     * 求某一办公室到其他办公室的最短距离。
     多组输入，n表示n条关系，下面n次每次输入 x y d表示x到y的距离是d。
     需要注意的是n没有给定，需要根据输入来求。
     输出办公室的编号和距离。
     */
    static int N,n;
    static int a[][]=new int[10][10];
    public static void main(String agrs[]){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            N=scanner.nextInt();
            if(N==0){
                break;
            }

            init();
            for(int i=1;i<=N;i++){
                int from=scanner.nextInt(),to=scanner.nextInt(),c=scanner.nextInt();
                a[from][to]=c;
                a[to][from]=c;
                n = Math.max(Math.max(n, from+1), to+1);
            }
            floyd();
            int sum=Integer.MAX_VALUE;
            int min= Integer.MAX_VALUE;
            int count=0;
            for(int i=0;i<n;i++){
                sum=0;
                for(int j=0;j<n;j++){
                    if(i==j){
                        continue;
                    }
                    sum+=a[i][j];
                }
                if(sum<min){
                    min=sum;
                    count=i;
                }
            }
            System.out.println(count+" "+min);
        }
    }

    private static void floyd() {
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    a[i][j]=Math.min(a[i][j],a[i][k]+a[k][j]);
                }
            }
        }
    }

    private static void init() {
        for(int i=0;i<=N;i++){
            for(int j=0;j<=N;j++){
                a[i][j]=10000000;
            }
        }
    }
}
