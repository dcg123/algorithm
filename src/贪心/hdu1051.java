package 贪心;


        import java.util.Scanner;

public class hdu1051 {

    /**
     * @param args
     * 给你n根木棍的长度和重量。根据要求求出制作该木棍的最短时间。
     * 建立第一个木棍需要1分钟，如果接着制作的木棍比这个木棍的长度长，重量要重，
     * 那么接着制作的木棍不需要花费时间！然后如果再继续接着制作，则下一个木棍要比上一个木棍的长度长，重量大，则这个木棍也不需要花费时间！
     * 依次类推，反之，则需要花费一分钟，然后让你求出制作这一批木棍花费的最少的时间是多少！
     *
     *
     * 解题思路：
    其实大概明白了题意，便可以知道，这题考的是贪心！然后关键就在于贪心策略的选择！题目说了求最小时间，那就肯定要求长度和重量都要相对来说最小，我的策略如下：


    1.首先按照木棍的长度进行排序，如果长度相等则重量重的放在前面。
    2.当然排序完后，不一定都是下一根木棍重量和长度都大于前一根的，但是我们可以根据排序建立的数组再进行多次扫描，比较。
    3.根据建立的数组依次比较他们的重量，如果大于标记数组跳过，否则ans加1。
     */
    static int n;
    class Node{
        int x;
        int y;
        boolean vis;
    }
    static Node e[]=new Node[5000];
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        int t;
        t=scan.nextInt();
        while(t>0){
            int ans=0;
            int count=0;
            n=scan.nextInt();
            for(int i=0;i<n;i++){
                int a=scan.nextInt();
                int b=scan.nextInt();
                hdu1051 hdu=new hdu1051();
                Node node=hdu.new Node();
                node.x=a;
                node.y=b;
                node.vis=false;
                e[i]=node;
            }
            //排序
            sort();
            int p1 = 0;
            while(count!=n){
                for(int i=0;i<n;i++){
                    if(!e[i].vis){
                        p1=i;
                        ans++;
                        break;
                    }
                }
                for(int i=0;i<n;i++){
                    if(!e[i].vis&&e[i].x>=e[p1].x&&e[i].y>=e[p1].y){
                        count++;
                        e[i].vis=true;
                        p1=i;
                    }
                }
            }
            System.out.println(ans);
            t--;
        }
    }
    private static void sort() {
        // TODO Auto-generated method stub
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1-i;j++){
                if(e[j].x>e[j+1].x){
                    int temp=e[j].x;
                    e[j].x=e[j+1].x;
                    e[j+1].x=temp;

                    int temp1=e[j].y;
                    e[j].y=e[j+1].y;
                    e[j+1].y=temp1;
                }
            }
        }
    }

}
