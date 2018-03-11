package 图论.拓扑排序;
        import java.util.Scanner;
public class poj1094 {

    /**
     * @param args
     * 就是给定一组字母的大小关系判断他们是否能组成唯一的拓扑序列。是典型的拓扑排序，但输出格式上确有三种形式：

    1.该字母序列有序，并依次输出；

    2.该序列不能判断是否有序；

    3.该序列字母次序之间有矛盾，即有环存在。

    而这三种形式的判断是有顺序的：先判断是否有环（3），再判断是否有序（1），
    最后才能判断是否能得出结果（2）。注意：对于（2）必须遍历完整个图，而（1）和（3）一旦得出结果，
    对后面的输入就不用做处理了。
     */
    static int indegree[]=new int[27];
    static int map[][]=new int[27][27];
    static int q[]=new int[27];
    static int n,m;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        int sign;
        String str;
        while(scan.hasNext()){
            n=scan.nextInt();
            m=scan.nextInt();
            scan.nextLine();
            if(n==0&&m==0){
                break;
            }
            init();
            sign=0;
            for(int i=1;i<=m;i++){
                str=scan.nextLine();
                if(sign==1){
                    continue;
                }
                int u=str.charAt(0)-'A'+1;
                int v=str.charAt(2)-'A'+1;
                map[u][v]=1;
                indegree[v]++;
                int s=DAG();
                if(s==0){
                    System.out.println("Inconsistency found after "+i+" relations.");
                    sign=1;
                }
                if(s==1){
                    System.out.print("Sorted sequence determined after "+i+" relations: ");
                    for(int j=0;j<n;j++){
                        System.out.print((char)(q[j]+'A'-1));
                    }
                    System.out.println(".");
                    sign=1;
                }
            }
            if(sign==0){
                System.out.println("Sorted sequence cannot be determined.");
            }
        }
    }
    private static void init() {
        // TODO Auto-generated method stub
        for(int i=0;i<27;i++){
            indegree[i]=0;
            for(int j=0;j<27;j++){
                map[i][j]=0;
            }
        }
    }
    private static int DAG() {
        // TODO Auto-generated method stub
        int count = 0;
        int temp[]=new int[27];
        int loc = 0;
        int m;
        int flag=1;
        for(int i=1;i<=n;i++){
            temp[i]=indegree[i];
        }
        for(int i=1;i<=n;i++){
            m=0;
            for(int j=1;j<=n;j++){
                if(temp[j]==0){
                    m++;
                    loc=j;
                }
            }
            if(m==0){
                return 0;
            }
            if(m>1){
                flag=-1;
            }

            q[count++]=loc;
            temp[loc]=-1;
            for(int j=1;j<=n;j++){
                if(map[loc][j]==1){
                    temp[j]--;
                }
            }

        }
        return flag;
    }

}
