package 数据结构.并查集;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by user on 2017/10/5.
 */
public class Main129 {
    static int maxn = 10000 + 10;
    static int p[]=new int[maxn];
    static boolean vis[]=new boolean[maxn];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int cnt=1;
        while (scanner.hasNext()){
            boolean flag=true;
            int a=scanner.nextInt();
            int b=scanner.nextInt();
            if (a==0&&b==0){
                System.out.printf("Case %d is a tree.\n", cnt++);
                continue;
            }
            if (a==-1&&b==-1){
                break;
            }
            Arrays.fill(vis,false);
            for(int i = 0; i < maxn; ++i) p[i] = i;
            //判断输入的一条边是否是属于树
            if (flag&&p[b]==b&&find(a)!=b){
                p[b]=a;
            }
            else {
                flag=false;
            }
            vis[a] = vis[b] = true;
            while (scanner.hasNext()){
                a=scanner.nextInt();
                b=scanner.nextInt();
                if (a+b==0){
                    break;
                }
                if(flag && p[b] == b && find(a) != b) p[b] = a;
                else flag = false;
                vis[a] = vis[b] = true;
            }
            int s=0;
            //判读树的入度 判断每个节点是否是属于同一个跟节点
            for(int i = 0; i < maxn; ++i) if(vis[i] && i == p[i]) s++;
            System.out.printf("Case %d is %s tree.\n", cnt++, s == 1 && flag ? "a" : "not a");
        }
    }

    private static int find(int a) {
        int r=a;
        while (r!=p[r]){
            r=p[r];
        }
        return r;
    }
}
