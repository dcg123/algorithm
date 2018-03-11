package 贪心;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by user on 2017/10/2.
 */
public class Main14 {
    static int n;
    class Node{
        int begin,end;
    }
    static Main14 main14=new Main14();
    static Node node[]=new Node[10000+10];
    class cmp implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            if (o1.end==o2.end){
                return o1.begin<o2.begin?1:-1;
            }else
                return o1.end<o2.end?-1:1;
        }
    }

    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while (t-->0){
            n=scanner.nextInt();
            for (int i=0;i<n;i++){
                node[i]=main14.new Node();
                node[i].begin=scanner.nextInt();
                node[i].end=scanner.nextInt();
            }
            Arrays.sort(node,0,n,main14.new cmp());
            int ans=1;
            int temp=node[0].end;
            for (int i=1;i<n;i++){
                if(node[i].begin>temp)
                {
                    temp=node[i].end;
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }
}
