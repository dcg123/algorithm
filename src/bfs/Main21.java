package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by user on 2017/10/3.
 */
public class Main21 {
    class Node{
        int v[]=new int[3];
        int steps;
    }
    static Main21 main21=new Main21();
    static Node init=main21.new Node();
    static Node targ=main21.new Node();
    static Boolean vis[][][]=new Boolean[100][100][100];

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while (t-->0){
            init.v[0]=scanner.nextInt();
            init.v[1]=scanner.nextInt();
            init.v[2]=scanner.nextInt();
            targ.v[0]=scanner.nextInt();
            targ.v[1]=scanner.nextInt();
            targ.v[2]=scanner.nextInt();
            System.out.println(bfs());
        }
    }

    private static int bfs() {
        Node cup=main21.new Node();
        cup.v[0]=init.v[0];
        cup.v[1]=0;
        cup.v[2]=0;
        cup.steps=0;
        Queue<Node> queue=new LinkedList<>();
        for (int i=0;i<100;i++){
            for (int j=0;j<100;j++){
                for (int k=0;k<100;k++){
                    vis[i][j][k]=false;
                }
            }
        }
        vis[init.v[0]][0][0]=true;
        queue.offer(cup);
        while (queue.size()!=0){
            Node temp=queue.poll();
            Node ss=temp;
            if(temp.v[0] == targ.v[0] && temp.v[1] == targ.v[1]
                    && temp.v[2] == targ.v[2]) return temp.steps;
            for (int i=0;i<3;i++){
                for (int j=0;j<3;j++){
                    temp = ss;
                    if (i!=j&&del(temp,i,j)){
                        ++temp.steps;
                        queue.offer(temp);
                    }
                }
            }
        }
        return 0;
    }

    private static boolean del(Node cup, int start, int end){
        if(cup.v[start] !=0&& cup.v[end] != init.v[end]){ //能倒水
            int sum = cup.v[start] + cup.v[end];
            if(sum >= init.v[end]) cup.v[end] = init.v[end];
            else cup.v[end] = sum;
            cup.v[start] = sum - cup.v[end];
            if(!vis[cup.v[0]][cup.v[1]][cup.v[2]])
                return vis[cup.v[0]][cup.v[1]][cup.v[2]] = true;
        }
        return false;
    }
}
