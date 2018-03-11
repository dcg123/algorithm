package 图论.极大强连通分量;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by user on 2017/10/14.
 */
public class poj2186 {
    static int maxn=12000;
    static Vector<Integer>tu[]=new Vector[maxn];
    static Vector<Integer>lt[]=new Vector[maxn];
    static int n,m,lts=0;
    static int js=0;
    static int dfn[]=new int[maxn],low[]=new int[maxn];
    static int zhan[]=new int[maxn],top=0;
    static boolean isins[]=new boolean[maxn];
    static int num[]=new int[maxn];//num[i]表示i点所在的强连通分量的编号
    static int d[]=new int[maxn];
    static void tarjan(int i)//hhhh
    {
        int j;
        dfn[i]=low[i]=++js;
        isins[i]=true;
        zhan[top++]=i;
        for(j=0;j<tu[i].size();j++)
        {
            int tp=tu[i].get(j);
            if(dfn[tp]==-1){
                tarjan(tp);
                low[i]=Math.min(low[i],low[tp]);
            }

            else if(isins[tp])
                low[i]=Math.min(low[i],dfn[tp]);
        }
        if(dfn[i]==low[i])
        {
            lts++;
            do{
                j=zhan[--top];
                isins[j]=false;
                lt[lts].add(j);
                num[j]=lts;//j点所在的强连通分量的编号为lts
            }while(i!=j);
        }
    }
    static void solve(int n)
    {
        Arrays.fill(dfn,-1);
        Arrays.fill(low,-1);
        Arrays.fill(zhan,-1);
        Arrays.fill(isins,false);
        for(int i=0;i<n;i++)
            if(dfn[i]==-1)
                tarjan(i);
    }

    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        m=scanner.nextInt();
        scanner.nextLine();
        for (int i=0;i<=n;i++){
            tu[i]=new Vector<Integer>();
            lt[i]=new Vector<Integer>();
        }
        for(int i=1;i<=m;i++)
        {
            String str=scanner.nextLine();
            String a[]=str.split(" ");
            int x,y;
            x=Integer.valueOf(a[0]);
            y=Integer.valueOf(a[1]);
            tu[x-1].add(y-1);//我从0开始啊
        }
        solve(n);
        for(int i=0;i<n;i++)
            for(int j=0;j<tu[i].size();j++)
            {
                int t=tu[i].get(j);
                if(num[i]!=num[t])//如果i点与他指向的点不在同一个强连通分量中
                    d[num[i]]++;//i点所在的强连通分量的出度+1
            }
        int pos=-1;
        int cnt=0;
        for(int i=1;i<=lts;i++)
            if(d[i]==0)//找到出度为0的强连通分量
            {
                cnt++;
                pos=i;
            }
        if(cnt==1) System.out.println(lt[pos].size());//如果只有一个出度为0的强连通分量，那么这个强连通分量的长度即答案
        else{
            System.out.println("0");
        }
    }

}
