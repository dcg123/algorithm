package 贪心;

/**
 * Created by user on 2017/10/2.
 */
import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {
        Scanner cin = new Scanner(new BufferedInputStream(System.in));

        int T = cin.nextInt();
        while(T -- > 0) {

            int n = cin.nextInt();
            Node[] nodes = new Node[n];
            for(int i=0; i<n; i++) {
                nodes[i] = new Node(cin.nextInt(), cin.nextInt());
            }

            Arrays.sort(nodes);

            boolean[] vis = new boolean[n];
            int num = 0;
            int loop = 0;

            while(num < n) {
                int lsw = Integer.MIN_VALUE;
                for(int i=0; i<nodes.length; i++) {
                    if(vis[i]) {
                        continue;
                    }
                    Node node = nodes[i];
                    if(node.wei >= lsw) {
                        vis[i] = true;
                        num ++;
                        lsw = node.wei;
                    }
                }
                loop ++;
            }
            System.out.println(loop);
        }

        cin.close();
    }

}

class Node implements Comparable<Node> {

    int len;
    int wei;

    Node(int l, int w) {
        this.len = l;
        this.wei = w;
    }

    @Override
    public int compareTo(Node o) {
        int v = this.len - o.len;
        if(v != 0)
            return v;
        return this.wei - o.wei;
    }
}