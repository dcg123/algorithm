package 最大二分匹配.最优匹配;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by user on 2017/10/14.
 */
public class Main {
    static int n;
    static int N=310;
    static int map[][]=new int[N][N];
    static boolean visitx[]=new boolean[N],visity[]=new boolean[N];
    static int lx[]=new int[N],ly[]=new int[N];
    static int match[]=new int[N];
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            n=scanner.nextInt();
            scanner.nextLine();
            int ans=0;
            Arrays.fill(match,-1);
            for (int i=0;i<n;i++){
                String str=scanner.nextLine();
                String a[]=str.split(" ");
                for (int j=0;j<n;j++){
                    map[i][j]=Integer.valueOf(a[j]);
                }
            }
            km();
            for(int i = 0; i < n; ++i) //权值相加
                ans += map[match[i]][i];
            System.out.printf("%d\n", ans);
        }
    }

    private static void km() {
        int temp;
        Arrays.fill(lx, 0);//初始化顶标
        Arrays.fill(ly, 0); //ly[i]为0
        for (int i = 0; i < n; i++) {//lx[i]为权值最大的边
            for (int j = 0; j < n; j++) {
                lx[i] = Math.max(lx[i], map[i][j]);
            }
        }
        for (int i = 0; i < n; i++) {//对n个点匹配
            while (true) {
                Arrays.fill(visitx, false);
                Arrays.fill(visity, false);
                if (Hungary(i)) {//匹配成功
                    break;
                } else {//匹配失败，找最小值
                    temp = Integer.MAX_VALUE;
                    for (int j = 0; j < n; ++j) //x在交错树中
                        if (visitx[j])
                            for (int k = 0; k < n; ++k) //y在交错树外
                                if (!visity[k] && temp > lx[j] + ly[k] - map[j][k])
                                    temp = lx[j] + ly[k] - map[j][k];
                    for (int j = 0; j < n; ++j) //更新顶标
                    {
                        if (visitx[j])
                            lx[j] -= temp;
                        if (visity[j])
                            ly[j] += temp;
                    }
                }
            }
        }
    }
    private static boolean Hungary(int u) {
        visitx[u]=true;
        for (int i=0;i<n;i++){
            if (!visity[i]&&lx[u]+ly[i]==map[u][i]){
                visity[i]=true;
                if (match[i]==-1||Hungary(match[i])){
                    match[i]=u;
                    return true;
                }
            }
        }
        return  false;
    }
}
