package 最大二分匹配.最大独立子集;

/**
 * Created by user on 2017/10/16.
 */
public class poj3692 {
    /**
     * 题意：已知班级有g个女孩和b个男孩，所有女生之间都相互认识，所有男生之间也相互认识，给出m对关系表示哪个女孩与哪个男孩认识。现在要选择一些学生来组成一个团，使得里面所有人都认识，求此团最大人数。

     思路：最大独立集问题：在Ｎ个点的图G中选出m个点，使这m个点两两之间没有边(没有某种关系)．求m最大值．如果图Ｇ满足二分图条件，则可以用二分图匹配来做．最大独立集点数 = N - 最大匹配数。
     */
//    #include<iostream>
//    using namespace std;
//const int Max = 205;
//
//    int b, g, link[Max];
//    bool map[Max][Max], vis[Max];
//
//    bool dfs(int u){
//        for(int i = 1; i <= b; i ++)
//            if(!vis[i] && !map[u][i]){    //  取逆。
//                vis[i] = true;
//                if(link[i] == -1 || dfs(link[i])){
//                    link[i] = u;
//                    return true;
//                }
//            }
//        return false;
//    }
//
//    int main(){
//        int m, i, t = 1;
//        while(cin >> g >> b >> m){
//            if(g == 0 && b == 0 && m == 0) break;
//            memset(map, 0, sizeof(map));
//            while(m --){
//                int u, v;
//                cin >> u >> v;
//                map[u][v] = true;
//            }
//            int ans = g + b;
//            memset(link, -1, sizeof(link));
//            for(i = 1; i <= g; i ++){
//                memset(vis, 0, sizeof(vis));
//                if(dfs(i)) ans --;
//            }
//            cout << "Case " << t ++ << ": " << ans << endl;
//        }
//        return 0;
//    }
}
