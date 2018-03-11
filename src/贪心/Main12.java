package 贪心;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by user on 2017/10/10.
 */
public class Main12 {
    static int n,w,h;
    class Node{
        double left,right;
    }
    class cmp implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o1.left<o2.left?-1:1;
        }
    }
    static Main12 main12=new Main12();
    static Node node[]=new Node[1005];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while (t-->0){
            n=scanner.nextInt();
            w=scanner.nextInt();
            h=scanner.nextInt();
            h/=2;
            double temp, r;
            int i, j=0;
            for ( i=0;i<n;i++){
                temp=scanner.nextDouble();
                r=scanner.nextDouble();
                if (r<=h){
                    continue;
                }
                else {
                    double temp1=Math.sqrt(r*r-h*h);
                    node[j]=main12.new Node();
                    node[j].left=temp-temp1;
                    node[j++].right=temp+temp1;
                }
            }
            Arrays.sort(node,0,j,main12.new cmp());
            if (node[0].left>0){
                System.out.println("0");
                continue;
            }
            double end=0;
            i =0;
            int cou=0;
            while (end<=w&&i<j&&cou<=n){
                temp=end;
                while (node[i].left<=end&&i<j){
                    if (node[i].right>temp)
                        temp=node[j].right;
                    i++;
                }
                end=temp;
                ++cou;
            }
            if (end<w){
                System.out.println(0);
            }else {
                System.out.println(cou);
            }
        }
    }
}