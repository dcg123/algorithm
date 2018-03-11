package 并查集;

import java.util.Scanner;

public class poj1611 {

	/**
	 * @param args
	 * 严重急性呼吸系统综合症( SARS), 一种原因不明的非典型性肺炎,从2003年3月中旬开始被认为是全球威胁。为了减少传播给别人的机会, 最好的策略是隔离可能的患者。
	在Not-Spreading-Your-Sickness大学( NSYSU), 有许多学生团体。同一组的学生经常彼此相通,一个学生可以同时加入几个小组。为了防止非典的传播,NSYSU收集了所有学生团体的成员名单。他们的标准操作程序(SOP)如下：
	一旦一组中有一个可能的患者, 组内的所有成员就都是可能的患者。
	然而,他们发现当一个学生被确认为可能的患者后不容易识别所有可能的患者。你的工作是编写一个程序, 发现所有可能的患者。
	 */
	static int n,m;
	static int p[]=new int[30000+2];
	static int a[]=new int[30001];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		while(scan.hasNext()){
			int sum=0;
			n=scan.nextInt();
			m=scan.nextInt();
			if(n==0&&m==0){
				break;
			}
			for(int i=0;i<n;i++){
				p[i]=i;
			}
			for(int i=0;i<m;i++){
				int k=scan.nextInt();
				int s=scan.nextInt();
				if(k>=1){
					for(int j=1;j<k;j++){
						a[j]=scan.nextInt();
						join(s,a[j]);
					}
				}
			}
			for(int i=0;i<n;i++){
				if(find(i)==p[0]){
					sum++;
				}
			}
			System.out.println(sum);
		}
		
	}
	private static void join(int a, int b) {
		// TODO Auto-generated method stub
		int k1=find(a);
		int k2=find(b);
		if(k1!=k2) p[k1]=k2 ;
		
	}
	private static int find(int a) {
		// TODO Auto-generated method stub
		int r=a;
		while(p[r]!=r){
			r=p[r];
		}
		return r;
	}

}
