package 图论.最短路;

import java.util.Scanner;

/**
 * Created by user on 2017/8/15.
 */
public class aoj2200 {
    /**
     * 快递到了：你是某个岛国（ACM-ICPC Japan）上的一个苦逼程序员，
     * 你有一个当邮递员的好基友利腾桑遇到麻烦了：
     * 全岛有一些镇子通过水路和旱路相连，
     * 走水路必须要用船，在X处下船了船就停在X处。而且岛上只有一条船，
     * 下次想走水路还是得回到X处才行；
     * 两个镇子之间可能有两条以上的水路或旱路；
     * 邮递员必须按照清单上的镇子顺序送快递
     * （镇子可能重复，并且对于重复的镇子不允许一次性处理，
     * 比如ABCB的话B一定要按顺序走两次才行）。
     测试数据有多组：
     N M
     x1 y1 t1 sl1
     x2 y2 t2 sl2
     …
     xM yM tM slM
     R
     z1 z2 … zR
     N (2 ≤ N ≤ 200) 是镇子的数量，M (1 ≤ M ≤ 10000) 是旱路和水路合计的数量。
     从第2行到第M + 1行是路径的描述，路径连接xi  yi两地，路径花费 ti (1 ≤ ti ≤ 1000)时间，
     sli 为L时表示是旱路，S时表示是水路。可能有两条及以上路径连接两个镇子，并且路径都是双向的。
     M + 2行的R是利腾需要去的镇子的数量，M + 3是利腾需要去的镇子的编号。
     初始状态利腾和船都在第一个镇子，且肯定有方法达到需要去的镇子。
     测试数据为0 0的时候表示终止。
     */
    static int sea[][]=new int[205][205], land[][]=new int[205][205], dp[][]=new int[1005][205];
    static int n,m,r,a[]=new int[1005];
    static int INF=10000000;
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            n=scanner.nextInt();
            m=scanner.nextInt();
            if(n+m==0){
                break;
            }
            scanner.nextLine();
            for(int i = 1; i <= n; ++i)
                for(int j = 1; j <= n; ++j)
                    sea[i][j] = land[i][j] = i == j ? 0 : INF;
            for(int i=1;i<=m;i++){
                String str=scanner.nextLine();
                String a[]=str.split(" ");
                int x=Integer.valueOf(a[0]);
                int y=Integer.valueOf(a[1]);
                int t=Integer.valueOf(a[2]);
                if(a[3].equals("S")){
                    sea[x][y]=sea[y][x]=Math.min(sea[x][y],t);
                }else{
                    land[x][y]=land[y][x]=Math.min(land[x][y],t);
                }
            }
            r=scanner.nextInt();
            for(int i=1;i<=r;i++){
                a[i]=scanner.nextInt();
            }
            for(int k=1;k<=n;k++){
                for(int i = 1; i <= n; ++i) {
                    for(int j = 1; j <= n; ++j) {
                        sea[i][j] =Math. min(sea[i][j], sea[i][k] + sea[k][j]);
                        land[i][j] =Math. min(land[i][j], land[i][k] + land[k][j]);
                    }
                }
            }
            for(int i=0;i<1005;i++){
                for(int j=0;j<205;j++){
                    dp[i][j]=1000000;
                }
            }
            dp[1][a[1]]=0;//
            for(int i=1;i<=r;i++){
                for(int j=1;j<=n;j++){
                    dp[i][j]=Math.min(dp[i][j],dp[i-1][j]+land[a[i-1]][a[i]]);
                    for(int k=1;k<=n;k++){
                        dp[i][k]=Math.min(dp[i][k],dp[i-1][j]+land[a[i-1]][j]+sea[j][k]+land[k][a[i]]);
                    }
                }
            }
           for(int i=1;i<=n;i++){
                System.out.println(dp[r-1][i]);
           }
        }
    }
}
