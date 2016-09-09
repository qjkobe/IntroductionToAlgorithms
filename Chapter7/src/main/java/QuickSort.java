import org.junit.Test;

import java.util.Random;

/**
 * Created by Administrator on 2016/9/8.
 */
public class QuickSort {

    /**对子数组A[p...r]进行就地重排
     * @param A
     * @param p
     * @param r
     * @return
     */
    int Partition(int[] A, int p, int r){
        int x = A[r];
        int i = p - 1;
        for(int j = p; j < r; j++){
            if(A[j] <= x){
                i++;
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        int temp = A[i + 1];
        A[i + 1] = A[r];
        A[r] = temp;
        return i + 1;
    }

    void QuickSort(int[]A, int p, int r){
        if(p < r){
            int q = Partition(A, p, r);
            QuickSort(A, p, q - 1);
            QuickSort(A, q + 1, r);
        }
    }

    /**
     * 测试快速排序
     */
    @Test
    public void TestQS(){
        int[] A = new int[]{2, 8, 7, 1, 3, 5, 6, 4};
        QuickSort(A, 0, 7);
        for(int x : A){
            System.out.println(x);
        }
    }

    public int RandomizedPartition(int[] A, int p, int r){
        Random random=new Random();
        int i = random.nextInt(r - p + 1) + p;
        int temp = A[r];
        A[r] = A[i];
        A[i] = temp;
        return Partition(A, p, r);
    }

    public void RandomizedQuciksort(int[] A, int p, int r){
        if(p < r){
            int q = RandomizedPartition(A, p, r);
            RandomizedQuciksort(A, p, q - 1);
            RandomizedQuciksort(A, q + 1, r);
        }
    }

    @Test
    public void TestRQS(){
        int[] A = new int[]{2, 8, 7, 1, 3, 5, 6, 4};
        RandomizedQuciksort(A, 0, 7);
        for(int x : A){
            System.out.println(x);
        }
//        while(true) {
//            Random random = new Random();
//            int i = random.nextInt(7 - 6 + 1) + 6;
//            System.out.println(i);
//        }
    }

    public void qsort(int[] A, int left, int right){
        if(left < right) {
            int key = A[left];
            int low = left, high = right;
            while (low < high) {
                while (low < high && A[high] > key) {
                    high--;
                }
                A[low] = A[high];
                while (low < high && A[low] < key) {
                    low++;
                }
                A[high] = A[low];
            }
            A[low] = key;
            qsort(A, left, low - 1);
            qsort(A, low + 1, right);
        }
    }

    @Test
    public void testQsort(){
        int[] A = new int[]{2, 8, 7, 1, 3, 5, 6, 4};
        qsort(A, 0, 7);
        for(int x : A){
            System.out.println(x);
        }
    }
}
