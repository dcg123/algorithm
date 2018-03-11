package 博弈论;

import java.util.Scanner;

/**
 * Created by user on 2017/10/16.
 */
public class poj2348 {
    /**
     * 给两个整数a和b，两个人先后用较大的数减去较小数的整数倍，并且保证相减后为非负数。先把一个数变为0的人获胜。
     很显然，当大数是小数的整数倍时为必胜态。
     从这道题学会一个叫做自由度的东西，感觉能够为博弈推理提供思路。
     博弈基本就是一个推理必胜态和必败态的过程。自由度越低越好推理。
     不妨假设b为两个数中的较大数。
     如果b-a<a
     那么只能选择用b去减a，如果后继态是必胜态，那么该状态是必败态，否则就是必胜态。
     如果b-a>a呢？
     我们怎么能够转移到自由度较低的情况。
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a,b;
        while (scanner.hasNext()){
            a=scanner.nextInt();
            b=scanner.nextInt();
            if (a==0&&b==0){
                break;
            }
            boolean f=true;
            for (;;){
                if (a>b){
                    int temp=a;
                    a=b;
                    b=temp;
                }
                if (b%a==0){
                    break;
                }
                if (b-a>a){
                    break;
                }
                b-=a;
                f=!f;
            }
            if (f){
                System.out.println("Stan wins");
            }else {
                System.out.println("Ollie wins");
            }
        }
    }
}
