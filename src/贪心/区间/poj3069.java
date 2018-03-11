package 贪心.区间;

/**
 * Created by user on 2017/10/17.
 */


        import java.util.Arrays;
        import java.util.Scanner;

public class poj3069 {

    /**
     * @param args
     * 大意：
    给出一维直线上n个点的相应坐标，和一个参数——距离R，给n个点中尽可能少的点做标记，使得n个点中，任意一个点，在R距离内都有被标记的点。

    思路：
    首先从最左边开始考虑，显然，从左边起，标记的第一个点，在最左边点的右侧。且选择距离R内 距离其最远的点。
    接着，把上一次标记的这个点  能影响的最右边的点  的下一个点，作为最左边的点，开始又一次标记。
     */
    static int a[]=new int [1000+2];
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        int r,n;
        while(scan.hasNext()){
            r=scan.nextInt();
            n=scan.nextInt();
            if(r==-1&&n==-1){
                break;
            }
            for(int i=0;i<n;i++){
                a[i]=scan.nextInt();
            }
            int sum=0;
            int count=0;
            Arrays.sort(a,0,n);
            int i=0;
            while(i<n){
                int s=a[i++];
                while(i<n&&a[i]<=s+r) i++;
                int p=a[i-1];
                while(i<n&&a[i]<=p+r){
                    i++;
                }
                count++;
            }
            System.out.println(count);
        }
    }

}
