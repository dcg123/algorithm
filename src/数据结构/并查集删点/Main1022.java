package 数据结构.并查集删点;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by user on 2017/10/5.
 */
public class Main1022 {
    static int box[]=new int[1000050];
    static int food[]=new int[1000050];
    static boolean mark[]=new boolean[1000050];
    static int find(int x)
    {
        int f=x;
        while(box[f]!=f)
            f=box[f];
        int i=x;
        while(i!=f)
        {//路径压缩 也就是把根节点的孙直接作为根节点的儿子，减少了搜索次数
            int j=box[i];
            box[i]=f;
            i=j;
        }
        return f;
    }
    static void Merge(int xx,int yy)
    {
        int fx,fy;
        fx=find(xx);
        fy=find(yy);
        if(fx!=fy)
            box[fx]=fy;
    }

    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int n,m;
        char ch;
        int x,y;
        int ans;
        int count=1;
        int t;
        int i;
        while(scanner.hasNext())
        {
            n=scanner.nextInt();
            m=scanner.nextInt();
            scanner.nextLine();
            t=n;
            for(i=0;i<n;i++)
            {food[i]=i;box[i]=i;}
            for(i=0;i<m;i++)
            {
                String str=scanner.nextLine();
                String a[]=str.split(" ");
                if(a[0].equals("U"))
                {
                    x=Integer.valueOf(a[1]);
                    y=Integer.valueOf(a[2]);
                    Merge(food[x],food[y]);//合并就是把箱子的挂钩钩上。
                }
                else
                {
                    x=Integer.valueOf(a[1]);
                    food[x]=t;//删除：把food x拿出来装在t box 里。
                    box[t]=t;//t box 挂钩钩自己
                    t++;
                }
            }
            ans=0;
            Arrays.fill(mark,false);
            for(i=0;i<n;i++)
            {
                if(!mark[find(food[i])])
                {mark[find(food[i])]=true;ans++;}
            }
            System.out.printf("Case #%d: %d\n",count++,ans);
        }
    }
}
