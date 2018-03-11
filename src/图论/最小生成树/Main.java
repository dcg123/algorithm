package 图论.最小生成树;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by user on 2017/10/6.
 */
public class Main {
    class Node{
        int x,y,cost;
    }
    static int pre[]=new int[30];
    static Main main434=new Main();
    class cmp implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o1.cost<o2.cost?-1:1;
        }
    }
    static Node node[]=new Node[28*28];
    static int n;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            n=scanner.nextInt();
            if (n==0){
                break;
            }
            scanner.nextLine();
            for (int i=0;i<=n;i++){
                pre[i]=i;
            }
            int ans=0;
            for (int i=0;i<n-1;i++){
                String str=scanner.nextLine();
                String a[]=str.split(" ");
                int u=str.charAt(0)-'A'+1;
                int k=1;
                for (int j=1;j<=Integer.valueOf(a[1]);j++){
                    int v=a[k+j].charAt(0)-'A'+1;
                    k++;
                    int cost=Integer.valueOf(a[k+j]);
                    node[ans]=main434.new Node();
                    node[ans].x=u;
                    node[ans].y=v;
                    node[ans++].cost=cost;
                }
            }
            Arrays.sort(node,0,ans,main434.new cmp());
            int sum=0;
            for (int i=0;i<ans;i++){
                if (Union(node[i].x,node[i].y)){
                    sum+=node[i].cost;
                }
            }
            System.out.println(sum);
        }
    }

    private static boolean Union(int x, int y) {
        int a=find(x);
        int b=find(y);
        if (a==b){
            return false;
        }else {
            pre[a]=b;
            return true;
        }
    }

    private static int find(int x) {
        int r=x;
        while(r!=pre[r]){
            r=pre[r];
        }
        int i,j;
        i=x;
        while(i!=r){
            j=pre[i];
            pre[i]=r;
            i=j;
        }
        return r;
    }
}
