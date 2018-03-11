package 字符串.map;



        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.Collections;
        import java.util.HashMap;
        import java.util.Iterator;
        import java.util.Map;
        import java.util.Scanner;
        import java.util.Set;

public class hdu1113 {

    /**
     * @param args
     * 题意：
    输入字典  XXXXXX结束字典的输入
    然后输入字符串  如果字符串能够组成字典中的串就输出该串 否则输出NOT A VALID WORD
    tarp
    given
    score
    refund
    only
    trap
    work
    earn
    course
    pepper
    part
    XXXXXX
    resco
    nfudre
    aptr
    sett
    oresuc
    XXXXXX
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        String str,s;
        Map<String,String> map =new HashMap<String, String>();
        while(((str=scan.nextLine()).length())!=0&&!str.equals("XXXXXX")){
            char a[]=str.toCharArray();
            Arrays.sort(a);
            s=String.valueOf(a);
            map.put(str, s);

        }
        while(((str=scan.nextLine()).length())!=0&&!str.equals("XXXXXX")){
            char a[]=str.toCharArray();
            Arrays.sort(a);
            s=String.valueOf(a);
            ArrayList arr = valueGetKey(map, s);
            if(!arr.isEmpty()) {
                if(arr.size()==1){
                    for(int i=0; i<arr.size(); i++) {
                        System.out.println(arr.get(i));
                    }
                }else{
                    Collections.sort(arr);
                    for(int i=0; i<arr.size(); i++) {
                        System.out.println(arr.get(i));
                    }
                }

            }else{
                System.out.println("NOT A VALID WORD");
            }
            System.out.println("******");
        }
    }
    private static ArrayList valueGetKey(Map map,String value) {
        Set set = map.entrySet();
        ArrayList arr = new ArrayList<>();
        Iterator it = set.iterator();
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            if(entry.getValue().equals(value)) {
                String s = (String) entry.getKey();
                arr.add(s);
            }
        }
        return arr;
    }

}
