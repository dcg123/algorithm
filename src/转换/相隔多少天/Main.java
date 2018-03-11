package 转换.相隔多少天;

/**
 * Created by user on 2017/9/26.
 */
public class Main {
    static int days=365;
    static int s[]={0,31,28,31,30,31,30,31,31,30,31,30,31};
    static int count_day(int da,int ma,int ya,int db,int mb,int yb){
        int resa=calc(da,ma,ya);
        int resb=calc(db,mb,yb);
        return Math.abs(resa-resb);
    }

    private static int calc(int day, int month, int year) {
        int res=(year-1)*days+leap(year-1);
        for (int i=1;i<month;i++){
            res+=s[i];
        }
        if (Isleap(year)&&month>2){
            res++;
        }
        res+=day;
        return res;
    }

    private static boolean Isleap(int year) {
        if (year%400==0||year%100==0&&year%4==0){
            return true;
        }
        return false;
    }

    private static int leap(int y) {
        if (y==0){
            return 0;
        }
        return y/4-y/100+y/400;
    }

    public static void main(String[] args) {
        int ans=count_day(26,9,2017,28,9,2017);
        System.out.println(ans);
    }
}
