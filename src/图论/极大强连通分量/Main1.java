package 图论.极大强连通分量;

import java.util.*;

/**
 * Created by user on 2017/9/30.
 */
public class Main1 {
    private static int numOfNode;
    private static List<ArrayList<Integer>> graph;//图
    private static List<ArrayList<Integer>> result;//保存极大强连通图
    private static boolean inStack[];//节点是否在站内
    private static Stack<Integer>stack;
    private static int dfn[];
    private static int low[];
    private static int time;

    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        numOfNode=6;
        graph=new ArrayList<ArrayList<Integer>>();
        for (int i=0;i<numOfNode;i++){
            graph.add(new ArrayList<Integer>());
        }
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(3);
        graph.get(2).add(3);
        graph.get(2).add(4);
        graph.get(3).add(0);
        graph.get(3).add(5);
        graph.get(4).add(5);
        //求极大联通子图

        List< ArrayList<Integer> > result1=Tarjan();
        //打印结果
        for(int i=0;i<result.size();i++){
            for(int j=0;j<result.get(i).size();j++){
                System.out.print(result.get(i).get(j)+" ");
            }
            System.out.println();
        }

    }

    private static List< ArrayList<Integer>>  Tarjan() {
        time=0;
        inStack=new boolean[numOfNode];
        stack=new Stack<Integer>();
        dfn=new int[numOfNode];
        low=new int[numOfNode];
        Arrays.fill(dfn,-1);
        Arrays.fill(low,-1);
        result= new ArrayList<ArrayList<Integer>>();
        for (int i=0;i<numOfNode;i++){
            if (dfn[i]==-1){
                dfs(i);
            }
        }
        return result;
    }

    private static void dfs(int current) {
        dfn[current]=low[current]=time++;
        inStack[current]=true;
        stack.push(current);
        for (int i=0;i<graph.get(current).size();i++){
            int next=graph.get(current).get(i);
            if (dfn[next]==-1){//表示没有被访问过
                dfs(next);
                low[current]=Math.min(low[current],dfn[next]);
            }else if (inStack[next]){
                low[current]=Math.min(low[current], dfn[next]);
            }
        }
        if(low[current]==dfn[current]){
            ArrayList<Integer> temp =new ArrayList<Integer>();
            int j = -1;
            while(current!=j){
                j = stack.pop();
                inStack[j]=false;
                temp.add(j);
            }
            result.add(temp);
        }
    }
}
