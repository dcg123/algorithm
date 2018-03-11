package 剑指offer;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by user on 2017/11/29.
 */
public class Main6 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int [] array=new int[5];
        for (int i=0;i<array.length;i++){
            array[i]=scanner.nextInt();
        }
        System.out.println(minNumberInRotateArray(array));
    }
    public static int minNumberInRotateArray(int [] array) {
        if (array.length<=0){
            return 0;
        }
        Arrays.sort(array);
        return array[0];
    }
}
