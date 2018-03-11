package dfs;

/**
 * Created by user on 2017/10/17.
 */
public class aoj0525 {
    /**
     * 题意：药药!切克闹! 煎饼果子来一套!有一个烤饼器可以烤r行c列的煎饼，
     * 煎饼可以正面朝上（用1表示）也可以背面朝上（用0表示）。
     * 一次可将同一行或同一列的煎饼全部翻转。现在需要把尽可能多的煎饼翻成正面朝上，
     * 问最多能使多少煎饼正面朝上？
     输入：多组输入，每组第一行为二整数r, c (1 ≤ r ≤ 10, 1 ≤ c ≤ 10 000)，
     剩下r行c列表示煎饼初始状态。r=c=0表示输入结束。
     输出：对于每组输入，输出最多能使多少煎饼正面朝上。
     又是枚举，作为2.1节最后一题，中规中矩。我看到这题的第一眼就觉得，
     这题简直是为了推广bitset而设的宣传！由于煎饼的行数远远小于列数，所以只需要10个bitset就可以表示整个煎饼器。对于煎饼的翻转，可以利用bitset::flip来实现，连英文flip都对上了！

     枚举的话，先从行开始，一共有2^R种翻转可能，行翻转完毕再翻转列。列的翻转不必真的flip，只需要统计一下朝上的煎饼果子和朝下的煎饼果子，两者比较取其最大值即可。

     */
//    #include <iostream>
//#include <bitset>
//#include <algorithm>
//
//    using namespace std;
//
//    bitset<10000> cookie[10];
//
//    ///////////////////////////SubMain//////////////////////////////////
//    int main(int argc, char *argv[])
//    {
//
//        int R, C;
//        while(cin >> R >> C && R > 0)
//        {
//            int i, j;
//            for (i = 0; i < R; ++i)
//            {
//                for (j = 0; j < C; ++j)
//                {
//                    bool upwards;
//                    cin >> upwards;
//                    cookie[i][j] = upwards;
//                }
//            }
//
//            // 在横向一共有2^R种变换
//            int permute_r = 1 << R;
//            int result = 0;
//            for (i = 0; i < permute_r ; ++i)
//            {
//                // 完成当前的变换
//                for (j = 0; j < R; ++j)
//                {
//                    // 这一行是否应当翻个面
//                    if (i & (1 << j))
//                    {
//                        cookie[j].flip();
//                    }
//                }
//
//
//                // 对每一列分别算出朝上和朝下的煎饼个数，取其最大值
//                int possible_answer = 0;
//                for (j = 0; j < C; ++j)
//                {
//                    int up_cookie_count = 0;
//                    for (int k = 0; k < R; ++k)
//                    {
//                        if (cookie[k][j])
//                        {
//                            ++up_cookie_count;
//                        }
//                    }
//                    possible_answer += max(up_cookie_count, R - up_cookie_count);
//                }
//                // 结果取最大值
//                result = max(result, possible_answer);
//
//                // 复原
//                for (j = 0; j < R; ++j)
//                {
//                    if (i & (1 << j))
//                    {
//                        cookie[j].flip();
//                    }
//                }
//            }
//            cout << result << endl;
//        }
//
//        return 0;
//    }
}
