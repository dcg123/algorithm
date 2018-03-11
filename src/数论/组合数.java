package 数论;


        import java.util.Scanner;

public class 组合数 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        int arr[] = {1, 2, 3};
        int num = 2;
        int result[]=new int[num];
        combine_increase(arr,0,result,num,num,arr.length);
    }

    private static void combine_increase(int[] arr, int start, int[] result,
                                         int count, int NUM, int arr_len) {
        // TODO Auto-generated method stub
        int i=0;
        for (i = start; i < arr_len + 1 - count; i++)
        {
            result[count - 1] = i;
            if (count - 1 == 0)
            {
                int j;
                for (j = NUM - 1; j >= 0; j--)
                    System.out.printf("%d\t",arr[result[j]]);
                System.out.print("\n");
            }
            else
                combine_increase(arr, i + 1, result, count - 1, NUM, arr_len);
        }
    }

}
