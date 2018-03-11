package 基础dp.背包问题;

import java.util.Scanner;

public class Vijos1059 {

	/**
	 * @param args
	 * XC的儿子小XC最喜欢玩的游戏用积木垒漂亮的城堡。城堡是用一些立方体的积木垒成的，城堡的每一层是一块积木。小XC是一个比他爸爸XC还聪明的孩子，他发现垒城堡的时候，如果下面的积木比上面的积木大，那么城堡便不容易倒。所以他在垒城堡的时候总是遵循这样的规则。
	小XC想把自己垒的城堡送给幼儿园里漂亮的女孩子们，
	这样可以增加他的好感度。为了公平起见，他决定把送给每个女孩子一样高的城堡，
	这样可以避免女孩子们为了获得更漂亮的城堡而引起争执。
	可是他发现自己在垒城堡的时候并没有预先考虑到这一点。所以他现在要改造城堡。
	由于他没有多余的积木了，他灵机一动，想出了一个巧妙的改造方案。
	他决定从每一个城堡中挪去一些积木，使得最终每座城堡都一样高。
	为了使他的城堡更雄伟，他觉得应该使最后的城堡都尽可能的高。
	 */
	static int MAX_N=100+2;
	static int a[]=new int[MAX_N];
	static int dp[]=new int[10010];
	static int f[]=new int[10010];
	static int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		n=scan.nextInt();
		int t=0;
		for(int i=0;i<n;i++){
			init();
			int maxv=0;
			while(true){
				int b=scan.nextInt();
				if(b==-1){
					break;
				}
				a[t++]=b;
				maxv+=b;
			}
			for(int j=0;j<t;j++){
				for(int k=maxv-a[i];k>=0;k--){
					if( (dp[k])==1 ) dp[k+a[i]]=1;  
				}
			}
			for(int j=0;j<=maxv;j++){
				if(dp[j]==1){
					f[j]++;
				}
			}
		}
		for(int i=10005;i>=0;i--)  
	    {  
	        if (f[i]==n)  
	        {  
	            System.out.println(i);
	            break;  
	        }  
	    }  
	}
	private static void init() {
		// TODO Auto-generated method stub
		for(int i=0;i<MAX_N;i++){
			dp[i]=0;
			f[i]=0;
		}
		dp[0]=1;
	}

}
