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

    public void MaxHeapInsert(Heap heap, int key) throws Exception{
        ArrayList<Integer> A = heap.getA();
        int heapSize = heap.getHeapSize();
        heap.setHeapSize(++heapSize);
        A.add(Integer.MIN_VALUE);
        HeapIncreaseKey(heap, heapSize - 1, key);
    }

    /**
     * 测试HeapMaximum
     */
    @Test
    public void TestHM(){
        Heap heap = new Heap();
        int[] A = new int[]{16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
        ArrayList<Integer> array = new ArrayList<>();
        for(int x : A){
            array.add(x);
        }
        heap.setA(array);
        heap.setHeapSize(A.length);

        sort.BuildMaxHeap(heap);
        System.out.println(HeapMaximum(heap));
    }

    /**
     * 测试HeapExtractMax
     * @throws Exception
     */
    @Test
    public void TestHEM() throws Exception{
        Heap heap = new Heap();
        int[] A = new int[]{16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
        ArrayList<Integer> array = new ArrayList<>();
        for(int x : A){
            array.add(x);
        }
        heap.setA(array);
        heap.setHeapSize(A.length);

        sort.BuildMaxHeap(heap);
        System.out.println(HeapExtractMax(heap));
        for(int i = 0; i < heap.getHeapSize(); i++){
            System.out.print(heap.getA().get(i) + " ");
        }
    }

    /**
     * 测试MaxHeapInsert
     * @throws Exception
     */
    @Test
    public void TestMHI() throws Exception{
        Heap heap = new Heap();
        int[] A = new int[]{16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
        ArrayList<Integer> array = new ArrayList<>();
        for(int x : A){
            array.add(x);
        }
        heap.setA(array);
        heap.setHeapSize(A.length);

        sort.BuildMaxHeap(heap);
        MaxHeapInsert(heap, 15);
        for(int x : heap.getA()){
            System.out.print(x + " ");
        }
    }

    /**
     * 测试HeapIncreaseKey
     * @throws Exception
     */
    @Test
    public void TestHIK() throws Exception{
        Heap heap = new Heap();
        int[] A = new int[]{16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
        ArrayList<Integer> array = new ArrayList<>();
        for(int x : A){
            array.add(x);
        }
        heap.setA(array);
        heap.setHeapSize(A.length);

        sort.BuildMaxHeap(heap);
        HeapIncreaseKey(heap, 8, 15);
        for(int x : heap.getA()){
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println(HeapMaximum(heap));
    }
}
