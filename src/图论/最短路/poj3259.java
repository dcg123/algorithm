package 图论.最短路;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by user on 2017/8/13.
 */
public class poj3259 {
    /**
     * 题意是问是否能通过虫洞回到过去；

     虫洞是一条单向路，不但会把你传送到目的地，而且时间会倒退Ts。

     我们把虫洞看成是一条负权路，问题就转化成求一个图中是否存在负权回路；
     */
    static int INF=10000000;
    static int mark[]=new int[503];
    static int a[][]=new int[503][503];
    static int d[]=new int[503];
    static int num_in[]=new int[503];
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        int num,n,m,w;
        num=scanner.nextInt();
        while(num-->0){
            n=scanner.nextInt();
            m=scanner.nextInt();
            w=scanner.nextInt();
            init();
            for(int i=0;i<m;i++){
                int x=scanner.nextInt(),y=scanner.nextInt(),temp=scanner.nextInt();
                if(a[x][y]>temp){
                    a[x][y]=temp;
                    a[y][x]=temp;
                }
            }
            for(int i=0;i<w;i++){
                int x=scanner.nextInt(),y=scanner.nextInt(),temp=scanner.nextInt();
                temp=-temp;
                if(a[x][y]>temp)
                {
                    a[x][y]=temp;
                }
            }
            if(spfa(n)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

    private static boolean spfa(int n) {
        Queue<Integer> queue=new LinkedList<Integer>();
        queue.offer(1);
        d[1]=0;
        num_in[1]++;
        while (queue.size()!=0){
            int cur=queue.poll();
            if(num_in[cur]>=n){
                return true;
            }
            mark[cur]=0;//出队
            for(int i=1;i<=n;i++){
                if(a[cur][i]+d[cur]<d[i]){
                    d[i]=a[cur][i]+d[cur];
                    if(mark[i]==0){//能松弛又不在队列中的要入队
                        mark[i]=1;
                        if(num_in[i]>=n){
                            return true;//大于n，结束，表示有负环
                        }
                        queue.offer(i);
                        num_in[i]++;
                    }
                }
            }
        }
        return false;
    }

    private static void init() {
        Arrays.fill(d,INF);
        Arrays.fill(mark,0);
        Arrays.fill(num_in,0);
        for(int i=0;i<503;i++){
            for(int j=0;j<503;j++){
                a[i][j]=INF;
            }
        }
    }
}
