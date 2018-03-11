package bfs.三维地宫bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by user on 2017/10/3.
 */
public class Main {
    static int INF= 0x3f3f3f3f;
    static char map[][][]=new char[35][35][35];
    static int ans, l, r, c;
    static int dirx[] = {1, -1, 0, 0, 0, 0};
    static int diry[] = {0, 0, 1, -1, 0, 0};
    static int dirz[] = {0, 0, 0, 0, 1, -1};
    class node{
        int x, y, z;
        int step;
    }
    static Main main=new Main();
    static node st=main.new node(), en=main.new node();
    static Queue<node > q;
    static char s[]=new char[10000];
    static boolean vis[][][]=new boolean[35][35][35];
    static boolean limit(node s){
        return (s.x<l&&s.x>=0&&s.y>=0&&s.y<r&&s.z>=0&&s.z<c&&map[s.x][s.y][s.z] != '#');
    }

    static boolean match(node s){
        if(s.x==en.x&&s.y==en.y&&s.z==en.z) return true;
        else return false;
    }
    static void bfs(){
        q=new LinkedList<node>();
        ans = INF;  //初始化最大
        int i;
        q.offer(st);
        //map[st.x][st.y][st.z] = '#';
        vis[st.x][st.y][st.z] = true;
        while(q.size()!=0){
            node temp = q.poll();
            for(i = 0; i < 6; i ++){
                node temp2=main.new node();
                temp2.x = temp.x+dirx[i];
                temp2.y = temp.y+diry[i];
                temp2.z = temp.z+dirz[i];
                temp2.step = temp.step+1;
                if(limit(temp2)&&!vis[temp2.x][temp2.y][temp2.z]){
                    if(match(temp2)){
                        ans = ans<temp2.step?ans:temp2.step;  //要bfs完全部的
                    }
                    else{
                        q.offer(temp2);
                        vis[temp2.x][temp2.y][temp2.z] = true;
                    }
                }
            }

        }
        if(ans == INF) System.out.printf("Trapped!\n");
        else System.out.printf("Escaped in %d minute(s).\n", ans);
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int i, j, k;
        while(scanner.hasNext()){
            l=scanner.nextInt();
            r=scanner.nextInt();
            c=scanner.nextInt();
            if (r==0||l==0||c==0){
                break;
            }
            scanner.nextLine();
            init();
            for(i = 0; i < l; i ++){
                for(j = 0; j < r; j ++){
                    String str=scanner.nextLine();
                    char a[]=str.toCharArray();
                    for(k = 0; k <c; k ++){
                        map[i][j][k]=a[k];
                        if(map[i][j][k] == 'S'){
                            st.x = i; st.y = j; st.z = k; st.step = 0;
                        }
                        if(map[i][j][k] == 'E'){
                            en.x =i; en.y = j; en.z = k; en.step = 0;
                        }
                    }
                }
                scanner.nextLine();
                scanner.nextLine();
            }
            bfs();

        }

    }

    private static void init() {
        for (int i=0;i<35;i++){
            for (int j=0;j<35;j++){
                for (int k=0;k<35;k++){
                    vis[i][j][k]=false;
                    map[i][j][k]=0;
                }
            }
        }
    }
}
