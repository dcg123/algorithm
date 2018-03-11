package dfs;



        import java.util.Scanner;

public class ny20{

    /**
     * @param args
     * 在一个吝啬的国度里有N个城市，这N个城市间只有N-1条路把这个N个城市连接起来。
     * 现在，Tom在第S号城市，他有张该国地图，
     * 他想知道如果自己要去参观第T号城市，必须经过的前一个城市是几号城市（假设你不走重复的路）。
     */

    private static final int MAX=100000+5;
    static int e[][];
    static int vis[];
    static int dree[];
    static int n;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        int t,s;
        t=scan.nextInt();
        while(t>0){
            n=scan.nextInt();
            s=scan.nextInt();
            e=new int[n][n];
            vis=new int[n];
            dree=new int[n];
            for(int i=0;i<n-1;i++){
                int a=scan.nextInt();
                int b=scan.nextInt();
                e[a-1][b-1]=1;
                e[b-1][a-1]=1;
            }
            dfs(s);
            for(int i=0;i<n;i++){
                if(dree[i]==s){
                    System.out.print(-1+" ");
                }else{
                    System.out.print(dree[i]+1+" ");
                }
            }
            t--;
        }
    }
    private static void dfs(int s) {
        // TODO Auto-generated method stub
        vis[s]=1;
        for(int i=0;i<n;i++){
            if(vis[i]!=1&&e[s][i]==1){
                dree[i]=s;
                dfs(i);
            }
        }
    }

}
