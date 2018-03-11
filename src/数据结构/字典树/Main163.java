package 数据结构.字典树;

import java.util.Scanner;

/**
 * Created by user on 2017/10/5.
 */
public class Main163 {
    static int maxn = 50010;
    static int father[]=new int[maxn], rank[]=new int[maxn];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n,k;
        int d,x,y;
        n=scanner.nextInt();
        k=scanner.nextInt();
        scanner.nextLine();
        init(n);
        int sum=0;
        for (int i=0;i<k;i++){
            String str=scanner.nextLine();
            String a[]=str.split(" ");
            d=Integer.valueOf(a[0]);
            x=Integer.valueOf(a[1]);
            y=Integer.valueOf(a[2]);
            if (x>n||y>n||(x==y&&d==2)){
                sum++;
            }else if (Union(x,y,d-1)){
                sum++;
            }
        }
        System.out.println(sum);
    }

    private static boolean Union(int x, int y, int type) {
        int fx=find(x);
        int fy=find(y);
        if (fx==fy){
            if ((rank[y] -rank[x] + 3) % 3 != type)
                return true;
            else
                return false;
        }
        father[fy] = fx;
        rank[fy] = (rank[x] - rank[y] + type + 3) % 3;
        return false;
    }

    private static int find(int x) {
        if (x != father[x]){
            int fx = find(father[x]);
            rank[x] = (rank[x] + rank[father[x]]) % 3;
            father[x] = fx;
        }
        return father[x];
    }

    static void init(int n){
        for (int i = 0; i < n; i++){
            father[i] = i;
            rank[i] = 0;
        }
    }
}
