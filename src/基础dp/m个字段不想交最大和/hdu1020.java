package 基础dp.m个字段不想交最大和;



        import java.util.Scanner;

public class hdu1020 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        int t;
        t=scan.nextInt();
        for(int i=0;i<t;i++){
            int count=1;
            String str=scan.next();
            char b[]=str.toCharArray();
            char a[]=new char[str.length()+1];

            for(int k=0;k<a.length;k++){
                if(k!=(a.length-1)){
                    a[k]=b[k];
                }
                else{
                    a[k]='#';
                }

            }
            for(int j=1;j<a.length;j++){
                if(a[j]==a[j-1]){
                    count++;

                }else{
                    if(count==1){
                        System.out.print(a[j-1]);
                    }else{

                        System.out.print(count+""+a[j-1]);
                        count=1;
                    }
                }
            }
            System.out.println();
        }
    }

}
