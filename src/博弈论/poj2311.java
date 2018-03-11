package 博弈论;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by user on 2017/10/17.
 */
public class poj2311 {
    /**
     * 准备一张分成w*h的格子的长方形纸张 两人轮流切割纸张 要沿着格子的边界切割 水平或者
     * 垂直的将纸张切成两部分 切割了n次之后的到n+1张纸张 每次都选择气的的每一张纸在进行切割
     * 首先切除只有一个格子的纸张的一方获胜 当双方都采取最优策虐时 先手必胜
     *
     */
    static int MAX_WH=200;
    static int mem[][]=new int[MAX_WH][MAX_WH];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int w=scanner.nextInt();
        int h=scanner.nextInt();
        for (int i=0;i<MAX_WH;i++){
            for (int j=0;j<MAX_WH;j++){
                mem[i][j]=-1;
            }
        }
        if(grundy(w,h)!=0){
            System.out.println("WIN");
        }else {
            System.out.println("LOSE");
        }
    }

    private static int grundy(int w, int h) {
        if (mem[w][h]!=-1){
            return mem[w][h];
        }
        Set<Integer> set=new LinkedHashSet<Integer>();
        for (int i=2;w-i>=2;i++) set.add(grundy(i,h)^grundy(w-i,h));
        for (int i=2;h-i>=2;i++) set.add(grundy(w,i)^grundy(w,h-i));
        int res=0;
        //while()s.count(res) res++;
        return mem[w][h]=res;
    }
}
