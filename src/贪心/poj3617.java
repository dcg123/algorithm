package 贪心;

import java.util.Scanner;

public class poj3617 {

	/**
	 * @param args
	 *
	中文意思：
	每次都可以从字符串的首部或者尾部提取字母，使得最后的字符串的字典序最小。

	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int n;
		String str="";
		String s="";
		n=scan.nextInt();
		for(int i=0;i<n;i++){
			str+=scan.next();
		}
		char a[]=str.toCharArray();
		int begin=0;
		int end=a.length-1;
		int count=0;
		while(begin<=end){
			boolean left=false;
			for(int i=0;i+begin<=end;i++){
				if(a[begin+i]<a[end-i]){
					left=true;
					count++;
					break;
				}else if(a[begin+i]>a[end-i]){
					left=false;
					count++;
					break;
				}
			}
			if(left){
				System.out.print(a[begin++]);
			}else{
				System.out.print(a[end--]);
			}
			if(count%80==0){
				System.out.println();
			}
		}
		
	}

}
