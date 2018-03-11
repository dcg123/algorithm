package 贪心.区间;




        import java.util.Arrays;
        import java.util.Comparator;
        import java.util.Scanner;

public class poj2376 {

    /**
     * @param
     * 有一些奶牛，每只奶牛负责一个时间段。问覆盖完全部的时间段最少需要多少只奶牛。若不能全部覆盖，输出-1.
     */
    class Node{
        int x,y;
    }
    class cmp implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            // TODO Auto-generated method stub
            if(o1.x>o2.x){
                return 1;
            }else if(o1.x<o2.x){
                return -1;
            }else{
                if(o1.y>o2.y){
                    return 1;
                }else if(o1.y<o2.y){
                    return -1;
                }else
                {
                    return 0;
                }

            }
        }

    }
    static poj2376 poj=new poj2376();
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        int t,n;
        n=scan.nextInt();
        t=scan.nextInt();
        Node node[]=new Node[n+2];
        for(int i=0;i<n;i++){
            node[i]=poj.new Node();
            node[i].x=scan.nextInt();
            node[i].y=scan.nextInt();
        }
        int i,ans,time,max_end,j;
        Arrays.sort(node,0,n,poj.new cmp());//排序
        if(node[0].x!=1){//如果不是从1开始的就无法覆盖
            System.out.println("-1");
            return ;
        }
        else{
            time=node[0].y;
            i=1;
            while(node[i].x==1){//找到从1开始的区间最大结束区间
                time=node[i].y;
                i++;
            }
        }
        ans=1;
        while(time<t){
            if(i>=n){
                break;
            }
            j=i;
            max_end=node[j].y;
            i++;
            while(i<n&&node[i].x<=time+1){
                if(node[i].y>max_end){
                    j=i;
                    max_end=node[i].y;
                }
                i++;
            }
            if(max_end<=time||node[j].x>time+1){
                break;
            }
            else{
                ans++;
                time=node[j].y;
            }
        }
        if(time<t){
            System.out.println("-1");
        }else{
            System.out.println(ans);
        }
    }

}
