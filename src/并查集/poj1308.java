package 并查集;

import java.util.Scanner;

public class poj1308 {

	/**
	 * @param args
	 * 这道题要求我们判断这些case的数字

	连接起来是否构成一棵树。一棵树只有一个树根，树当中的两个父节点不能含有相同的儿子。然后我就开始写

	了，用的依然是并查集，但是看了下数据感觉不好输入，-1，-1是结束输入，0，0是结束一个case，所以每

	个case开始的第一组数据单独输入，后面的数据用while循环判断是否是0，0来输入。问题依然有，不知道哪些

	树出现了，所以增加了一个标记数组，貌似这是第一次用布尔数...
	 */
	static int p[]=new int[105];
	static int n,m;
	static boolean v[]=new boolean [105];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int x,y,t=1,frist;
		while(scan.hasNext()){
			x=scan.nextInt();
			y=scan.nextInt();
			if(x==-1&&y==-1){
				break;
			}
			if(x==0&&y==0){//����Ҳ����  ����Ҳ����...
				System.out.println("Case "+t+++" is a tree.");
			}
			init();
			v[x]=v[y]=true;
			frist=x;
			boolean tree=true;
			if(x==y){
				tree=false;
			}else{
				join(x,y);//�ϲ�
			}
			while(scan.hasNext()){
				x=scan.nextInt();
				y=scan.nextInt();
				if(x==0&&y==0){
					break;
				}
				v[x]=v[y]=true;
				if(find(x)==find(y)){
					tree=false;//����¼���ĵ� ���ڵ���� �����γɻ�
				}
				join(x,y);
			}
			//���ֻ��һ������
			for(int i=1;i<105;i++){
				if(v[i]&&find(i)!=find(frist)){
					tree=false;
					break;
				}
			}
			if(tree){
				System.out.println("Case "+t+++" is a tree.");
			}else{
				System.out.println("Case "+t+++" is not a tree.");
			}
		}
	}

	private static void join(int x, int y) {
		// TODO Auto-generated method stub
		int k1=find(x);
		int k2=find(y);
		if(k1==k2)return;
		p[k1]=k2;
	}

	private static int find(int x) {
		// TODO Auto-generated method stub
		int r=x;
		while(p[r]!=r){
			r=p[r];
		}
		return r;
	}

	private static void init() {
		// TODO Auto-generated method stub
		for(int i=0;i<105;i++){
			p[i]=i;
			v[i]=false;
		}
	}

}
