import org.junit.Test;

/**
 * 最小堆排序
 * Created by Administrator on 2016/8/26.
 */
public class SortDesc {

    int left(int i){
        return i * 2 + 1;
    }
    int right(int i){
        return i * 2 + 2;
    }
    int parent(int i){
        return (i - 1) / 2;
    }

    public void MinHeapify(int[] A, int i, int heapSize){
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if(l < heapSize && A[l] < A[i]){
            smallest = l;
        }
        if(r < heapSize && A[r] < A[smallest]){
            smallest = r;
        }
        int temp = A[smallest];
        A[smallest] = A[i];
        A[i] = temp;
        if(smallest == i){
            return;
        }
        MinHeapify(A, smallest, heapSize);
    }

    public void BuildMinHeap(int[] A){
        int heapSize = A.length;
        for(int i = (heapSize - 1) / 2; i >= 0; i--){
            MinHeapify(A, i, heapSize);
        }
    }

    public void HeapSort(int[] A){
        int length = A.length, heapSize = A.length;
        BuildMinHeap(A);
        for(int i = length - 1; i > 0; i--){
            int temp = A[i];
            A[i] = A[0];
            A[0] = temp;
            heapSize--;
            MinHeapify(A, 0, heapSize);
        }
    }

    @Test
    public void TestHS(){
        int[] A = new int[]{16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
        HeapSort(A);
        for(int x : A){
            System.out.print(x + " ");
        }
    }
}
