package 最大二分匹配.最优匹配.最大权匹配;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by user on 2017/10/19.
 */
public class hdu2255 {
    static int MAXN = 330;
    static int INF= 0xffffff0;
    static int n,nx,ny;
    static int link[]=new int[MAXN],lx[]=new int[MAXN],ly[]=new int[MAXN],slack[]=new int[MAXN];
    static int visx[]=new int[MAXN],visy[]=new int[MAXN];
    static int Map[][]=new int[MAXN][MAXN];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        nx=ny=n;
        for (int i=1;i<=n;i++){
            for (int j=1;j<=n;j++){
                Map[i][j]=scanner.nextInt();
            }
        }
        System.out.println(km());
    }

    private static int km() {
        Arrays.fill(ly,0);
        Arrays.fill(link,-1);
        for(int i = 1; i <= nx; ++i)
        {
            lx[i] = -INF;
            for(int j = 1; j <= ny; ++j)
                if(Map[i][j] > lx[i])
                    lx[i] = Map[i][j];
        }
        for(int i = 1; i <= nx; ++i)
        {
            for(int j = 1; j <= ny; ++j)
                slack[j] = INF;
            while(true)
            {
                Arrays.fill(visx,0);
                Arrays.fill(visy,0);
                if(FindPath(i))
                    break;
                int d = INF;
                for(int j = 1; j <= ny; ++j)
                    if(visy[j]==0 && d > slack[j])
                        d = slack[j];
                for(int j = 1; j <= nx; ++j)
                    if(visx[j]==1)
                        lx[j] -= d;
                for(int j = 1; j <= ny; ++j)
                    if(visy[j]==1)
                        ly[j] += d;
                    else
                        slack[j] -= d;
            }
        }
        int res = 0;
        for(int i = 1; i <= ny; ++i)
            if(link[i] > -1)
                res += Map[link[i]][i];
        return res;
    }

    private static boolean FindPath(int u) {
        visx[u] = 1;
        for(int i = 1; i <= ny; ++i)
        {
            if(visy[i]==1)
                continue;
            int temp = lx[u] + ly[i] - Map[u][i];
            if(temp == 0)
            {
                visy[i] = 1;
                if(link[i] == -1 || FindPath(link[i]))
                {
                    link[i] = u;
                    return true;
                }
            }
            else if(slack[i] > temp)
                slack[i] = temp;
        }
        return false;
    }
}
