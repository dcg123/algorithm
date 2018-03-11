package 字符串.Manacher算法;



        import java.util.Scanner;

public class Manacher算法 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        int maxn=1000010;
        String str=scan.next();
        //转换后的字符
        char temp[]=new char[str.length()*2+4];

        int Len[]=new int[str.length()*2+4];
        //转换原始串
        int len=INIT(str,temp);

        //Manacher算法计算过程
        int length=MANACHER(str,len,Len);
        System.out.println(length);
    }

    private static int MANACHER(String str, int len, int[] Len) {
        // TODO Auto-generated method stub
        char st[]=str.toCharArray();
        int mx=0,ans=0,po=0;//mx即为当前计算回文串最右边字符的最大值
        for(int i=1;i<=len;i++){
            if(mx>i){
                Len[i]=min(mx-i,Len[2*po-i]);//在Len[j]和mx-i中取个小
            }
            else
                Len[i]=1;//如果i>=mx，要从头开始匹配
            while(st[i-Len[i]]==st[i+Len[i]])
                Len[i]++;
            if(Len[i]+i>mx)//若新计算的回文串右端点位置大于mx，要更新po和mx的值
            {
                mx=Len[i]+i;
                po=i;
            }
            ans=max(ans,Len[i]);

        }
        return ans-1;//返回Len[i]中的最大值-1即为原串的最长回文子串额长度
    }

    private static int max(int ans, int i) {
        // TODO Auto-generated method stub
        return ans>i?ans:i;
    }

    private static int min(int i, int j) {
        // TODO Auto-generated method stub
        return i<j?i:j;
    }

    private static int INIT(String str, char[] tmp) {
        // TODO Auto-generated method stub
        int len=str.length();
        tmp[0]='@';//字符串开头增加一个特殊字符，防止越界
        for(int i=1;i<=2*len;i+=2){
            tmp[i]='#';
            tmp[i+1]=str.charAt(i/2);
        }
        tmp[2*len+1]='#';
        tmp[2*len+2]='$';//字符串结尾加一个字符，防止越界
        tmp[2*len+3]='0';
        return 2*len+1;//返回转换字符串的长度
    }

}
