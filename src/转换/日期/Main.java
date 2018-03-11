package 转换.日期;

/**
 * Created by user on 2017/9/26.
 */
public class Main {
    /**
     * 给定日期 问这个日期是星期几
     */
    static int whatday(int d,int m,int y){
        int ans;
        if (m==1||m==2){
            m+=12;
            y--;
        }
        if ((y<1752)||(y==1752&&m<9)||(y==1752&&m==9&&d<3)){
            ans=(d+2*m+3*(m+1)/5+y+y/4+5)%7;

        }else {
            ans=(d+2*m+3*(m+1)/5+y+y/4-y/100+y/400)%7;
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans=whatday(26,9,2017);
        System.out.println(ans);
    }
}
