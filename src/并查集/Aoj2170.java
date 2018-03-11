package 并查集;

import java.util.Scanner;

/**
 * Created by user on 2017/8/12.
 */
public class Aoj2170 {
    static  int n,q;
    static int father[]=new int[100010];
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            n=scanner.nextInt();
            q=scanner.nextInt();
            if(n+q==0){
                break;
            }

            Make_Set();
            for(int i=2;i<=n;i++){
                int s=scanner.nextInt();
                Union_Set(i,s);
            }
            scanner.nextLine();
            father[1]=1;
            long sum=0;
            for(int i=1;i<=q;i++){
                String str=scanner.nextLine();
                int s=str.charAt(2)-'0';
                if(str.charAt(0)=='Q'){
                    sum+=Find_Set(s);
                    System.out.println(Find_Set(s));
                }else if (str.charAt(0)=='M'){
                    father[s]=s;
                }
            }
            System.out.println(sum);
        }
    }

    private static long Find_Set(int x) {
        if(x==father[x]){
            return x;
        }
        return Find_Set(father[x]);
    }

    private static void Union_Set(int i, int s) {
        father[i]=s;
    }

    private static void Make_Set() {
        for (int i=1;i<=n;i++){
            father[i]=i;
        }
    }
}
