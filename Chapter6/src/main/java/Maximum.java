import org.junit.Test;

/**
 * Created by Administrator on 2016/8/26.
 */
public class Maximum {

    Sort sort = new Sort();

    public int HeapMaximum(Heap heap){
        return heap.getA()[0];
    }

    public int HeapExtractMax(Heap heap) throws Exception{
        int[] A = heap.getA();
        int heapSize = heap.getHeapSize();
        if(heapSize < 1){
            throw new Exception("heap underflow");
        }
        int max = A[0];
        A[0] = A[heapSize - 1];
        heapSize--;
        sort.MaxHeapify(A, 0, heapSize);
        return max;
    }

    public void HeapIncreaseKey(Heap heap, int i, int key) throws Exception{
        int[] A = heap.getA();
        int heapSize = heap.getHeapSize();
        if(key < A[i]){
            throw new Exception("new key is smaller than current key!");
        }
        A[i] = key;
        while(i > 0 && A[sort.parent(i)] < A[i]){
            int temp = A[sort.parent(i)];
            A[sort.parent(i)] = A[i];
            A[i] = temp;
            i = sort.parent(i);
        }
    }

    /**
     * 好吧。我错了。JAVA的数组声明了以后就不能加元素了呢。果然还是应该用arraylist
     * @param heap
     * @param key
     * @throws Exception
     */
    public void MaxHeapInsert(Heap heap, int key) throws Exception{
        int[] A = heap.getA();
        int heapSize = heap.getHeapSize();
        heapSize = heapSize + 1;
        A[heapSize - 1] = Integer.MIN_VALUE;
        HeapIncreaseKey(heap, heapSize, key);
    }

    @Test
    public void TestMHI() throws Exception{
        Heap heap = new Heap();
        int[] A = new int[]{16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
        heap.setA(A);
        heap.setHeapSize(A.length);
        MaxHeapInsert(heap, 15);
    }

    @Test
    public void TestHIK() throws Exception{
        Heap heap = new Heap();
        int[] A = new int[]{16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
        heap.setA(A);
        heap.setHeapSize(A.length);
        HeapIncreaseKey(heap, 8, 15);
        for(int x : A){
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println(HeapMaximum(heap));
    }
}
