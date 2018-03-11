package bfs;

import java.util.Scanner;

/**
 * Created by user on 2017/10/10.
 */
public class Main587 {
    static int n,ans;
    static char map[][]=new char[10][10];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            n=scanner.nextInt();
            if (n==0){
                break;
            }
            scanner.nextLine();
            for (int i=0;i<n;i++){
                String  str=scanner.nextLine();
                char a[]=str.toCharArray();
                for (int j=0;j<n;j++){
                    map[i][j]=a[j];
                }
            }
            ans=0;
            dfs(0,0);
            System.out.println(ans);
        }
    }

    private static void dfs(int pos, int sum) {
        int r=pos/n,c=pos%n;
        if(pos==n*n){
            if(sum>ans) ans=sum;
            return;
        }
        if(map[r][c]=='.'){
            if(check(r,c)==1){
                map[r][c]='b';//b 表示建立一个blockhouse   
                dfs(pos+1,sum+1);
                map[r][c]='.';
            }
        }
        dfs(pos+1,sum);
    }

    private static int check(int r, int c) {
        int flag=1,i;
        for(i=r;i>=0;i--){//检测和之前的 b 不冲突即可，所以只要检测上面和左边的
            if(map[i][c]=='X') break;
            if(map[i][c]=='b'){
                flag=0;
                break;
            }
        }

        for(i=c;i>=0;i--){
            if(map[r][i]=='X') break;
            if(map[r][i]=='b'){
                flag=0;
                break;
            }
        }
        return flag;
    }
}
