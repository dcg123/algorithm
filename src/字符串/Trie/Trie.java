package 字符串.Trie;


public class Trie {

    /**
     * @param args
     */
    //各个节点的子树数目即字符串中的字符出现的最多种类
    private final int SIZE = 26;
    //除根节点外其他所有子节点的数目
    private int numNode;
    //树的深度即最长字符串的长度
    private int depth;
    //字典树的根
    private TrieNode root;
    public Trie() {
        this.numNode=0;
        this.depth=0;
        this.root = new TrieNode();
    }
    private class TrieNode {

        // 所有的儿子节点或者一级子节点
        private TrieNode[] son;
        // 有多少字符经过或到达这个节点,即节点字符出现的次数
        private int numPass;
        // 有多少字符串通过这个节点并到此结束的数量
        private int numEnd;
        // 是否有结束节点
        private boolean isEnd;
        // 节点的值
        private char value;

        /**
         * 初始化节点类
         */
        public TrieNode() {
            this.numPass=0;
            this.numEnd=0;
            this.son = new TrieNode[SIZE];
            this.isEnd = false;
        }
    }
    /**
     * 对操作的字符串进行一个非法的判断，是否为字母构成的字符串
     */
    private boolean isStrOfLetter(String str){
        //null或者空白字符串，则插入失败
        if (str==null){
            return false;
        }

        return true;
    }
    /**
     * 插入方法，插入字符串，不区分大小写
     */
    public boolean insertStr(String str){
        if(!isStrOfLetter(str)){
            return false;
        }
        //插入字符 不区分大小写 全部转换成小写
        str=str.toLowerCase();
        char letters[]=str.toCharArray();
        //从父节点开始
        TrieNode node=this.root;
        for(char c:letters){
            int pos=c-'a';
            if(node.son[pos]==null){//字符不存在
                node.son[pos]=new TrieNode();
                node.son[pos].value=c;
                node.son[pos].numPass=1;
                this.numNode++;
            }else{
                node.son[pos].numPass++;
            }
            //为下一个字符做准备
            node=node.son[pos];
        }
        node.isEnd = true;//标记：有字符串到了此节点已结束
        node.numEnd++;//这个字符串重复次数
        if(letters.length>this.depth){//记录树的深度
            this.depth=letters.length;
        }
        //插入成功
        return true;
    }
    /**
     * 在字典树中查找是否存在某字符串为前缀开头的字符串(包括前缀字符串本身)，不区分大小写
     */
    public boolean isContainPrefix(String str){
        //查找的字符是否非法字符，则失败
        if(!isStrOfLetter(str)){
            return false;
        }
        //查找字符串
        str=str.toLowerCase();//不区分大小写，转为小写
        char[] letters = str.toCharArray();//转成字符数组
        TrieNode node=this.root;//先从父节点开始
        for(char c:letters){
            int pos=c-'a';
            if(node.son[pos]!=null){
                node=node.son[pos];//在此字符串下继续查找
            }else{
                return false;
            }
        }
        return true;
    }
    /**
     * 在字典树中查找是否存在某字符串(不为前缀)，不区分大小写
     */
    public boolean isContainStr(String str){
        //查找的字符是否非法字符，则失败
        if(!isStrOfLetter(str)){
            return false;
        }
        //查找字符串
        str=str.toLowerCase();//不区分大小写，转为小写
        char[] letters = str.toCharArray();//转成字符数组
        TrieNode node=this.root;//先从父节点开始
        for(char c:letters){
            int pos=c-'a';
            if(node.son[pos] != null){
                node=node.son[pos];//此字符存在继续查找下一个字符
            }else{
                return false;
            }
        }
        return node.isEnd;
    }
    /**
     * 统计以指定字符串为前缀的字符串数量，不区分大小写
     */
    public int countPrefix(String str) {
        //统计的字符是否非法字符，则返回0
        if(!isStrOfLetter(str)){
            return 0;
        }
        //查找字符串
        str=str.toLowerCase();//不区分大小写，转为小写
        char[] letters = str.toCharArray();//转成字符数组
        TrieNode node=this.root;//先从父节点开始
        for (char c:letters) {
            int pos = c - 'a';//得到应存son[]中的索引
            if (node.son[pos] == null) {
                return 0;//没有以此字符串为前缀开头
            } else {//此字符存在,继续遍历
                node=node.son[pos];
            }
        }
        return node.numPass;
    }
    /**
     * 统计以指定字符串为前缀的字符串数量，不区分大小写
     */
    public int countPrefix1(String str) {
        //统计的字符是否非法字符，则返回0
        if(!isStrOfLetter(str)){
            return 0;
        }
        //查找字符串
        str=str.toLowerCase();//不区分大小写，转为小写
        char[] letters = str.toCharArray();//转成字符数组
        TrieNode node=this.root;//先从父节点开始
        for (char c:letters) {
            int pos = c - 'a';//得到应存son[]中的索引
            if (node.son[pos] == null) {
                return 0;//没有以此字符串为前缀开头
            } else {//此字符存在,继续遍历
                node=node.son[pos];
            }
        }
        return node.numPass;
    }
    public int countStr(String str) {
        //统计的字符是否非法字符，则返回0
        if(!isStrOfLetter(str)){
            return 0;
        }
        //查找字符串
        str=str.toLowerCase();//不区分大小写，转为小写
        char[] letters = str.toCharArray();//转成字符数组
        TrieNode node=this.root;//先从父节点开始
        for (char c:letters) {
            int pos = c - 'a';//得到应存son[]中的索引
            if (node.son[pos] == null) {
                return 0;//没有以此字符串为前缀开头
            } else {//此字符存在,继续遍历
                node=node.son[pos];
            }
        }
        return node.numEnd;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //创建一个字典树(其实可以在创建时指定字典树各节点的大小，大小根据存入字符种类的数量)
        Trie trie=new Trie();
        //测试字符串（当然越庞大越能展现它的优势）
        String[] testStrs=new String[]{"chefsd","chen","hahi","ch","cxing","hahha","my","home"};
        for(String s:testStrs){//向字典树中存入字符串
            trie.insertStr(s);
        }
        //测试是否包含指定前缀的字符串
        boolean isCont=trie.isContainPrefix("ch");
        System.out.println(isCont);//输出true

        //测试包含指定前缀的字符串的数量
        int countPrefix=trie.countPrefix1("ch");
        System.out.println(countPrefix);//输出3

        //测试包含指定字符串的数量
        int countStr=trie.countStr("ch");
        System.out.println(countStr);//输出1

        //测试包含指定前缀的字符串的数量
        int countPre=trie.countPrefix("chee");
        System.out.println(countPre);//输出0


    }

}
