package 贪心;


        import java.util.Arrays;
        import java.util.Comparator;
        import java.util.Scanner;

public class poj3040 {

    /**
     * @param args
     * 题意：约翰要给他的牛贝西发工资，每天不得低于C元，约翰有n种面值的钱币，
     * 第i种的面值为v_i，数量有b_i。
     * 问这些钱最多给贝西发多少天的工资。注意，每种面值的金钱都是下一种的面值的倍数。
     */
    static int n,c;
    class Node{
        int x,y;
    }
    class cmp implements Comparator<Node>{

        @Override
        public int compare(Node A, Node B) {
            // TODO Auto-generated method stub
            if(A.x<B.x){
                return -1;
            }else if(A.x>B.x){
                return 1;
            }else{
                return 0;
            }
        }

    }
    static poj3040 poj=new poj3040();
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        n=scan.nextInt();
        c=scan.nextInt();
        Node []node =new Node[n];
        for(int i=0;i<n;i++){
            node[i]=poj.new Node();
            node[i].x=scan.nextInt();
            node[i].y=scan.nextInt();
        }
        //排序
        Arrays.sort(node,0,n,poj.new cmp());
        int count=0;
        for(int i=0;i<n;i++){
            Node ss=node[i];
            if(ss.y>=c){
                count+=ss.y;
                ss.y=0;
            }else{
                break;
            }
        }



    }

}
