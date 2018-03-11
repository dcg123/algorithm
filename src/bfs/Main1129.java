package bfs;

import java.util.*;

/**
 * Created by user on 2017/10/3.
 */
public class Main1129 {
    static int n,m,ex,ey;
    static char map[][]=new char[110][110];
    static boolean vis[][]=new boolean[110][110];
    class Node{
        int x,y;
    }
    static Map<String ,Integer> hashMap;
    static Main1129 main1129=new Main1129();
    static int d[][]={{0,-1},{-1,0},{0,1},{1,0}};
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            n=scanner.nextInt();
            m=scanner.nextInt();
            if (n+m==0){
                break;
            }
            hashMap=new HashMap<String, Integer>();
            hashMap.put("N",1);
            hashMap.put("E",2);
            hashMap.put("W",0);
            hashMap.put("S",3);
            scanner.nextLine();
            int sx = 0,sy=0;
            for (int i=0;i<n;i++){
                String str=scanner.nextLine();
                char a[]=str.toCharArray();
                for (int j=0;j<m;j++){
                    map[i][j]=a[j];
                    if (map[i][j]=='T'){
                        sx=i;
                        sy=j;
                        map[i][j]='.';
                    }
                    if (map[i][j]=='X'){
                        ex=i;
                        ey=j;
                    }
                }
            }
            String str=scanner.nextLine();
            int begin=hashMap.get(str);
            if (bfs(sx,sy,begin)){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
    static boolean bfs(int x,int y,int begin){
        Queue<Node> queue=new LinkedList<Node>();
        init();
        vis[x][y]=true;
        Node temp=main1129.new Node();
        temp.x=x;
        temp.y=y;
        queue.offer(temp);
        while (queue.size()!=0){
            Node s=queue.poll();
            if (s.x==ex&&s.y==ey){
                return true;
            }

        }
        return false;
    }

    private static void init() {
        for (int i=0;i<110;i++){
            for (int j=0;j<110;j++){
                vis[i][j]=false;
            }
        }
    }
}
