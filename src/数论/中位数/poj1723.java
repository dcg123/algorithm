package 数论.中位数;



        import java.util.Arrays;
        import java.util.Scanner;

public class poj1723 {

    /**
     * @param args
     * 有N个士兵，每个士兵站的位置用一个坐标（x，y）表示，
     * 现在要将N个士兵站在同一个水平线，即所有士兵的y坐标相同并且x坐标相邻，
     * 每个士兵每次可以移动一个位置。求出最少的移动步数。
     */

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int ans=0;
        int a[]=new int[n];
        int b[]=new int [n];
        for(int i=0;i<n;i++){
            a[i]=scan.nextInt();
            b[i]=scan.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        for(int i=0;i<n;i++){
            a[i]-=i;
        }
        Arrays.sort(a);
        for(int i=0;i<n;i++){
            ans+=Math.abs(a[i]-a[n/2])+Math.abs(b[i]-b[n/2]);
        }
        System.out.println(ans);
    }

}
