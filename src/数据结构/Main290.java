package 数据结构;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by user on 2017/10/5.
 */
public class Main290 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        scanner.nextLine();
        HashMap<String,Integer> map=new HashMap<String, Integer>();
        String smax = null;
        String s = null;
        int max = 1;
        for (int i=0;i<n;i++){
            s = scanner.nextLine();
            if (map.get(s)==null){
                map.put(s,1);
            }else {
                int ans=map.get(s)+1;
                map.put(s,ans);
                if (max < ans) {
                    max = ans;
                    smax = s;
                }
            }
        }
        System.out.println(smax+" "+max);
    }
}
