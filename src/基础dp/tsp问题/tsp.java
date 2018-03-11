package 基础dp.tsp问题;

import java.util.Scanner;

public class tsp {

	/**
	 * @param args
	 */
	static int s,N, init_point;
	static double x[] = new double[20];
	static double y[] = new double[20];
	static double dp[][] = new double[20][20];
	static double dis[][] = new double[1048577][20];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t > 0) {
			N = scan.nextInt();
			for (int i = 0; i < N; i++) {
				x[i] = scan.nextDouble();
				y[i] = scan.nextDouble();
			}
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++) {
					dp[i][j] = Math.sqrt(Math.pow((x[i] - x[j]), 2)
							+ Math.pow((y[i] - y[j]), 2));
					// �����������еľ���
				}

			for (int i = 0; i < Math.pow(2, N); i++)
				for (int j = 0; j < N; j++)
					dis[i][j] = -1;// ȥ�������ʼ��
			init_point = 0;
			s = 0;
			for (int i = 1; i < N; i++)
				s = s | (1 << i);// ��1��ʼ����֤��ʼ��û����S����
			double distance = go(s, init_point);
			t--;
		}
	}

	private static double go(int s, int init) {
		// TODO Auto-generated method stub
		if(dis[s][init]!=-1) return dis[s][init];//ȥ�� 
	    if(s==(1<<(N-1))) return dp[N-1][init];//ֻ�����һ���㷵�� 
	    double minlen=100000;
	    for(int i=0;i<N-1;i++)//ֻ����1��n-2���в��� 
	    {
	        if((s&(1<<i))==0)//���i����s���Ҳ�Ϊ������ 
	        {
	            if(go(s&(~(1<<i)),i)+dp[i][init]<minlen)
	                minlen=go(s&(~(1<<i)),i)+dp[i][init];
	        } 
	    } 
	    return dis[s][init]=minlen;
	}

}
