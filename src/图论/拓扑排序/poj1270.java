package 图论.拓扑排序;

/**
 * Created by user on 2017/10/17.
 */
public class poj1270 {
    /**
     * 　题意：给定第一行的小写字母，
     * 第二行每两个字母描述其约束关系，例如x y 即 x<y，求可以得到的所有有序序列。
     */
    //有序序列-拓扑排序+DFS
//一个难点在于输入，如果使用C语言的gets或者fgets总觉得不好处理
//    于是利用了cin的getline函数，会将'\n'转换成'\0',利于处理
//另一个难点在于字典序输出，需要利用到DFS的回溯
//其余的操作与拓扑排序相同
//Time:0Ms    Memory:208K
//#include<iostream>
//#include<cstring>
//#include<cstdio>
//#include<vector>
//#include<algorithm>
//    using namespace std;
//
//#define MAX 50
//
//    struct Letter {
//        vector<int> bigger;
//        int in;        //in_degree
//        bool exist;
//    }let[26];
//
//    int total;
//    char ans[MAX];
//
//    void dfs(int len)
//    {
//        if (len == total)
//        {
//            ans[len] = '\0';
//            printf("%s\n", ans);
//            return;
//        }
//
//        for (int i = 0; i < 26; i++)
//        {
//            if (!let[i].exist || let[i].in) continue;
//            let[i].in--;
//            for (unsigned j = 0; j < let[i].bigger.size(); j++)
//                let[let[i].bigger[j]].in--;
//            ans[len] = i + 'a';
//            dfs(len + 1);
//            for (unsigned j = 0; j < let[i].bigger.size(); j++)
//                let[let[i].bigger[j]].in++;
//            let[i].in++;
//        }
//    }
//
//    int main()
//    {
//        char str[MAX];
//        while (cin.getline(str, MAX, '\n'))
//        {
//            total = 0;
//            memset(let, 0, sizeof(let));
//            int len = strlen(str);
//            for (int i = 0; i < len; i += 2)
//                if(!let[str[i] - 'a'].exist)
//                    let[str[i] - 'a'].exist = ++total;
//
//            cin.getline(str, MAX, '\n');
//            len = strlen(str);
//            for (int i = 0; i < len; i += 4)
//            {
//                int small = str[i] - 'a';
//                int big = str[i + 2] - 'a';
//                let[small].bigger.push_back(big);
//                let[big].in++;
//            }
//
//            dfs(0);
//            printf("\n");
//        }
//
//        return 0;
//    }
}
