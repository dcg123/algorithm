package 图论.最短路;

import java.util.Scanner;

/**
 * Created by user on 2017/8/13.
 */
public class poj3268 {
    /**
     * 题目大意：给出n个点和m条边，接着是m条边，代表从牛a到牛b需要花费c时间，现在所有牛要到牛x那里去参加聚会，
     * 并且所有牛参加聚会后还要回来，给你牛x，除了牛x之外的牛，
     * 他们都有一个参加聚会并且回来的最短时间，从这些最短时间里找出一个最大值输出
     */
    static int MAX_N=1005;
    static int edge[][]=new int[MAX_N][MAX_N];
    static int n,e,x;
    static int mindis1[]=new int[MAX_N];
    static int mindis2[]=new int[MAX_N];
    static boolean vis1[]=new boolean[MAX_N];
    static boolean vis2[]=new boolean[MAX_N];
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        e=scanner.nextInt();
        x=scanner.nextInt();
        init();
        for(int i=0;i<e;i++){
            int x=scanner.nextInt(),y=scanner.nextInt(),temp=scanner.nextInt();
            edge[x-1][y-1]=temp;
        }
        dijkstra(--x);
        int ans = 0;
        for (int i = 0; i < n; ++i)
        {
            if (i == x) continue;
            if (mindis1[i] + mindis2[i] > ans) ans = mindis1[i] + mindis2[i];
        }
        System.out.println(ans);
    }

    private static void dijkstra(int s) {
        int pos1=0, pos2=0, te1 = 0, te2=0, tm1=0, tm2=0;
        for(int i=0;i<n;i++){
            vis1[i] = false;
            vis2[i] = false;
            mindis1[i] = 999999;
            mindis2[i] = 999999;
        }
        mindis1[s] = 0;
        mindis2[s] = 0;
        vis1[s] = true;
        vis2[s] = true;
        pos1 = s;
        pos2 = s;
        for (int i = 0; i < n - 1; ++i) {
            for (int j = 0; j < n; ++j) {
                if (!vis1[j] && edge[pos1][j] != -1 && mindis1[pos1] + edge[pos1][j] < mindis1[j]) {
                    mindis1[j] = mindis1[pos1] + edge[pos1][j];
                }
                if (!vis2[j] && edge[j][pos2] != -1 && mindis2[pos2] + edge[j][pos2] < mindis2[j]) {
                    mindis2[j] = mindis2[pos2] + edge[j][pos2];
                }
            }
            tm1 = 999999;
            tm2 = 999999;
            for (int j = 0; j < n; ++j) {
                if (!vis1[j] && mindis1[j] < tm1) {
                    tm1 = mindis1[j];
                    te1 = j;
                }
                if (!vis2[j] && mindis2[j] < tm2) {
                    tm2 = mindis2[j];
                    te2 = j;
                }
            }
            vis1[te1] = true;
            pos1 = te1;
            vis2[te2] = true;
            pos2 = te2;
        }
    }

    private static void init() {
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                edge[i][j]=-1;
            }
        }
    }
}
