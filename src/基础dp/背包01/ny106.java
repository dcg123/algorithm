package 基础dp.背包01;



        import java.util.Scanner;

/**
 * 01背包  动态转移方程
 * f[i+1][j]=max(f[i-1][j-weight[i]]+value[i],f[i][j]);
 * @author Administrator
 *
 */
public class ny106 {

    /**
     * @param args
     * 现在有很多物品（它们是可以分割的），我们知道它们每个物品的单位重量的价值v和重量w（1<=v,w<=10）；如果给你一个背包它能容纳的重量为m（10<=m<=20）,
     * 你所要做的就是把物品装到背包里，使背包里的物品的价值总和最大
     */
    private static final int maxn=10+1;
    private static final int weight[]=new int[maxn];
    private static final int value[]=new int[maxn];
    static int map[][];
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        int x=scan.nextInt();
        int s,m;
        while(x>0){
            s=scan.nextInt();
            m=scan.nextInt();
            map=new int[s+1][m+1];
            for(int i=0;i<=s;i++){
                for(int j=0;j<=m;j++){
                    map[i][j]=0;
                }
            }
            for(int i=1;i<=s;i++){
                int a,b;
                a=scan.nextInt();
                b=scan.nextInt();
                value[i]=a;
                weight[i]=b;
            }
            for(int i=1;i<=s;i++){
                for(int j=1;j<=m;j++){
                    if(weight[i]<=j){
                        map[i][j]=max(map[i-1][j],map[i-1][j-weight[i]]+value[i]);
                    }else{
                        map[i][j]=map[i-1][j];
                    }
                }
            }
            System.out.println(map[s][m]);
            x--;
        }
    }
    private static int max(int i, int j) {
        // TODO Auto-generated method stub
        return i>j?i:j;
    }

}
