package dfs;



        import java.util.Scanner;

public class poj2386 {

    /**
     * @param args
     * 对于一个图，八个方向代表相邻，求出相邻的块的个数
     */
    static int max=100+10;
    static char map[][]=new char[max][max];
    static int n,m;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);

        n=scan.nextInt();
        m=scan.nextInt();
        scan.nextLine();
        for(int i=1;i<=n;i++){
            String str=scan.nextLine();
            char a[]=str.toCharArray();
            for(int j=0;j<m;j++){
                map[i][j+1]=a[j];
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]=='W'){
                    search(i,j);

                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
    private static void search(int i, int j) {
        // TODO Auto-generated method stub
        if(map[i][j-1]=='W') { map[i][j-1]='.'; search(i,j-1); }
        if(map[i][j+1]=='W') { map[i][j+1]='.'; search(i,j+1); }
        if(map[i-1][j]=='W') { map[i-1][j]='.'; search(i-1,j); }
        if(map[i+1][j]=='W') { map[i+1][j]='.'; search(i+1,j); }
        if(map[i-1][j-1]=='W') { map[i-1][j-1]='.'; search(i-1,j-1); }
        if(map[i-1][j+1]=='W') { map[i-1][j+1]='.'; search(i-1,j+1); }
        if(map[i+1][j-1]=='W') { map[i+1][j-1]='.'; search(i+1,j-1); }
        if(map[i+1][j+1]=='W') { map[i+1][j+1]='.'; search(i+1,j+1); }
    }

}
