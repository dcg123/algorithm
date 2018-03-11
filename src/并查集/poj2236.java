package 并查集;

import java.util.Scanner;

/**
 * Created by user on 2017/8/12.
 */
public class poj2236 {
    /**
     * 给你N台电脑，从1-N。一个数字，表示两台计算机的最大通信距离，
     * 超过这个距离就无法进行通信。然后分别告诉这些电脑的坐标，接下来有两种操作，
     * 第一种O表示这点电脑修好，第二种S，表示测试这两台电脑能不能进行正常的通信
     */
    static int MAX_N=1001+5;
    static boolean vis[]=new boolean[MAX_N];
    static int pre[]=new int[MAX_N];
    class Node{
        int x,y;
    }
    static poj2236 poj=new poj2236();
    static int n,d;
    static Node node[];
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        d=scanner.nextInt();
        node=new Node[n+1];
        for(int i=1;i<=n;i++){//初始化关系数组
            pre[i]=i;
            vis[i]=false;
        }
        for(int i=1;i<=n;i++){
            node[i]=poj.new Node();
            node[i].x=scanner.nextInt();
            node[i].y=scanner.nextInt();
        }
        scanner.nextLine();
        do {
            String str=scanner.nextLine();
            if(str.equals("")){
                break;
            }
            if(str.charAt(0)=='O'){

                int r=str.charAt(2)-'0';
                vis[r]=true;
                for(int i=1;i<=n;i++){
                    if(i!=r&&vis[i]&&dis(r,i)){
                        int a=find(r);
                        int b=find(i);
                        if(a!=b)
                        pre[a]=b;
                    }
                }
            }
            if(str.charAt(0)=='S'){
                int a=str.charAt(2)-'0';
                int b=str.charAt(4)-'0';
                int a1=find(a);
                int a2=find(b);
                System.out.println(a1+" "+a2);
                if(a1==a2){
                    System.out.println("SUCCESS");
                }else{
                    System.out.println("FAIL");
                }
            }
        }while (true);
    }

    private static int find(int i) {
        if (i!=pre[i]) pre[i]=find(pre[i]);
        return pre[i];
    }

    private static boolean dis(int a, int b) {
        int q=Math.abs(node[a].x-node[b].x);
        int w=Math.abs(node[a].y-node[b].y);

        if (q*q+w*w<=d*d) return true;
        else return false;
    }
}
