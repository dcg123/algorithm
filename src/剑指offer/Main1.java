package 剑指offer;

import java.util.Scanner;

/**
 * Created by user on 2017/11/29.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int array[][]=new int[4][4];
        for (int i=0;i<4;i++){
            for (int j=0;j<4;j++){
                array[i][j]=scanner.nextInt();
            }
        }
        int target=scanner.nextInt();
        System.out.println(Find(target,array));
    }
    public static boolean Find(int target, int [][] array) {
        int row=0;
        boolean flag=false;
        for (int i=0;i<array.length;i++){
            row=i;
            if (target>array[i][0]){
                break;
            }
            if (target==array[i][0]){
                flag=true;
            }
        }
        if (flag){
            return true;
        }else {
            int left=0,right=array[0].length;
            for (int i=0;i<row;i++){
                if (target<=array[i][array[i].length/2]){
                    left=0;
                    right=array[i].length/2;
                }
                for (int j=left;j<right;j++){
                    if (target==array[i][j]){
                        flag=true;
                        return flag;
                    }
                }
            }
            return flag;
        }

    }
}
