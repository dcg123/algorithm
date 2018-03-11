package 图论.最小生成树;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Union;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by user on 2017/10/12.
 */
public class hdu1598 {
    /**
     *
     * XX星有许多城市，城市之间通过一种奇怪的高速公路SARS(Super Air Roam Structure---超级空中漫游结构）
     * 进行交流，每条SARS都对行驶在上面的Flycar限制了固定的Speed，
     * 同时XX星人对 Flycar的“舒适度”有特殊要求，即乘坐过程中最高速度与最低速度的差越小乘坐越舒服 ,
     * (理解为SARS的限速要求，flycar必须瞬间提速/降速，痛苦呀 ),
     但XX星人对时间却没那么多要求。要你找出一条城市间的最舒适的路径。(SARS是双向的）。
     * @param args
     */
    static int n,m;
    class Node{
        int u,v,w;
    }
    static hdu1598 hdu=new hdu1598();
    static int pre[]=new int[250];
    static Node []node=new Node[205*205];
    class cmp implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o1.w<o2.w?-1:1;
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            n=scanner.nextInt();
            m=scanner.nextInt();
            if(n+m==0){
                break;
            }
            for (int i=0;i<m;i++){
                node[i]=hdu.new Node();
                node[i].u=scanner.nextInt();
                node[i].v=scanner.nextInt();
                node[i].w=scanner.nextInt();
            }
            int q=scanner.nextInt();
            Arrays.sort(node,0,m,hdu.new cmp());
            int k;
            while (q-->0){
                boolean flag=true;
                int x=scanner.nextInt();
                int y=scanner.nextInt();
                int ans=Integer.MAX_VALUE;
                for (int i=0;i<m;i++){
                    init();
                    flag=false;
                    k=0;
//                    for (int j=i;j<m;j++){
//                        Union2(node[i].u,node[i].v);
//                        if (find(x)==find(y)){
//                            flag=true;
//                            k=j;
//                            break;
//                        }
//                    }
                    if (!flag){
                        break;
                    }
                    ans=Math.min(ans,node[k].w-node[i].w);
                }
                if (ans==Integer.MAX_VALUE){
                    System.out.println("-1");
                }else {
                    System.out.println(ans);
                }
            }

        }
    }

    private static void init() {
        for (int i=0;i<=n;i++){
            pre[i]=i;
        }
    }
}
