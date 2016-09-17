import org.junit.Test;

import java.util.Scanner;

/**
 * 线性时间排序
 * Created by Administrator on 2016/9/17.
 */
public class Sort {

    /**
     * 计数排序
     * @param A 原数组
     * @param B 结果数组
     * @param k 数字范围0-k的k
     */
    public void CountingSort(int[] A, int[] B, int k){
        int[] C = new int[k];
        for(int i = 0; i < A.length; i++){
            C[A[i]]++;
        }
        for(int i = 1; i < k; i++){
            C[i] += C[i - 1];
        }
        for(int i = 0; i < A.length; i++){
            B[C[A[i]] - 1] = A[i];
            C[A[i]]--;
        }
    }

    /**
     * 测试计数排序
     */
    @Test
    public void TestCS(){
        int n = 0, k = 0, i =0;
//        Scanner in = new Scanner(System.in);
//        System.out.println("请输入数组大小n：");
//        n = in.nextInt();
//        System.out.println("请输入数组中数字的范围k：");
//        k = in.nextInt();
        n = 8;
        k = 6;
        int[] A = new int[]{2, 5, 3, 0, 2, 3, 0, 3};
        int[] B = new int[n];
//        System.out.println("请输入依次数组中的值：");
//        while(i++ < n){
//            A[i] = in.nextInt();
//        }
        CountingSort(A, B, k);
        System.out.println("结果是：");
        for(int x : B){
            System.out.print(x + " ");
        }
    }
}
