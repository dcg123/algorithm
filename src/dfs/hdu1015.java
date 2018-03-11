package dfs;

import java.util.Scanner;


public class hdu1015 {

	/**
	 * @param args
	 * 题意：输入一个数target 和一个字符串 s，
	 * 在字符串 s 找出一个由5个字符组成的最大字符串使得v - w^2 + x^3 - y^4 + z^5 = target ；
	 */
	static int MAX_N=30;
	static boolean vis[]=new boolean[MAX_N];
	static char t[]=new char[MAX_N];
	static char ans[]=new char[MAX_N];
	static boolean flag=false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		while(scan.hasNext()){
			String str=scan.nextLine();
			String b[]=str.split(" ");
			if(b[0].equals("0")){
				break;
			}
			char a[]=b[1].toCharArray();
			init();
			int k=0;
			flag=false;
			dfs(Integer.valueOf(b[0]),a,k);
			if(flag){
				for(int i=0;i<5;i++){
					System.out.print(ans[i]);
				}
				System.out.println();
			}else{
				System.out.println("no solution");
			}
		}
	}
	private static void dfs(int sum, char[] a,int k) {
		// TODO Auto-generated method stub
		if(k==5){
			int temp=(int) (a[t[0]-'A']-Math.pow(a[t[1]-'A'],2)+Math.pow(a[t[2]-'A'],3)-Math.pow(a[t[3]-'A'],4)+Math.pow(a[t[4]-'A'],5));
			if(temp==sum&&bijiao(t,ans)){
				flag=true;
				for(int i=0;i<5;i++){
					ans[i]=t[i];
				}
			}
			return ;
		}
		for(int i=0;i<5;i++){
			if(!vis[a[i]-'A']){
				t[k]=a[i];
				vis[a[i]-'A']=true;
				dfs(sum,a,k+1);
				vis[a[i]-'A']=false;
			}
		}
	}
	private static boolean bijiao(char[] t2, char[] ans2) {
		// TODO Auto-generated method stub
		for(int i=0;i<5;i++){
			if(t2[i]>ans2[i]){
				return true;
			}else if(t2[i]==ans2[i]){
				continue;
			}else{
				return false;
			}
		}
		return false;
	}
	private static void init() {
		// TODO Auto-generated method stub
		for(int i=0;i<MAX_N;i++){
			vis[i]=false;
		}
	}

}
