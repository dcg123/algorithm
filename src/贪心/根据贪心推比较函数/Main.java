package 贪心.根据贪心推比较函数;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by user on 2017/10/10.
 */
public class Main {
    static int n;
    class Node{
        int left,right;
    }
    class cmp implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o1.left*o1.right<o2.left*o2.right?-1:1;
        }
    }
    static Node node[]=new Node[1000+20];
    static Main main1218=new Main();
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        int zkcl=scanner.nextInt();
        int zkcr=scanner.nextInt();
        scanner.nextLine();
        for (int i=1;i<=n;i++){
            node[i]=main1218.new Node();
            String str=scanner.nextLine();
            String a[]=str.split(" ");
            node[i].left=Integer.valueOf(a[0]);
            node[i].right=Integer.valueOf(a[1]);
        }
        Arrays.sort(node,1,n+1,main1218.new cmp());
        BigInteger sum=BigInteger.ZERO;
        BigInteger num=new BigInteger(zkcl+"");
        for (int i=1;i<=n;i++){
            BigInteger ans=num.divide(new BigInteger(node[i].right+""));
            if (ans.compareTo(sum)==1){
                sum=ans;
            }
            num=num.multiply(new BigInteger(node[i].left+""));
        }
        System.out.println(sum);
    }
}
