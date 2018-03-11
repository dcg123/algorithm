package 字符串.kmp;

import java.util.Scanner;

/**
 * Created by user on 2017/8/20.
 */
public class hdu4300 {
    /**
     * 题意比较难理解,就是说给定两组字符串,第一组只有26个字符表对应明文中a,b,c,d....z可以转换第一个,第二个...第26个字符变成密文,
     第二组字符串是给定的密文+明文,明文可能不完整(缺失或没有),叫你补完且整个密文+明文是最短的
     */
    static int MAX_N=200000;
    static int next[]=new int[MAX_N];
    static  int extend[]=new int[MAX_N];
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
    }
//    #include<iostream>
//#include<cstdio>
//#include<cstdlib>
//#include<cstring>
//#include<string>
//#include<queue>
//#include<algorithm>
//#include<map>
//#include<iomanip>
//#define INF 999999999
//    using namespace std;
//
//const int MAX=100000+10;
//    char s1[MAX],s2[MAX],a[27],b[27];
//    int next[MAX];
//
//    void get_next(char *a,int len){
//        int k=0,i=1;
//        next[0]=len;//本题无作用
//        while(k+1<len && a[k] == a[k+1])++k;
//        next[1]=k;
//        k=1;
//        while(++i<len){
//            int maxr=k+next[k]-1;
//            next[i]=min(next[i-k],max(maxr-i+1,0));
//            while(i+next[i]<len && a[next[i]] == a[i+next[i]])++next[i];
//            if(i+next[i]>k+next[k])k=i;
//        }
//    }
//
//    int main(){
//        int T,k;
//        cin>>T;
//        while(T--){
//            cin>>a>>s1;
//            for(int i=0;i<26;++i)b[a[i]-'a']=i+'a';
//            int len=strlen(s1);
//            for(int i=0;i<(len+1)/2;++i)s2[i]=b[s1[i]-'a'];//将密文转换为明文,密文长度>=明文长度
//            for(int i=(len+1)/2;i<=len;++i)s2[i]=s1[i];
//            get_next(s2,len);
//            for(k=(len+1)/2;k<len;++k){
//                if(next[k] == len-k)break;
//            }
//            cout<<s1;
//            for(int i=len-k;i<k;++i)cout<<b[s1[i]-'a'];
//            cout<<endl;
//        }
//        return 0;
//    }
}
