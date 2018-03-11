package 转换.n皇后问题;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Arrays;

/**
 * Created by user on 2017/9/27.
 */
public class Main {
    static int QUEEN=8;
    static int a[]=new int[QUEEN];
    static int INITIAL= -10000;
    public static void main(String args[]){
        init();
        queen();

    }

    private static void init() {
        Arrays.fill(a,INITIAL);
    }
    private static void queen(){
        int i=0,j=0,n=0;
        while (i<QUEEN){
            while (j<QUEEN){
                if (valid(i,j)){
                    a[i]=j;
                    j=0;
                    break;
                }
                else {
                    j++;
                }
            }
            if (a[i]==INITIAL){
                if (i==0){
                    break;
                }
                else {
                    --i;
                    j=a[i]+1;
                    a[i]=INITIAL;
                    continue;
                }
            }
            if (i==QUEEN-1){
                ++n;
                System.out.println(n);
                print();
                j = a[i] + 1;             //从最后一行放置皇后列数的下一列继续探测
                a[i] = INITIAL;           //清除最后一行的皇后位置
                continue;
            }
            ++i;
        }
    }

    private static void print() {
        int i, j;
        for (i = 0; i < QUEEN; ++i)
        {
            for (j = 0; j < QUEEN; ++j)
            {
                if (a[i] != j)      //a[i]为初始值
                    System.out.printf("%c ", '.');
                else                //a[i]表示在第i行的第a[i]列可以放置皇后
                    System.out.printf("%c ", '#');
            }
            System.out.printf("\n");
        }
        for (i = 0; i < QUEEN; ++i)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
        System.out.printf("--------------------------------\n");
    }

    private static boolean valid(int row, int clo) {
        int i;
        for ( i=0;i<QUEEN;i++){
            if (a[i]==clo||Math.abs(i-row)==Math.abs(a[i]-clo)){
                return false;
            }
        }
        return true;
    }
}
