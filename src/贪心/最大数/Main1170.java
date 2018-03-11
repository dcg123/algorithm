package 贪心.最大数;

import java.util.Scanner;

/**
 * Created by user on 2017/10/10.
 */
public class Main1170 {
    static int n;
    static int a[]=new int[10000+10];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            n=scanner.nextInt();
            if (n==0){
                break;
            }
            scanner.nextLine();
            String str=scanner.nextLine();
            String b[]=str.split(" ");
            for (int i=0;i<b.length;i++){
                a[i]=Integer.valueOf(b[i]);
            }
            if (a[0]==1&&n>1){
                a[0]=0;
                a[1]++;
            }
            for (int i=1;i<n-1;i++){
                if (a[i]==1){
                    a[i]=0;
                    add(i-1,i+1);
                }
            }
            if (n>1&&a[n-1]==1){
                a[n-1]=0;
                int i=n-2;
                for (;a[i]==0;i--);
                a[i]++;
            }
            int ans = 1;
            for (int i = 0; i < n; i++) {
                if (a[i] != 0) {
                    ans = ans * a[i] % 10086;
                }
            }
            System.out.println(ans);
        }
    }

    private static void add(int i, int j) {
        if (a[i] == 2) {// 2 1 1因为*3比*2大
            a[i]++;
            return;
        }
        if (a[i] == 0) {// 前一个是0，而且不会出现连续的0，可模拟看看
            i--;
        }
        if (a[i] <= a[j]) {// 例:4 1 4 1
            a[i]++;
        } else {
            a[j]++;
        }
    }
}
