package 图论.拓扑排序;

import 数据结构.子典树.Main;

import java.net.Inet4Address;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by user on 2017/10/11.
 */
public class hdu1811 {
    //拓扑排序+并查集
    /**
     * 一道拓扑排序题， 但是因为多了个等号，所以增加了点难度，这题的关键也在于怎样处理这个等号。
     相等的那些数，其实都是同一个数， 所以需要先进行预处理， 把所有相同的那些数， 只用其中的一个来代表，所以，
     可以用并查集来把相同的数并成一颗树，之后都是用这个树根的数来代替这个树中所有的数。
     */
    //数据
    /**
     * 3 3
     0> 1
     1 <2
     0> 2
     4 4
     1 = 2
     1> 3
     2> 0
     0> 1
     3 3
     1> 0
     1> 2
     2 <1
     */
    static int Max=10000+10;
    static int pre[]=new int[Max];
    static String str[]=new String[Max];
    static int n,m;
    static int son[]=new int[Max];
    static Vector<Integer> vector[]=new Vector[Max];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            n=scanner.nextInt();
            m=scanner.nextInt();
            init();
            scanner.nextLine();
            int sum=n;
            for (int i=0;i<m;i++){
                String s=scanner.nextLine();
                String ss[]=s.split(" ");
                int a=Integer.valueOf(ss[0]);
                int b= Integer.valueOf(ss[2]);
                if (ss[1].equals("=")){
                    if (Union(a,b)){
                        --sum;
                    }
                }
            }
        }
    }

    private static boolean Union(int a, int b) {
        return false;
    }

    private static void init() {
        for (int i=0;i<=n;i++){
            pre[i]=i;
            vector[i]=new Vector<Integer>();
        }
        Arrays.fill(son,0);
    }
}
