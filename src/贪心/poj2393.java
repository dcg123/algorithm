package 贪心;

/**
 * Created by user on 2017/8/11.
 */
public class poj2393 {
    /**
     * 题意：任务规定，一个酸奶制造厂，在n个星期内，分别要向外提供y[i]unit的酸奶。
     * 已知这个制造厂第i周制造每unit酸奶的费用为c[i]，
     * 储存室储存每1unit酸奶1星期的费用为s。问要完成这个任务的最小费用是多少。
     *
     *
     * 贪心策略是维持每周的最低单位成本，每周可能用上周剩下的，也可能生产新的。
     * 于是该周单位成本可能为上一周的单位成本加上储存费，也可能为该周的单位成本。
     */


//
//    #include <iostream>
//    using namespace std;
//
//    ///////////////////////////SubMain//////////////////////////////////
//    int main(int argc, char *argv[])
//    {
//#ifndef ONLINE_JUDGE
//        freopen("in.txt", "r", stdin);
//        freopen("out.txt", "w", stdout);
//#endif
//        int N, S;
//        cin >> N >> S;
//        int P = 5000;
//	long long costs = 0;
//        for (int i = 0; i < N; ++i)
//        {
//            int C, Y;
//            cin >> C >> Y;
//            P = min(P + S, C);
//            costs += P * Y;
//        }
//        cout << costs << endl;
//#ifndef ONLINE_JUDGE
//        fclose(stdin);
//        fclose(stdout);
//        system("out.txt");
//#endif
//        return 0;
//    }
}
