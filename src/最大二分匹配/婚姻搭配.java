package 最大二分匹配;

import java.util.Stack;


public class 婚姻搭配 {

	/**
	 * @param args
	 */
	static int NUM=4;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int manArray[][] ={{2,3,1,0},{2,1,3,0},{0,2,3,1},{1,3,2,0}};
		int ladayArray[][] = {{0,3,2,1},{0,1,2,3},{0,2,3,1},{1,0,3,2}};
		int manPerfer[]=new int[NUM];//每位男生选中的女生；
		int manStartPos[]=new int[NUM];//记录每位男生选中的是心目中第几位女生
		int ladayNow[]=new int[NUM];//女生对应的男生;
		//吧ladayNow 标记为-1 表示还没有人对她们表白
		for(int i=0;i<NUM;i++){
			ladayNow[i]=-1;
		}
		Stack<Integer> stack=new Stack<Integer>();//还处于单身的男士
		//进行第一轮迭代 每个男士都选择自己名单上排在首位的女生
		for(int i=0;i<NUM;i++){
			ChoosePartener(stack,i,manArray,ladayArray,manPerfer,manStartPos,ladayNow);
		}
		//继续迭代 当堆栈为空时 结束
		while(stack.size()!=0){
			int manPos = stack.pop();
			ChoosePartener(stack,manPos,manArray,ladayArray,manPerfer,manStartPos,ladayNow);
		}
		for(int i=0;i<NUM;i++){
			System.out.println(i+"-->"+manPerfer[i]);
		}
	}
	private static void ChoosePartener(Stack<Integer> stack, int manPos,
									   int[][] manArray, int[][] ladayArray, int[] manPerfer,
									   int[] manStartPos, int[] ladayNow) {
		// TODO Auto-generated method stub
		//选中自己名单上首个女生 并表白
		int perferLaday =manArray[manPos][manStartPos[manPos]];
		//如果该女孩没有被表白
		if(ladayNow[perferLaday]==-1){
			//接受男士的表白
			ladayNow[perferLaday]=manPos;
			manPerfer[manPos]=perferLaday;
		}
		//如果已经有人表白了 继续表白 判断女生觉得你是否比他现任还符合自己的心意
		else{
			//获取女方现任在心中的排名
			int oldPos =GetPositionFromLaday(ladayArray,perferLaday,ladayNow[perferLaday]);
			//获取当前表白男生在女生心中的排名
			int newPos =GetPositionFromLaday(ladayArray,perferLaday,manPos);
			if(oldPos<newPos){//表明女生对现任男生更满意
				manStartPos[manPos]++;//说明该女生更喜欢现在拥有的，只有选取心目中下一位了，选心目中第二位
				//加入单身行列
				stack.push(manPos);
			}else{
				//换男朋友
				//被甩男友恢复自由身 被甩男士只有选取心目中下一位女生
				manStartPos[ladayNow[perferLaday]]++;
				//加入单身行列
				stack.push(ladayNow[perferLaday]);
				//将表白男生改为现任
				ladayNow[perferLaday]=manPos;
				manPerfer[manPos]=perferLaday;
			}
		}

	}
	private static int GetPositionFromLaday(int[][] ladayArray,
											int perferLaday, int man) {
		// TODO Auto-generated method stub
		for(int i=0;i<NUM;i++){
			if(ladayArray[perferLaday][i]==man){
				return i;
			}
		}
		return -1;
	}

}
