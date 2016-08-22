import org.junit.Test;

/**
 * Created by Administrator on 2016/8/22.
 */
public class Sort {

    /**插入排序
     * @param A 数组A
     * @return
     */
    public void InsertionSort(int[] A){
        int key;
        for(int j = 1;j < A.length; j++){
            key = A[j];
            int i = j - 1;
            while(i >= 0 && A[i] < key){
                A[i + 1] = A[i];
                i = i - 1;
            }
            A[i + 1] = key;
        }
    }

    /**二进制数相加
     * @param A 数组A
     * @param B 数组B
     * @return
     */
    public int[] bitAdd(int[] A, int[] B){
        int index = A.length > B.length ? A.length + 1 : B.length + 1;
        int[] result = new int[index];
        int carry = 0;
        index--;
        for(int i = A.length - 1, j = B.length - 1; i >= 0 && j >= 0; i--, j--){
            if(A[i] + B[j] == 2){
                result[index] = carry == 0 ? 0 : 1;
                carry = 1;
            }else if(A[i] + B[j] == 1){
                result[index] = carry == 0 ? 1 : 0;
            }else if(A[i] + B[j] == 0){
                result[index] = carry == 0 ? 0 : 1;
                carry = 0;
            }
            index --;
        }
        while(index >= 0){
            result[index] = A.length > B.length ? A[index] : B[index];
            index--;
        }
        return result;
    }

    /**合并排序过的数组，把数组分成了[p --> q],[q+1 --> r]
     * @param A 数组A
     * @param p
     * @param q
     * @param r
     * @return
     */
    public int[] Merge(int[] A, int p, int q, int r){
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];
        for(int i = 0; i < n1; i++){
            L[i] = A[p + i];
        }
        for(int i = 0; i < n2; i++){
            R[i] = A[q + i + 1];
        }
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;
        int i = 0, j = 0;
        for(int k = p; k <= r; k++){
            if(L[i] <= R[j]){
                A[k] = L[i];
                i++;
            }else{
                A[k] = R[j];
                j++;
            }
        }
        return A;
    }

    /**合并排序算法，一个数字的时候算已排序。最后合并排序过的数组
     * @param A
     * @param p
     * @param r
     */
    public void MergeSort(int[] A, int p, int r){
        if(p < r){
            int q = (p + r) / 2;
            MergeSort(A, p, q);
            MergeSort(A, q+1, r);
            Merge(A, p, q, r);
        }
    }

    @Test
    public void TestIS(){
        int[] A = new int[]{4, 2, 3};
        InsertionSort(A);
        for(int x : A){
            System.out.println(x);
        }
    }

    @Test
    public void TestMS(){
        int[] A = new int[]{4, 2, 3, 7, 5};
        MergeSort(A, 0, 4);
        for(int x : A){
            System.out.println(x);
        }
    }

    @Test
    public void TestBA(){
        int[] A = new int[]{1, 0, 1};
        int[] B = new int[]{1, 0, 1};
        int[] res = bitAdd(A, B);
        for(int x : res){
            System.out.print(x + " ");
        }
    }
}
