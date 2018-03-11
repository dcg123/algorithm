package 图论.次小生成树;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by user on 2017/10/7.
 */
public class Main118 {
    class node{
        int x;
        int y;
        int val;
    }
    class cmp implements Comparator<node>{

        @Override
        public int compare(node o1, node o2) {
            return o1.val<o2.val?-1:1;
        }
    }
    static Main118 main118=new Main118();
    static node no[]=new node[200005];
    static int fa[]=new int[501];
    static int find(int a){
        if (fa[a]==a) return a;
        else return fa[a]=find(fa[a]);
    }

    static int isv[]=new int[200005];

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int T;
        T=scanner.nextInt();
        int n,m;
        int t1,t2,t;
        boolean f;
        while(T-->0){
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
            Arrays.sort(no,0,m,main118.new cmp());
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
            for (int i=0;i<m;i++){
                if (isv[i]==1){
                    isv[i]=2;//标记为2,表示删除
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
}
