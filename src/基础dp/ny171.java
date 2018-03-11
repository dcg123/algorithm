package 基础dp;



        import java.util.Scanner;

public class ny171 {

    /**
     * @param args
     * 聪明的“KK”
    非洲某国展馆的设计灵感源于富有传奇色彩的沙漠中陡然起伏的沙丘，体现出本国不断变换和绚丽多彩的自然风光与城市风貌。展馆由五部分组成，馆内影院播放名为《一眨眼的瞬间》的宽银幕短片，反映了建国以来人民生活水平和城市居住环境的惊人巨变。
    可移动“沙丘”变戏法 的灵感源于其独特而雄伟的自然景观——富于传奇色彩的险峻沙丘。宏伟的结构、可循环的建材，与大自然相得益彰。环绕一周，发现它正是从沙丘那不断变换的形态中汲取灵感的。外形逼真到无论从哪个角度去观察，都能清楚地辨识出沙丘的特征。
    它“坡面”高达20米，微风吹来，你是否感觉到沙的流动？用手去触碰，却发现原来是“魔术戏法”。它表面的不锈钢面板呈现出一种富于变幻的色彩，从不同角度观察，呈现不同色泽，由此来模仿流动沙丘的光感。
    走进第三展厅有一个超大的屏幕，通过奇妙的特效，让观众犹如亲身来到浩瀚的沙漠。更为奇妙的是，只见一个小动物“KK”正从沙漠区域（矩形）的左上角沿着向右或向下的方向往右下角跑去。KK太聪明了，它居然能在跑的过程中会选择吃掉尽可能多的虫子线路。
    你知道它吃掉多少虫子吗？
     */
    private static final int MAX=500+1;
    private static final int [][]e=new int[MAX][MAX];
    private static final int f[][]=new int[MAX][MAX];
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        int n,m;
        n=scan.nextInt();
        m=scan.nextInt();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                int a=scan.nextInt();
                e[i][j]=a;
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                f[i][j]=e[i][j]+max(f[i-1][j],f[i][j-1]);
            }
        }
        System.out.println(f[n][m]);
    }
    private static int max(int i, int j) {
        // TODO Auto-generated method stub
        return i>j?i:j;
    }

}
