package 图论.最短路;



        import java.util.Scanner;

public class hdu1548 {

    /**
     * @param args
     * 有一天桐桐做了一个梦，梦见了一种很奇怪的电梯。
     * 大楼的每一层楼都可以停电梯，而且第i层楼(1≤i≤N)上有一个数字K；
     * (0≤Ki≤N)。电梯只有四 个按钮：开，关，上，下。
     * 上下的层数等于当前楼层上的那个数字。当然，如果不能满足要求，
     * 相应的按钮就会失灵。例如：3 3 1 2 5代表了Ki (K1=3，K2=3，…)，
     * 从一楼开始。在一楼，按“上，”可以到4楼，按“下”是不起作用的，
     * 因为没有-2楼。那么，从A楼到B楼至少要按几次按钮 呢？
     */
    static int MAX=200+2;
    static boolean vis[] =new boolean[MAX];
    static int n;
    static int map[][]=new int[MAX][MAX];
    static int a[]=new int[MAX];
    static  int dis[]=new int[MAX];
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            n=scan.nextInt();

            if(n==0){
                break;
            }
            int A=scan.nextInt();
            int B=scan.nextInt();
            for(int i=0;i<=n;i++){
                for(int j=0;j<=n;j++){
                    map[i][j]=i==j?0:1000000000;
                }
            }
            for(int i=0;i<n;i++){
                a[i]=scan.nextInt();
                if(i+a[i]<n){
                    map[i][i+a[i]]=1;
                }
                if(i-a[i]>=0){
                    map[i][i-a[i]]=1;
                }
            }
            dijkstra(A-1);
            System.out.println(dis[B-1]==1000000000?-1:dis[B-1]);
        }
    }
    private static void dijkstra(int s) {
        // TODO Auto-generated method stub
        for(int i=0;i<n;i++){
            vis[i]=false;
            dis[i]=map[s][i];
        }
        vis[s]=true;
        dis[s]=0;
        for(int i=1;i<n;i++){
            int u=s;
            int mindist=1000000000;
            for(int j=0;j<n;j++){
                if(!vis[j]&&dis[j]<mindist){
                    u=j;
                    mindist=dis[j];
                }
            }
            vis[u]=true;
            for(int j=0;j<n;j++){
                if(!vis[j]&&map[u][j]<1000000000){
                    if(dis[j]>dis[u]+map[u][j]){
                        dis[j]=dis[u]+map[u][j];
                    }
                }
            }
        }
    }

}
