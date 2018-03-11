package 尺取法;

import java.util.Scanner;

public class poj3061 {

	/**
	 * @param args
	 * 题目大意：
	给出N个数字，每个数字不大于10000，给出一个S，
	在N个数字中挑选出连续的a的数字，使这a个数字的和大于或等于S。请问这个a最小是几？
	 */
	static int n,s;
	static int map[]=new int[100000+3];
	static int sum[]=new int[100000+3];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int t=scan.nextInt();
		while(t>0){
			n=scan.nextInt();
			s=scan.nextInt();
			for(int i=0;i<n;i++){
				map[i]=scan.nextInt();
			}
			sovle();
			t--;
		}
		
	}
	private static void sovle() {
		// TODO Auto-generated method stub
		int res=n+1;
		int ss=0,t=0,sum=0;
		for(;;){
			while(t<n&&sum<s){
				sum+=map[t++];
			}
			if(sum<s){
				break;
			}
			res=Math.min(res, t-ss);
			sum-=map[ss++];
		}
		if(res>n){
			res=0;
		}
		System.out.println(res);
	}

}
