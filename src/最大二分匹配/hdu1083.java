package 最大二分匹配;


        import java.util.Scanner;

public class hdu1083 {

    /**
     * @param args
     * 描述：有p门的课，每门课都有若干学生，现在要为每个课程分配一名课代表，
     * 每个学生只能担任一门课的课代表，如果每个课都能找到课代表，则输出"YES"，否则"NO"。
     */
    static int maxn=505;
    static boolean G[][]=new boolean[maxn][maxn];//图存储
    static boolean vis[]=new boolean[maxn];//是否遍历过
    static int p[]=new int[maxn];
    static int n,m;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner (System.in);
        int t,k;
        t=scan.nextInt();
        while(t>0){
            int count=0;
            for(int i=0;i<maxn;i++){
                p[i]=0;
                for(int j=0;j<maxn;j++){
                    G[i][j]=false;
                }
            }
            n=scan.nextInt();
            m=scan.nextInt();
            for(int i=1;i<=n;i++){
                k=scan.nextInt();
                for(int j=0;j<k;j++){
                    int a=scan.nextInt();
                    G[i][a]=true;
                }
            }
            for(int i=1;i<=n;i++){
                for(int j=0;j<maxn;j++){
                    vis[j]=false;
                }
                if(!find(i)){
                    break;
                }else{
                    count++;
                }
            }
            if(count==n){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
            t--;
        }
    }
    private static boolean find(int u) {
        // TODO Auto-generated method stub
        for(int i=1;i<=m;i++){
            if(G[u][i]&&!vis[i]){
                vis[i]=true;
                if(p[i]==0||find(p[i])){
                    /**
                     * 判断第i个学生是否选过课了，
                     * 如果选过了就看看能否更改这个学生所选的课程，
                     * 让这个学生选u这门课
                     */
                    //如果u这门课 i是可以选的，退出函数完成筛选，否则继续为u进行挑选学生，直到没有
                    p[i]=u;
                    return true;
                }
            }
        }
        return false;
    }

}
