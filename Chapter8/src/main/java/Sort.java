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
        for(int i = A.length - 1; i >= 0; i--){
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

    /**
     * 获得数字的某位
     * @param digit 数字
     * @param i 1-d位
     * @return 单位数字
     */
    public int getDigit(int digit, int i){
        int result = 0;
        for(int j = 0; j < i; j++){
            result = digit % 10;
            digit /= 10;
        }
        return result;
    }

    /**
     * 计数排序变种，根据某一位进行排序，k不需要，因为每一位数字在0到9之间。
     * @param A
     * @param B
     * @param index
     */
    public void CountingSort2(int[] A, int[] B, int index){
        int[] C = new int[10];
        for(int i = 0; i < A.length; i++){
            C[getDigit(A[i], index)]++;
        }
        for(int i = 1; i < 10; i++){
            C[i] += C[i - 1];
        }
        for(int i = A.length - 1; i >= 0; i--){
            B[C[getDigit(A[i], index)] - 1] = A[i];
            C[getDigit(A[i], index)]--;
        }
    }

    @Test
    public void TestCS2(){
        int n = 0, i =0;
        n = 8;
        int[] A = new int[]{12, 25, 33, 10, 32, 43, 20, 13};
        int[] B = new int[n];
        CountingSort2(A, B, 2);
        System.out.println("结果是：");
        for(int x : B){
            System.out.print(x + " ");
        }
    }

    @Test
    public void TestGD(){
        System.out.println(getDigit(768, 2));
    }

    /**基数排序
     * @param A 需要排序的数组，返回时已经排序
     * @param d 最高位，最低位是1
     */
    public int[] RadixSort(int[] A, int d){
        int[] B = A.clone();
        for(int i = 1; i <= d; i++){
            //调用某一稳定排序对A数组进行排序（基于i位）
            CountingSort2(A, B, i);
            A = B.clone();
        }
        return A;
    }

    /**
     * 测试基数排序
     */
    @Test
    public void TestRS(){
        int[] A = new int[]{329, 457, 657, 839, 436, 720, 355};
        A = RadixSort(A, 3);
        for(int x : A){
            System.out.print(x + " ");
        }
    }

    /**
     * 待完成，桶排序
     * @param A
     */
    public void BucketSort(int[] A){
        int n = A.length;
        List[] B = new List[10];
        for(int i = 0; i < n; i++){

        }
    }

    /**
     * 测试桶排序
     */
    @Test
    public void TestBS(){
        List[] B = new List[10];
        System.out.println(B[1].val);
    }

}
