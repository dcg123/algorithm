package 图论.次小生成树;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by user on 2017/10/14.
 */
public class Main {
    /**
     * 利用kruskal算法，先找出最小生成树，然后再枚举每一条在最小树中的边，删
     * 除，重新构造树，与最小的比较，注意删除该边后要判断是否还能构成树
     */
    class node{
        int x;
        int y;
        int val;
    }
    static int isv[]=new int[200005];
    class cmp implements Comparator<node> {

        @Override
        public int compare(node o1, node o2) {
            return o1.val<o2.val?-1:1;
        }
    }
    static Main main118=new Main();
    static node no[]=new node[200005];
    static int fa[]=new int[501];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int T;
        T=scanner.nextInt();
        int n,m;
        int t1,t2,t;
        boolean f;
        while (T-->0){
            n=scanner.nextInt();
            m=scanner.nextInt();
            scanner.nextLine();
            //memset(fa,0,sizeof(fa));
            for (int i=0;i<=500;i++){
                fa[i]=i;
            }
            Arrays.fill(isv,0);
            for (int i=0;i<m;i++){
                String str=scanner.nextLine();
                String a[]=str.split(" ");
                no[i]=main118.new node();
                no[i].x=Integer.valueOf(a[0]);
                no[i].y=Integer.valueOf(a[1]);
                no[i].val=Integer.valueOf(a[2]);
            }
            //求出最小生成树的值
            int sum=0;
            //kruskal算法，最小生成树
            for (int i=0;i<m;i++){
                t1=find(no[i].x);
                t2=find(no[i].y);
                if (t1!=t2){
                    sum+=no[i].val;
                    fa[t1]=t2;
                    isv[i]=1;
                }
            }
            int sum2;
            boolean ans=false;
            //遍历边 找出最小生成树中的边 枚举
            for (int i=0;i<m;i++){
                if (isv[i]==1){
                    isv[i]=2;//表示已经删除
                    sum2=0;
                    for (int j=0;j<=500;j++){
                        fa[j]=j;
                    }
                    for (int j=0;j<m;j++){
                        if (isv[j]<2){
                            t1=find(no[j].x);
                            t2=find(no[j].y);
                            if (t1!=t2){
                                sum2+=no[j].val;
                                fa[t1]=t2;
                            }
                        }
                    }
                    f=true;
                    t=find(1);
                    //判断是否构成树 ，重要
                    for (int j=2;j<=n;j++){
                        if (find(j)!=t) {
                            f=false;
                            break;
                        }
                    }
                    if (f){
                        if (sum==sum2) {
                            ans=true;
                            break;
                        }
                        //得出次小生成树
                    }
                    isv[i]=1;
                }
            }
            if (ans) System.out.println("Yes");
            else System.out.println("No");
        }
    }

    private static int find(int a) {
        if (fa[a]==a) return a;
        else return fa[a]=find(fa[a]);
    }
}
