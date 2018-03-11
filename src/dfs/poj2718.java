package dfs;


        import java.util.Scanner;

/**
 * Created by user on 2017/8/10.
 */
public class poj2718 {
    /**
     * 　　给出最多10个数字，将它们划分为两个整数，求差值最小的值（除非只有一位数，否则不允许出现先导0）
     */
    // static int Main[]=new int[10+2];
    static int INF=100000000;
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        scanner.nextLine();
        while((t--)>0){
            String str=scanner.nextLine();
            char a[]=str.toCharArray();
            int cnt=a.length/2;
            //枚举每个全排列 更新最小值
            String result=next_permutation(a,0);
            String c=result.substring(0,cnt);
            String b=result.substring(cnt,a.length);
            int min=Math.min(INF,(Integer.valueOf(c)-Integer.valueOf(b)));
            System.out.println();
        }
    }

    private static String next_permutation(char[] a, int k) {
        if(k==a.length-1){
            String result="";
            for(int i=0;i<a.length;i++){
                result+=a[i];
            }
            return result;
        }
        for(int i=k;i<a.length;i++){
            if(isexist(a,k,i)){
                continue;
            }
            swap(a,i,k);
            next_permutation(a,k+1);
            swap(a,i,k);
        }
        return null;
    }

    private static void swap(char[] a, int i, int k) {
        char temp=a[i];
        a[i]=a[k];
        a[k]=temp;
    }

    private static boolean isexist(char[] a, int k, int i) {
        return true;
    }
}

//#include<iostream>
//#include<algorithm>
//#include<cstring>
//using namespace std;
//
//        int main() {
//        char s[1000];    //利用字符数组存储，是因为并不知道会输入几个数，那么我们就定义字符数组来存储输入一行的字符。
//        int t;
//        cin >> t;
//        getchar();        //这里getchar()是接收上面输入t后的回车符，若没有，则下面的gets_s()函数，就会接收回车符。
//        while (t--) {
//        int a[11], num = 0 , ans = 0x3f3f3f3f;    //在通常的场合下，设置无穷大时，0x3f3f3f3f是一个非常棒的选择。如果想把int整形数组初始化为无穷大，我们只需要memset(a,0x3f,sizeof(a)).
//        gets_s(s);        //VS2015使用的是新C标准，也就是C11，而VC6.0用的是老标准。在新标准中，用gets_s代替gets
//        for (int i = 0; i < strlen(s); i++) {    //将字符数组转化为整形数组
//        if (s[i] >= '0'&&s[i] <= '9') {
//        a[num++] = s[i] - '0';            //a[]用来存储s[]转化得到的整形数组
//        }
//        }
//        sort(a, a + num);
//        do {
//        int num1 = 0, num2 = 0;
//        if (!a[0] || !a[num/2] && num>2)    //前面那个数的首位不能是0 或者 后面那个数的首位也不能是0 ， 还有当为输入是 10 时 ，要么前面那个数的是0， 要么后面的那个数是0，所以条件 num>2 加"||"前后都一样
//        continue;
//        for (int i = 0; i < num/2; i++) {
//        num1 = num1 * 10 + a[i];        //前一半数组的数，化为整数
//        }
//        for (int i = num / 2; i < num; i++) {
//        num2 = num2 * 10 + a[i];        //后一半数组的数，化为整数
//        }
//        ans = min(ans, abs(num1 - num2));
//        } while (next_permutation(a, a + num));
//        cout << ans << endl;
//        }
//        return 0;
//        }