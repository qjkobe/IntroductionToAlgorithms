import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/8/26.
 */
public class Maximum {

    Sort sort = new Sort();

    public int HeapMaximum(Heap heap){
        return heap.getA().get(0);
    }

    public int HeapExtractMax(Heap heap) throws Exception{
        ArrayList<Integer> A = heap.getA();
        int heapSize = heap.getHeapSize();
        if(heapSize < 1){
            throw new Exception("heap underflow");
        }
        int max = A.get(0);
        A.set(0, A.get(heapSize - 1));
        heap.setHeapSize(heapSize - 1);
        sort.MaxHeapify(heap, 0);
        return max;
    }

    public void HeapIncreaseKey(Heap heap, int i, int key) throws Exception{
        ArrayList<Integer> A = heap.getA();
        int heapSize = heap.getHeapSize();
        if(key < A.get(i)){
            throw new Exception("new key is smaller than current key!");
        }
        A.set(i, key);
        while(i > 0 && A.get(sort.parent(i)) < A.get(i)){
            int temp = A.get(sort.parent(i));
            A.set(sort.parent(i), A.get(i));
            A.set(i, temp);
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
        ArrayList<Integer> A = heap.getA();
        int heapSize = heap.getHeapSize();
        heapSize = heapSize + 1;
        A.set(heapSize - 1, Integer.MIN_VALUE);
        HeapIncreaseKey(heap, heapSize, key);
    }

    @Test
    public void TestMHI() throws Exception{
//        Heap heap = new Heap();
//        int[] A = new int[]{16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
//        heap.setA(A);
//        heap.setHeapSize(A.length);
//        MaxHeapInsert(heap, 15);
    }

    @Test
    public void TestHIK() throws Exception{
//        Heap heap = new Heap();
//        int[] A = new int[]{16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
//        heap.setA(A);
//        heap.setHeapSize(A.length);
//        HeapIncreaseKey(heap, 8, 15);
//        for(int x : A){
//            System.out.print(x + " ");
//        }
//        System.out.println();
//        System.out.println(HeapMaximum(heap));
    }
}
