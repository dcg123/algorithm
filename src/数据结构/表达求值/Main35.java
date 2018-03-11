package 数据结构.表达求值;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Main35 {
    /*
     * 2 1.000+3/1= ((1+2)*5+1)/4=
     */
    public static float houZhui(String formula) {
        Stack<Float> s1 = new Stack<Float>();//放数字
        Stack<String> s2 = new Stack<String>();//放操作符
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        hashMap.put("(", 0);
        hashMap.put("+", 1);
        hashMap.put("-", 1);
        hashMap.put("*", 2);
        hashMap.put("/", 2);
        int tiao = 0;
        for (int i = 0; i < formula.length();) {
            StringBuffer digit = new StringBuffer();
            char c = formula.charAt(i);
            while (Character.isDigit(c) || c == '.') {
                digit.append(c);
                i++;
                c = formula.charAt(i);
            }
            if (digit.length() == 0) {
                switch (c) {
                    case '(': {
                        s2.push(String.valueOf(c));
                        break;
                    }
                    case ')': {
                        String stmp = s2.pop();
                        while (!s2.isEmpty() && !stmp.equals("(")) {
                            float a = s1.pop();
                            float b = s1.pop();
                            float sresulat = calcFloat(b, a, stmp);
                            s1.push(sresulat);
                            stmp = s2.pop();
                        }
                        break;
                    }
                    case '=': {
                        String stmp;
                        while (!s2.isEmpty()) {
                            stmp = s2.pop();
                            float a = s1.pop();
                            float b = s1.pop();
                            float sresulat = calcFloat(b, a, stmp);
                            s1.push(sresulat);
                        }
                        break;
                    }
                    default: {
                        String stmp;
                        while (!s2.isEmpty()) {
                            stmp = s2.pop();
                            if (hashMap.get(stmp) >= hashMap.get(String.valueOf(c))) {
                                float a = s1.pop();
                                float b = s1.pop();
                                float sresulat = calcFloat(b, a, stmp);
                                s1.push(sresulat);

                            } else {
                                s2.push(stmp);
                                break;
                            }

                        }
                        s2.push(String.valueOf(c));
                        break;
                    }
                }
            } else {
                s1.push(Float.valueOf(digit.toString()));
                continue;
            }
            i++;
        }
        return s1.peek();
    }

    public static float calcFloat(float a, float b, String stmp) {
        float res = 0f;
        char s = stmp.charAt(0);
        switch (s) {
            case '+': {
                res = a + b;
                break;
            }
            case '-': {
                res = a - b;

                break;
            }
            case '*': {
                res = a * b;
                break;
            }
            case '/': {
                res = a / b;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n > 0) {
            String s = scanner.next();
            System.out.printf("%.2f\n", houZhui(s));
            n--;
        }
    }

}