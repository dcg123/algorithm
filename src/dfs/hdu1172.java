package dfs;

import java.util.Scanner;
import java.util.TreeSet;

public class hdu1172 {

	/**
	 * @param args
	 * 猜数字游戏是gameboy最喜欢的游戏之一。游戏的规则是这样的：
	 * 计算机随机产生一个四位数，然后玩家猜这个四位数是什么。
	 * 每猜一个数，计算机都会告诉玩家猜对几个数字，其中有几个数字在正确的位置上。
	比如计算机随机产生的数字为1122。如果玩家猜1234,
	因为1,2这两个数字同时存在于这两个数中，
	而且1在这两个数中的位置是相同的，所以计算机会告诉玩家猜对了2个数字，
	其中一个在正确的位置。如果玩家猜1111,那么计算机会告诉他猜对2个数字，有2个在正确的位置。
	现在给你一段gameboy与计算机的对话过程，你的任务是根据这段对话确定这个四位数是什么。
	 */
	static String[] s = new String[102];
	static int count[] = new int[102];
	static int ans[] = new int[102];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n;
		while (scan.hasNext()) {
			n = scan.nextInt();
			if (n == 0) {
				break;
			}
			scan.nextLine();
			for (int i = 0; i < n; i++) {
				String str = scan.nextLine();
				String ss[] = str.split(" ");
				s[i] = ss[0];
				count[i] = Integer.valueOf(ss[1]);
				ans[i] = Integer.valueOf(ss[2]);
			}
			int max = 0, j, i,x=0;
			boolean flag=false;
			for (i = 1000; i <= 9999; i++) {
				for (j = 0; j < n; j++) {
					flag=ok(i,j);
					if(!flag){
						break;
					}
				}
				if(flag){
					x++;
					max=i;
				}
				
			}
			if (x==1) {
				System.out.println(max);
			} else
				System.out.println("Not sure");
		}
	}

	private static boolean ok(int sum, int j) {
		// TODO Auto-generated method stub
		boolean mark[]=new boolean[5];
		String ss=String.valueOf(sum);
		String sss=s[j];
		int x=0;
		int y=0;
		for(int i=0;i<4;i++){
			for(int k=0;k<4;k++){
				if(ss.charAt(i)==sss.charAt(k)&&!mark[k]){
					mark[k]=true;
					x++;
					break;
				}
			}
		
		}
		for(int i=0;i<4;i++){
			if(ss.charAt(i)==sss.charAt(i)){
				
				y++;
			}
		}
		if(count[j]!=x){
			return false;
		}else if(ans[j]!=y){
			return false;
		}
		return true;
	}

}
