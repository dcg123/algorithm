package 图论;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by user on 2017/10/6.
 */
public class Main {
    static int v,e;
    class Node{
        int x,y,cost;
    }
    class cmp implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o1.cost<o2.cost?-1:1;
        }
    }
    static int cos[]=new int[510];
    static int pre[]=new int[510];
    static Main main38=new Main();
    static Node node[]=new Node[500*500];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while (t-->0){
            v=scanner.nextInt();
            e=scanner.nextInt();
            for (int i=0;i<=v;i++){
                pre[i]=i;
            }
            for (int i=0;i<e;i++){
                int x=scanner.nextInt(),y=scanner.nextInt(),c=scanner.nextInt();
                node[i]=main38.new Node();
                node[i].x=x;
                node[i].y=y;
                node[i].cost=c;
            }
            Arrays.sort(node,0,e,main38.new cmp());
            for (int i=0;i<v;i++){
                cos[i]=scanner.nextInt();
            }
            int sum=0;
            for (int i=0;i<e;i++){
                if (Union(node[i].x,node[i].y)){
                    sum+=node[i].cost;
                }
            }
            Arrays.sort(cos,0,v);
            System.out.println(sum+cos[0]);
        }
    }
    static boolean Union(int a,int b){
        int x=find(a);
        int y=find(b);
        if (x==y){
            return false;
        }
        else {
            pre[x]=y;
            return true;
        }
    }

    private static int find(int a) {
        int r=a;
        while (r!=pre[r]){
            r=pre[r];
        }
        return r;
    }

}
