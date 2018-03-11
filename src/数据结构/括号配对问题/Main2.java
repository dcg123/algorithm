package 数据结构.括号配对问题;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by user on 2017/10/4.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        scanner.nextLine();
        while (t-->0){
            String str=scanner.nextLine();
            Stack<Character> stack=new Stack<Character>();
            boolean flag=true;
            for (int i=0;i<str.length();i++){
                if (str.charAt(i)=='('||str.charAt(i)=='['){
                    stack.push(str.charAt(i));
                }
                else {
                    if (str.charAt(i)==')'){
                        if (stack.size()!=0&&stack.peek()=='('){
                            stack.pop();
                        }else {
                            flag=false;
                            break;
                        }
                    }
                    else {
                        if (stack.size()!=0&&stack.peek()=='['){

                            stack.pop();
                        }else {

                            flag=false;
                            break;
                        }
                    }
                }
            }
            if (!flag||stack.size()!=0){
                System.out.println("No");
            }else {
                System.out.println("Yes");
            }
        }
    }
}
