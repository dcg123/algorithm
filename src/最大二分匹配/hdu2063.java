package 最大二分匹配;



        import java.util.Scanner;

public class hdu2063 {

    /**
     * @param args
     * RPG girls今天和大家一起去游乐场玩，终于可以坐上梦寐以求的过山车了。可是，过山车的每一排只有两个座位，而且还有条不成文的规矩，
    就是每个女生必须找个个男生做partner和她同坐。但是，每个女孩都有各自的想法，举个例子把，Rabbit只愿意和XHD或PQK做partner，Grass
    只愿意和linle或LL做partner，PrincessSnow愿意和水域浪子或伪酷儿做partner。考虑到经费问题，boss刘决定只让找到partner的人去坐过
    山车，其他的人，嘿嘿，就站在下面看着吧。聪明的Acmer，你可以帮忙算算最多有多少对组合可以坐上过山车吗？

     */
    static int maxn=505;
    static int line[][]=new int[maxn][maxn];
    static int girl[]=new int[maxn];
    static int user[]=new int[maxn];
    static int k,n,m;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        while(((k=scan.nextInt())!=0)){
            for(int i=0;i<maxn;i++){
                girl[i]=0;
                for(int j=0;j<maxn;j++){
                    line[i][j]=0;
                }
            }
            m=scan.nextInt();
            n=scan.nextInt();
            for(int i=0;i<k;i++){
                int x=scan.nextInt();
                int y=scan.nextInt();
                line[x][y]=1;
            }
            int sum=0;
            for(int i=1;i<=m;i++){
                for(int j=0;j<maxn;j++){
                    user[i]=0;
                }
                if(found(i)){
                    sum++;
                }
            }
            System.out.println(sum);
        }
    }
    private static boolean found(int x) {
        // TODO Auto-generated method stub
        for(int i=1;i<=n;i++){
            if(line[x][i]==1&&user[i]==0){
                user[i]=1;
                if(girl[i]==0||found(girl[i])){
                    girl[i]=x;
                    return true;
                }
            }
        }
        return false;
    }

}
