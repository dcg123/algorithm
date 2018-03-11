package 数论.素数;

public class prime {

	/**
	 * @param args
	 */
	private static final int MAXN=1000010;
	private static final boolean notprime[]=new boolean[MAXN];
	private static final int prime[]=new int[MAXN];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		notprime[0]=true;
		notprime[1]=true;
		for(int i=2;i<MAXN;i++){
			if(!notprime[i]){
				if(i>MAXN/i){
					continue;
				}
				for(int j=i*i;j<MAXN;j++){
					notprime[j]=true;
				}
			}
		}
		//查找出小于等于MAXN的素数 生成连续素数表
		getPrime();
	}
	private static void getPrime() {
		// TODO Auto-generated method stub
		for(int i=2;i<MAXN;i++){
			if(prime[i]==0){
				prime[++prime[0]]=i;
			}
		}
	}

}
