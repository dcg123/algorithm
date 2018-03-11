package 连通图.求桥;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by user on 2017/10/14.
 */
public class UVA796 {
    static int MAX=10005;
    static Vector<Integer> vector[]=new Vector[MAX];
    static int low[]=new int[MAX];
    static int dfn[]=new int[MAX];
    static boolean isStack[]=new boolean[MAX];
    class Node{
        int x,y;
    }
    static int n;
    static int count,countDfn;
    static Node node[]=new Node[MAX];
    static UVA796 uva796=new UVA796();
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            n=scanner.nextInt();
            init();
            for (int i=0;i<n;i++){
                String str=scanner.nextLine();
                String a[]=str.split(" ");
                if (Integer.valueOf(0)==0){
                    continue;
                }else {
                    int x=Integer.valueOf(a[0]);
                    int k=4;
                    int ans=Integer.valueOf(a[2]);
                    for (int j=0;j<ans;j++){
                        int y=Integer.valueOf(a[j+k]);
                    }
                }
            }
        }
    }

    private static void init() {
        for (int i=0;i<=n;i++){
            vector[i]=new Vector<Integer>();
        }
        Arrays.fill(dfn,0);
        Arrays.fill(low,0);
        Arrays.fill(isStack,false);
        count=0;
        countDfn=0;
    }
}
