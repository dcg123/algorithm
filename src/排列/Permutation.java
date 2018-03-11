package 排列;


public class Permutation {

    /**
     * @param args
     */
    public static int total = 0;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String str[]={"1","2","3"};
        arrange(str,0,str.length);
    }

    private static void arrange(String[] str, int st, int len) {
        // TODO Auto-generated method stub
        if(st==len-1){
            for(int i=0;i<len;i++){
                System.out.print(str[i]+" ");
            }
            System.out.println();
            total++;
        }else{
            for(int i=st;i<len;i++){
                swap(str,st,i);
                arrange(str,st+1,len);
                swap(str,st,i);
            }
        }
    }
    private static void swap(String[] str, int i, int j) {
        // TODO Auto-generated method stub
        String temp=new String();
        temp=str[i];
        str[i]=str[j];
        str[j]=temp;
    }

}
