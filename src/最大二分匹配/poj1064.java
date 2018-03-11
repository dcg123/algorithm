package 最大二分匹配;

import java.util.Scanner;

public class poj1064 {

	/**
	 * @param args
	 * 题目大意：有n条绳子，长度分别为L[i]。如果从他们中切割出k条长度相同的绳子的话，这k条绳子每条最长能有多长？’
	 * （答案保留小数点后两位，规定1单位长度的绳子最多可以切割成100份）。
	 */
	static int n,k;
	static double a[]=new double [10000+2];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		n=scan.nextInt();
		k=scan.nextInt();
		for(int i=0;i<n;i++){
			a[i]=scan.nextDouble();
		}
		solve();
	}
	private static void solve() {
		// TODO Auto-generated method stub
		//��ʼ����Χ
		double lb=0;
		double ub=Double.MAX_VALUE;
		//�ظ�ѭ�� ֱ���ҵ���
		for(int i=0;i<=100;i++){
			double mid=(lb+ub)/2;
			if(C(mid)){
				lb=mid;
			}else{
				ub=mid;
			}
		}
		System.out.printf("%.2f",ub);
	}
	private static boolean C(double x) {
		// TODO Auto-generated method stub
		int num=0;
		for(int i=0;i<n;i++){
			num+=(int)(a[i]/k);
		}
		return num>=k;
	}

}
