import org.junit.Test;

/**
 * Created by Administrator on 2016/8/23.
 */
public class Sort {

    int left(int i){
        return i * 2 + 1;
    }
    int right(int i){
        return i * 2 + 2;
    }
    int parent(int i){
        return (i - 1) / 2;
    }

    public void MaxHeapify(int[] A, int i){
        int l = left(i);
        int r = right(i);
        int heapSize = A.length;
        int largest;
        if(l < heapSize && A[l] > A[i]){
            largest = l;
        }else{
            largest = i;
        }
        if(r < heapSize && A[r] > A[largest]){
            largest = r;
        }
        if(largest != i){
            int temp = A[i];
            A[i] = A[largest];
            A[largest] = temp;
        }else{
            return;
        }
        MaxHeapify(A, largest);
    }

    /**没有递归的最大堆排序
     * @param A 堆数组
     * @param i 需要排序的根节点
     */
    public void MaxHeapifyNoRecursive(int[] A, int i){
        while(true){
            int l = left(i);
            int r = right(i);
            int heapSize = A.length;
            int largest;
            if(l < heapSize && A[l] > A[i]){
                largest = l;
            }else{
                largest = i;
            }
            if(r < heapSize && A[r] > A[largest]){
                largest = r;
            }
            if(largest != i){
                int temp = A[i];
                A[i] = A[largest];
                A[largest] = temp;
            }else{
                return;
            }
            i = largest;
        }
    }

    public void BuildMaxHeap(int[] A){
        int heapsize = A.length;
        for(int i = (heapsize - 1) / 2; i >= 0; i--){
            MaxHeapify(A, i);
        }
    }

    @Test
    public void TestMH(){
        int[] A = new int[]{16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
        MaxHeapify(A, 1);
        for(int x : A){
            System.out.print(x + " ");
        }
        System.out.println();
        int[] B = new int[]{16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
        MaxHeapifyNoRecursive(B, 1);
        for(int x : B){
            System.out.print(x + " ");
        }
        System.out.println();
        int[] C = new int[]{4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        MaxHeapifyNoRecursive(C, 4);
        for(int x : C){
            System.out.print(x + " ");
        }
    }

    @Test
    public void TestBMH(){
        int[] A = new int[]{4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        BuildMaxHeap(A);
        for(int x : A){
            System.out.print(x + " ");
        }
    }

}
