package 转换.罗马进制转换;

import java.util.Scanner;

/**
 * Created by user on 2017/9/26.
 */
public class Main {
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        String s=rome(80);
        System.out.println(s);
    }
    static String rome(int a){
        String s="";
        int i,j;
        if (a>=1000){
            i=a/1000;
            for ( j=0;j<i;j++){
                s+="M";
            }
            a-=1000*i;
        }
        if (a>=900){
            s=s+"CM";
            a-=900;
        }
        if (a>=500){
            s=s+"D";
            a-=500;
        }
        if (a>=400){
            s=s+"CD";
            a-=400;
        }
        if (a>=100){
            i=a/100;
            for ( j=0;j<i;j++){
                s=s+"C";
                a-=100*i;
            }
        }
        if (a>=90){
            s=s+"XC";
            a-=50;
        }
        if (a>=50){
            s=s+"L";
            a-=50;
        }
        if (a>=40){
            s=s+"XL";
            a-=40;
        }
        if (a>=10){
            i=a/10;
            for ( j=0;j<i;j++){
                s=s+"X";
            }
            a-=10*i;
        }
        if (a>=5){
            s=s+"V";a-=5;
        }
        if (a>=4){
            s=s+"IV";a-=4;
        }
        for (j=0;j<a;j++){
            s=s+"I";
        }
        return s;
    }
}
