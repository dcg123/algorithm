package dfs;


        import java.util.HashMap;
        import java.util.Map;
        import java.util.Scanner;

public class poj3050 {

    /**
     * @param args
     * 在5 * 5的方格里跳房子，起点是任意位置。将跳过的数连起来组成一个5位数（前导零可能），问一共能组成多少个数字？
     */
    static int e[][]=new int[5][5];
    static Map<Integer,Integer> map=new HashMap<Integer,Integer>();
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                e[i][j]=scan.nextInt();
            }
        }
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                dfs(i,j,1,e[i][j]);
            }
        }
        System.out.println(map.size());
    }
    private static void dfs(int x, int y, int k, int num) {
        // TODO Auto-generated method stub
        if(k==6){
            if(!map.containsKey(num)){
                map.put(num, 0);
                return ;
            }
            return ;
        }
        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx>=0&&ny>=0&&nx<5&&ny<5){
                k++;
                dfs(nx,ny,k,num*10+e[nx][ny]);
                k--;
            }
        }
    }

}
