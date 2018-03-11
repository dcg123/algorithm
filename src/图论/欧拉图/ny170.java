package 图论.欧拉图;



        import java.util.Scanner;

public class ny170 {

    /**
     * @param args
     * 这道题还是挺有意思的，对于这组数据1 2， 1  3，1   4，2  3  4，都只出现了一次，如果说1发生了故障，那么局部的数据就没办法传递了，所以需要在2 3和 3 4之间再增设光纤，所以，我们可以看出，如果一个点度数是1，那么如果他的相邻节点故障，那就会出现整体的故障。
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        int t;
        int dree[];
        int sum;
        t=scan.nextInt();
        while(scan.hasNext()){

            sum=0;

            dree=new int[t+1];
            for(int i=1;i<=t;i++){
                int a=scan.nextInt();
                int b=scan.nextInt();
                dree[a]++;
                dree[b]++;
            }
            System.out.println(123);
            for(int i=1;i<=t;i++){
                if(dree[i]==1){
                    sum++;
                }
            }
            System.out.println((sum+1)/2);
        }

    }

}
