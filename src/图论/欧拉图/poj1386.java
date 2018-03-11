package 图论.欧拉图;

import java.util.Scanner;


public class poj1386 {

	/**
	 * @param args
	 * 题意：给你n个单词，要求这些单词相连，
	 * 要求是前面的字母的尾字母和后面单词的头字母相同，问你这n个单词能不能全部连起来，
	 * 可以连成一条链或者连成一个环

	另外单词只有小写字母。很容易想到，顶点集合就是26个小写字母，用1到26来表示，一个单词的首字母和尾字母就是一条有向边，注意是有向边，因为单词是不能倒回来的

	其实就是问你这个图是否存在欧拉道路（一条链的情况）或者欧拉回路（环的情况），反正存在欧拉路就是成功的，否则就是失败
	 */
	 static int[] arr=new int[26];
	 static int[] cin=new int[26];
	 static int[] cout=new int[26];
	 static boolean[] used=new boolean[26];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int y=scan.nextInt();
		while((y--)!=0){
			int n=scan.nextInt();
			scan.nextLine();
			for(int i=0;i<26;i++){
				arr[i]=i;
				cin[i]=0;
				cout[i]=0;
				used[i]=false;
			}
			for(int i=0;i<n;i++){
				String s=scan.nextLine();
				int u=s.charAt(0)-'a';
				int v=s.charAt(s.length()-1)-'a';
				cin[u]++;//���
				cout[v]++;//����
				used[u]=true;
				used[v]=true;
				union(u,v);//��û�����ӵ�������������
			}
			boolean euler=true;
			int one=0,none=0;
			for(int i=0;i<26;i++){
				if(!used[i])continue;
				if(Math.abs(cin[i]-cout[i])>1){//���Ⱥ���ȵĲ����1 �޷�����ŷ��·��
					euler=false;
					break;
				}
				if((cin[i]-cout[i])==1){//��Ⱥͳ���������һ ֻ����һ���� �ĵ�Ϊ��ʼ��
					one++;
					if(one>1){
						euler=false;
						break;
					}
				}
				if((cout[i]-cin[i])==1){//���Ⱥ����������һ ֻ����һ���� �ĵ�Ϊ�յ�
					none++;
					if(none>1){
						euler=false;
						break;
					}
				}
			}
			if(one!=none)euler=false;//������ ֻ��Ϊ����
			int yy=-1;
			for(int i=0;i<26;i++){//���������ж���ȳ���������ĸ��� ����Ҫ�жϸ�ͼ�Ƿ���ͨ ���鼯�鿴��ͼ�Ƿ���ͨ �����ͨ ÿ����Ķ��㶼Ӧ��һ��
				if(!used[i])continue;
				if(yy==-1){
					yy=find(i);
				}
				else if(yy!=find(i)){
					euler=false;
					break;
				}
			}
			if(!euler){
				System.out.println("The door cannot be opened.");
			}else{
				System.out.println("Ordering is possible.");
			}
		}
	}
	private static void union(int u, int v) {
		// TODO Auto-generated method stub
		int x=find(u);
		int y=find(v);
		if(x==y)
			return;
		if(x>y){
			arr[x]=y;
		}else{
			arr[y]=x;
		}
	}
	private static int find(int a) {
		// TODO Auto-generated method stub
		int b=a;
		while(arr[a]!=b){
			b=arr[b];
		}
		return arr[a]=b;
	}

}
