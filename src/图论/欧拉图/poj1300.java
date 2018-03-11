package 图论.欧拉图;

import java.util.Scanner;


public class poj1300 {

	/**
	 * @param args
	 * 题目描述：
	你是一座大庄园的管家。庄园有很多房间，编号为0、1、2、3，...。你的主人是一个心不在
	焉的人，经常沿着走廊随意地把房间的门打开。多年来，你掌握了一个诀窍：沿着一个通道，穿
	过这些大房间，并把房门关上。你的问题是能否找到一条路径经过所有开着门的房间，并使得：
	1) 通过门后立即把门关上；
	2) 关上了的门不再打开；
	3) 最后回到你自己的房间（房间0），并且所有的门都已经关闭了。

	在本题中，给定房间列表，及连通房间的、开着的门，并给定一个起始房间，判断是否存在
	这样的一条路径。不需要输出这样的路径，只需判断是否存在。假定任意两个房间之间都是连通
	的（可能需要经过其他房间）。
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		while(true){
			String s=scan.next();
			if(s.equals("ENDOFINPUT")){
				break;
			}
			int loc=scan.nextInt();
			int n=scan.nextInt();
			scan.nextLine();//���ջس���
			int [] door=new int[n];
			int doors=0;
			for(int i=0;i<n;i++){
				s=scan.nextLine();//����һ���ַ�
				if(s.equals(""))continue;
				String ss[]=s.split(" ");
				for(int j=0;j<ss.length;j++){//���ݱ߼���ÿ����ĳ��Ⱥ����
					int u=Integer.parseInt(ss[j]);
					door[i]++;
					door[u]++;
					doors++;//������ʼ��ر��ŵ�����
				}
			}
			s=scan.next();//����end
			int odd=0,even=0;
			for(int i=0;i<n;i++){
				if(door[i]%2==0){
					even++;//ż��
				}
				else{
					odd++;//����
				}
			}
			if(odd==0&&loc==0){//ȫΪż�� ���� �����ص�Ϊ0 ���ܻص�0��
				System.out.println("YES "+doors);
			}else if(odd==2&&loc!=0&&door[loc]%2==1&&door[0]%2==1){//��������Ϊ2 ���ҳ����㲻��Ϊ0 ��������յ�0��Ϊ����
				System.out.println("YES "+doors);
			}else{
				System.out.println("NO");
			}
			
		}
	}

}
