package 尺取法;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class poj3320 {

	/**
	 * @param args
     * 题目大意：
    XXX要准备考试，书总共有P页，第i页恰好有一个知识点ai，书中的同一个知识点可能会被多次提到，所以他希望看其中连续的一些页的书来把所有的知识点都给看完。。
    其实页数可以看作连续的序列，然后就是要求出一个子序列，子序列的要求的包涵所有知识点都有的页数，且子序列的长度要最短。
	 */
	static int n;
	static Set<Integer> set = new HashSet<Integer>() ; 
	static int a[]=new int[1000000+2];
	static Map<Integer,Integer> map=new HashMap<Integer, Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		n=scan.nextInt();
		for(int i = 0 ; i < n ; i++){  
            set.add(a[i] = scan.nextInt() ) ;  
        }  
		int  size = set.size() ;  //���㲻֪ͬʶ��ĸ���
		int start = 0 , end = 0 , sum = 0 ;  
        int res = n ; 
        for(;;){  
            while(end < n && sum < size){  
                Integer cnt = map.get(a[end]) ;  
                if(cnt == null){  
                    sum++ ;  
                    map.put(a[end] , 1) ;  
                }  
                else map.put(a[end] , cnt+1) ;  
                end++ ;  
            }  
            if(sum < size) break ;   
            res = Math.min(end - start , res) ;  
            int cnt = map.get(a[start]) ;   
            if(cnt == 1){  
                map.remove(a[start]) ;  
                sum-- ;  
            }  
            else map.put(a[start] , cnt-1) ;  
            start++ ;  
        }
        System.out.println(res) ;
	}

}
