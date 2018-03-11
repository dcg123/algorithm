package 最大二分匹配.二分图最优匹配;

import java.util.Scanner;

public class km {

	/**
	 * @param args
	 */
	static int n,m,ans;
	static int w[][]=new int[1000][1000];
	static int line[]=new int[1000];
	static int usex[]=new int[1000];
	static int usey[]=new int[1000];
	static int cx[]=new int[1000],cy[]=new int[1000];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		n=scan.nextInt();
		 for (int i=1;i<=n;i++){
		     int d=0;
		     for (int j=1;j<=n;j++){
		    	 w[i][j]=scan.nextInt();
		      d=Math.max(d,w[i][j]);   //�˴�˳���ʼ����ߵ�Ķ��� 
		       }
		    cx[i]=d;
		    }
		System.out.println(km());
	}

	private static int km() {
		// TODO Auto-generated method stub
		for(int i=1;i<=n;i++){
			while(true){
				int d=Integer.MAX_VALUE;
				 init();
			        if (find(i)) break;  //ֱ���ɹ�ƥ��Ż���һ����ƥ�� 
			        for (int j=1;j<=n;j++)
			            if (usex[j]!=0)
			             for (int k=1;k<=m;k++)
			             if (usey[k]==0) d=Math.min(d,cx[j]+cy[k]-w[j][k]);  //����dֵ 
			        if (d==Integer.MAX_VALUE) return -1;  
			        for (int j=1;j<=n;j++)
			         if (usex[j]!=0) cx[j]-=d;   
			        for (int j=1;j<=m;j++)
			         if (usey[j]!=0) cy[j]+=d;     //����±� 
			}
		}
		 ans=0;
		    for (int i=1;i<=m;i++)
		     ans+=w[line[i]][i];
		    System.out.println(ans);
		    return ans;
	}

	private static boolean find(int x) {
		// TODO Auto-generated method stub
		usex[x]=1;
	    for (int i=1;i<=m;i++){
	        if ((usey[i]==0)&&(cx[x]+cy[i]==w[x][i])){   //��������δ���ʹ�����������ͼ����ı� 
	            usey[i]=1;
	            if ((line[i]==0)||find(line[i])){   //��������δƥ�����ƥ����ܸ��� 
	                line[i]=x;
	                return true;
	            }
	        }
	    }
	    return false;
		
	}

	private static void init() {
		// TODO Auto-generated method stub
		for(int i=0;i<1000;i++){
			usex[i]=0;
			usey[i]=0;
		}
	}

}
