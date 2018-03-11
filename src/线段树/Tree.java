package 线段树;

import java.util.Scanner;

public class Tree {

    /**
     * @param args
     */
    class Node{
        int value;
        int left,right;
    }
    static int MAX = 1000003;
    static Node node[]=new Node[MAX];
    static int father[]=new int[MAX];//每个点对应的结构体数组下标
    static Tree tr=new Tree();
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        int i = 0,left = 0,right = 0;
        BuildTree(i,left,right);
    }
    //创建线段树
    private static void BuildTree(int i, int left, int right) {
        //以left right为区间建立一个以i为祖先的线段树 i为数组下标
        // TODO Auto-generated method stub
        node[i]=tr.new Node();
        node[i].left=left;
        node[i].right=right;
        node[i].value=0;
        if(left==right){
            father[left]=i;
            return ;
        }
        //递归 分别建立左树 和右树
        BuildTree(i<<1,left,(int)((right+left)/2.0));
        BuildTree((i<<1) + 1, (int)( (right+left) / 2.0) + 1, right);
    }
    //单点更新 线段树
    private static void UpdataTree(int ri){
        if (ri == 1)return; // 向上已经找到了祖先（整个线段树的祖先结点 对应的下标为1）
        int fi = ri / 2;        // ri 的父结点
        int a = node[fi<<1].value; // 该父结点的两个孩子结点（左）
        int b = node[(fi<<1)+1].value; // 右
        node[fi].value = (a > b)?(a):(b);    // 更新这个父结点（从两个孩子结点中挑个大的）
        UpdataTree(ri/2);       // 递归更新，由父结点往上找
    }

}
