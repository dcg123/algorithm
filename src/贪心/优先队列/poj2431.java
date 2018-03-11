package 贪心.优先队列;



        import java.util.Arrays;
        import java.util.Comparator;
        import java.util.PriorityQueue;
        import java.util.Queue;
        import java.util.Scanner;

public class poj2431 {

    /**
     * @param args
     *
    题意：一辆卡车要行驶L单位距离。最开始时，
    卡车上有P单位汽油，每向前行驶1单位距离消耗1单位汽油。
    如果在途中车上的汽油耗尽，卡车就无法继续前行，即无法到达终点。
    途中共有N个加油站，加油站提供的油量有限，卡车的油箱无限大，
    无论加多少油都没问题。给出每个加油站距离终点的距离和能够提供的油量，
    问卡车从起点到终点至少要加几次油？如果不能到达终点，输出-1。
     */
    class Node{
        int gas;
    }
    static int max=1000;
    static int a[]=new int[max];
    static int b[]=new int[max];
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        Comparator<Node> comparator=new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                // TODO Auto-generated method stub
                if(o1.gas>o2.gas){
                    return -1;
                }else if(o1.gas<o2.gas){
                    return 1;
                }else{
                    return 0;
                }
            }
        };

        int n,p,l;
        poj2431 poj=new poj2431();

        n=scan.nextInt();
        Queue<Node> queue=new PriorityQueue<>(n,comparator);
        for(int i=0;i<n;i++){
            a[i]=scan.nextInt();
            b[i]=scan.nextInt();
        }
        l=scan.nextInt();
        p=scan.nextInt();
        for(int i=0;i<n;i++){
            a[i]=l-a[i];
        }
        a[n]=0;
        b[n]=0;
        sort(a,n);
        int ans=0,pos=0,tank=p;
        for(int i=0;i<n;i++){
            int d=a[i]-pos;
            while(tank-d<0){
                if(queue.size()==0){
                    System.out.println("-1");
                    return ;
                }
                tank+=queue.peek().gas;
                ans++;
            }
            tank-=d;
            pos=a[i];
            Node node=poj.new Node();
            node.gas=b[i];
            queue.add(node);
        }
        System.out.println(ans);
    }
    private static void sort(int[] a, int n) {
        // TODO Auto-generated method stub
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1-i;j++){
                if(a[j]>a[j+1]){
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;

                    temp=b[j];
                    b[j]=b[j+1];
                    b[j+1]=temp;
                }
            }
        }
    }

}
