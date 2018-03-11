package 并查集;

import java.util.Scanner;

/**
 * Created by user on 2017/8/12.
 */
public class poj1703 {
    /**
     * 题目大意：在这个城市里有两个黑帮团伙，现在给出N个人，问任意两个人他们是否在同一个团伙
     输入D x y代表x于y不在一个团伙里
     输入A x y要输出x与y是否在同一团伙或者不确定他们在同一个团伙里
     */
    static int father[]=new int[100000+10];   //表示x的根结点
    static int rank[]=new int[100000+10];
    static int n,m;
    public static void main(String ages[]){
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while((t--)>0){
            n=scanner.nextInt();
            m=scanner.nextInt();
            scanner.nextLine();
            Make_set();
            for(int i=0;i<m;i++){
                String str=scanner.nextLine();
                if(str.charAt(0)=='A'){
                    if(Find_Set(str.charAt(2)-'0')==Find_Set(str.charAt(4)-'0')){
                        if(rank[str.charAt(2)-'0']+rank[str.charAt(4)-'0']==0){
                            System.out.println("In the same gang.");
                        }else{
                            System.out.println("In different gangs.");
                        }
                    }else{
                        System.out.println("Not sure yet.");
                    }
                }else{
                    Union_Set(str.charAt(2)-'0',str.charAt(4)-'0');
                }
            }
        }
    }

    private static void Make_set() {
        for(int i=1;i<=n;i++){
            father[i]=i;
            rank[i]=1;
        }
    }

    private static void Union_Set(int x, int y) {
        int fa=Find_Set(x),fb=Find_Set(y);
        if(fa==fb){
            return;
        }
        father[fa]=fb;
        rank[fa] = (rank[x]+rank[y])%2 ;
    }

    private static int Find_Set(int a) {
        if(a==father[a]){
            return a;
        }else{
            int temp=father[a];
            father[a]=Find_Set(father[a]);
            rank[a] = (rank[temp]+rank[a]+1)%2 ;
        }
        return father[a];
    }
}
