package 字符串.map;


        import java.util.HashMap;
        import java.util.Map;
        import java.util.Scanner;

public class hdu1075 {

    /**
     * @param args
     * 给出一个“翻译-原文”的对应表，然后给出句子，要把句子中的原文都翻译出来。
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        String a,b;
        Map<String,String> map=new HashMap<String, String>();
        a=scan.next();
        String str1=scan.nextLine();
        while(((a=scan.nextLine()).length())!=0){
            String[] e=a.split(" ");
            if(a.equals("END")){
                break;
            }
            map.put(e[1], e[0]);
        }
        a=scan.nextLine();
        String str;
        while(true){
            str=scan.nextLine();
            if(str.equals("END")){
                break;
            }
            int len=str.length();
            char d[]=str.toCharArray();
            a="";
            for(int i=0;i<len;i++){
                if(97<=((int)d[i])&&((int)d[i])<=122){
                    a+=d[i];
                }else{
                    if(map.containsKey(a)){
                        System.out.print(map.get(a));
                    }else{
                        System.out.print(a);
                    }
                    a="";
                    System.out.print(d[i]);
                }
            }
            System.out.println();
        }
    }

}
