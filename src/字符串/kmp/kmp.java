package 字符串.kmp;



        import java.util.Scanner;

public class kmp {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        String str1=scan.next();
        String str2=scan.next();
        int next[]=new int[str2.length()];
        calculateNext(next,str2);

        //进行kmp匹配
        /**
         * 匹配思想
         * 假设i和j分别为指示主串和模式串中正在比较的字符的当前位置，并对i 和j 赋初值0。
         在匹配的过程中，若si=tj，则i和j分别增加1，继续进行比较。
         否则，若j=0，si!=tj,则从s的下一个字符开始，即i增加一,若j！=0，令j=next[j]
         */
        int num=KMP(next,str1,str2);
        System.out.println(num);
    }

    private static int  KMP(int[] next, String s, String t) {
        // TODO Auto-generated method stub
        int j=0,i=0;//i为主串s正在匹配的字符，j为t正在匹配的字符
        char a[]=s.toCharArray();
        char b[]=t.toCharArray();
        while(i<s.length()&&j<t.length()){
            if(b[j] == a[i])
            {
                j++;i++;
            }else{
                if(j==0)
                {
                    i++;//若第一个字符就匹配失败，则从s的下一个字符开始
                }
                else
                {

                    j = next[j];//,也可以j=next[j],用next确定t应回溯到的字符
                }
            }

        }
        if(j < t.length())//整个过程匹配失败
        {
            return -1;
        }
        return i-t.length();//匹配成功

    }

    private static void calculateNext(int[] next, String str2) {
        // TODO Auto-generated method stub
        for(int j=0;j<str2.length();j++){
            boolean state=true;//是否是等于0的情况
            if(j==0){
                next[j]=-1;
            }else{
                int k=j-1;//属于0<k<j 获取最大k
                while(k>0){
                    String a=null;
                    String b=null;
                    for(int i=0;i<=k-1;i++){
                        a=a+str2.charAt(i);
                        b=b+str2.charAt(j-k+i);
                    }
                    if(a.equals(b)){//若，p[0....k-1]=p[j-k...j-1];
                        next[j]=k;
                        state=false;//不是等于0的情况
                        break;
                    }
                    k--;
                }
                if(state){
                    next[j]=0;
                }
            }
        }
    }

}
