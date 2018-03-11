package 贪心;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by user on 2017/8/11.
 */
public class poj1862 {
    /**
     * 变形虫：从N个数任取两个数按2*sqrt(Main*b)合成新数放回，求最后那个数的最小值。
     * 贪心策略是使尽量使大的数多参与开放运算。
     * 每次取出最大和次大的变形虫杂交，
     * 直至剩下一条光棍。使用最大堆可以很高效地维持最大的数。
     */
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        List<Double> list=new ArrayList<Double>();
        int n=scanner.nextInt();
        for(int i=0;i<n;i++){
            list.add(scanner.nextDouble());
        }
       while (list.size()!=1){
            Collections.sort(list,Collections.reverseOrder());
            double max1=list.get(0);
            double max2=list.get(1);
            list.remove(0);
            list.remove(0);
            double count=2*Math.sqrt(max1*max2);
            list.add(count);
        }
        System.out.printf("%.3f\n",list.get(0));
    }
}
