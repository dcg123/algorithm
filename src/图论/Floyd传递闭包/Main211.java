package 图论.Floyd传递闭包;

import java.util.Scanner;

/**
 * Created by user on 2017/10/7.
 */
public class Main211 {
    /**
     * 题目大意是说：给出牛之间的强弱关系，让你确定有多少头牛能够确定其排名。
     用Floyd做，对每给的一个胜负关系连一条边，最后跑一次Floyd，
     然后判断一头牛所确定的关系是否是n-1次，若是，则这头牛的排名可以确定
     * @param args
     */
    static int map[][]=new int[110][110];
    static int n,m;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            n=scanner.nextInt();
            m=scanner.nextInt();
            if (n+m==0){
                break;
            }
            init();
            scanner.nextLine();
            for (int i=0;i<m;i++){
                String str=scanner.nextLine();
                String a[]=str.split(" ");
                int x=Integer.valueOf(a[0]);
                int y=Integer.valueOf(a[1]);
                map[x][y]=1;
            }
            for (int k=1;k<=n;k++){
                for (int i=1;i<=n;i++){
                    for (int j=1;j<=n;j++){
                        if (map[i][k]==1&&map[k][j]==1){
                            map[i][j]=1;
                        }
                    }
                }
            }
            int ans=0;
            for (int i=1;i<=n;i++){
                int res=n-1;
                for (int j=1;j<=n;j++){
                    if (map[i][j]==1||map[j][i]==1){
                        res--;
                    }
                }
                if (res==0){
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }

    private static void init() {
        for (int i=0;i<110;i++){
            for (int j=0;j<110;j++){
                map[i][j]=0;
            }
        }
    }
}
