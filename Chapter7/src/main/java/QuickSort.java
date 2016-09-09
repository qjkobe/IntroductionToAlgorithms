import org.junit.Test;

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
        int i = (int) Math.round(Math.random()*(r - p) + p);
        int temp = A[r];
        A[r] = A[i];
        A[i] = temp;
        return Partition(A, p, r);
    }

    public void RandomizedQuciksort(int[] A, int p, int r){
        if(p < r){
            int q = RandomizedPartition(A, p, r);
            RandomizedPartition(A, p, q - 1);
            RandomizedPartition(A, q + 1, r);
        }
    }

    @Test
    public void TestRQS(){
        int[] A = new int[]{2, 8, 7, 1, 3, 5, 6, 4};
        RandomizedQuciksort(A, 0, 7);
        for(int x : A){
            System.out.println(x);
        }
    }


}
