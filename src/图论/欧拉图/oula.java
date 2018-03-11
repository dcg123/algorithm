package 图论.欧拉图;

import java.util.Scanner;


public class oula {

    /**
     * @param args
     */
    private static final int max=100;
    private static final int map[][]=new int[max][max];
    private static final int dree[]=new int[max];
    private static final boolean vis[]=new boolean[max];
    static int n,m;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        n=scan.nextInt();
        m=scan.nextInt();
        for(int i=1;i<=m;i++){
            int a=scan.nextInt();
            int b=scan.nextInt();
            map[a][b]=1;
            map[b][a]=1;
        }
        dfs(1);
        boolean flag=true;
        for(int i=1;i<=n;i++){
            if(!vis[i]){
                flag=false;
                break;
            }
        }
        int count=0;
        for(int i=1;i<=n;i++){
            if(dree[i]%2==1){
                count++;
            }
        }
        if(flag){
            if(count!=0&&count!=2){
                System.out.println("No");
            }else{
                System.out.println("Yes");
            }
        }else{
            System.out.println("No");
        }

    }
    private static void dfs(int v0) {
        // TODO Auto-generated method stub
        vis[v0]=true;
        for(int i=1;i<=n;i++){
            if(map[v0][i]==1){
                dree[i]++;
                if(!vis[i])
                    dfs(i);
            }
        }
    }

}
