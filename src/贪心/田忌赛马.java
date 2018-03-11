package 贪心;



        import java.util.Scanner;

public class 田忌赛马 {

    /**
     * @param args
     * 题意：
    田忌和齐王各有N匹马，判断怎样比赛，使田忌净胜场数最多。

    我感觉这题的精髓就是，不管怎么比赛，都要让田忌的马发挥最大价值。
    当然，马的第一要务是用来赢得比赛，而且要最大效益的赢，也就是要赢对方仅次于自己的马。
    当他不能完成这个任务的时候就要去输，并拉对方最快的马下水，给自己后面的队友创造更大的胜利机会。

    解题思路：
    1.若田忌最慢的马可以战胜齐王最慢的马，那么就让它战胜那匹慢马，胜利场次加1。（田忌最慢马 > 齐王最慢马）
    2.若田忌最慢的马不能战胜齐王最慢的马，那么它更加不能战胜其他的马，那就让它输，而且输给齐王最快马，失败场次加1。（田忌最慢马 < 齐王最快马）
    3.若田忌最慢的马与齐王最慢的马速度相等。此时，不能简单地认为与它打成平手就是最好情况，相反，打平是下下策，为什么呢？
    因为自己后面的队友很有可能战胜此时对方的这匹慢马，所以就算自己输一场，队友也能帮忙赢回一场，而胜一场，输一场的收益和打平一场的收益是一样的，而且自己输的时候可以拉对方最快的马下水，给己方最快的马创造更大的胜利机会（因为它失去了一个强劲的对手），也就是说己方最快的马很可能因为自己的牺牲再胜利一场，从这个角度看，还是自己故意输掉比较好。

    但是，还有一点需要注意，当自己放水前，如果己方最快的马原本就比对方最快的马快，然后还输给对方最快的马，那么己方最快的马的才华就浪费了，为什么？
    很简单，它原本就能赢，需要你放水么？- -！换句话说，这种情况下，自己的牺牲没有一点价值。
    所以，在放水时，一定要保证己方最快马不快于对方最快马。满足此条件后，让己方最慢马与对方最快马去比赛（有可能平局），这样，田忌的马就得到了充分的利用。
     */
    static int t[]=new int[1000+5];
    static int g[]=new int[1000+5];
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        int n,slow_t,slow_g,fast_t,fast_g,ans;
        while(((n=scan.nextInt())!=0)){
            ans=0;
            fast_t=n-1;
            fast_g=n-1;
            slow_t=0;
            slow_g=0;
            for(int i=0;i<n;i++){
                t[i]=scan.nextInt();
            }
            for(int i=0;i<n;i++){
                g[i]=scan.nextInt();
            }
            //排序
            sort(t,g,n);
            while(slow_t<=fast_t){
                if(t[slow_t]>g[slow_g]){
                    ans++;
                    slow_t++;
                    slow_g++;

                }
                else if(t[slow_t]<g[slow_g]){
                    ans--;
                    slow_t++;
                    fast_g--;

                }else{
                    if(t[fast_t]>g[fast_g]){
                        ans++;
                        fast_t--;
                        fast_g--;

                    }else{
                        if(t[slow_t]<g[fast_g]){
                            ans--;
                        }
                        slow_t++;
                        fast_g--;

                    }
                }

            }
            System.out.println(ans*200);
        }

    }

    private static void sort(int[] t2, int[] g2, int n) {
        // TODO Auto-generated method stub
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1-i;j++){
                if(t2[j]>t2[j+1]){
                    int temp=t2[j];
                    t2[j]=t2[j+1];
                    t2[j+1]=temp;
                }
                if(g2[j]>g2[j+1]){
                    int temp=g2[j];
                    g2[j]=g2[j+1];
                    g2[j+1]=temp;
                }
            }
        }
    }

}
