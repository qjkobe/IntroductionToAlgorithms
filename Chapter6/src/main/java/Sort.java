import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * 最大堆排序
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

    public void MaxHeapify(Heap heap, int i){
        int l = left(i);
        int r = right(i);
        int largest;
        if(l < heap.getHeapSize() && heap.getA().get(l) > heap.getA().get(i)){
            largest = l;
        }else{
            largest = i;
        }
        if(r < heap.getHeapSize() && heap.getA().get(r) > heap.getA().get(largest)){
            largest = r;
        }
        if(largest != i){
            int temp = heap.getA().get(i);
            heap.getA().set(i, heap.getA().get(largest));
            heap.getA().set(largest, temp);
        }else{
            return;
        }
        MaxHeapify(heap, largest);
    }

    /**没有递归的最大堆排序
     * @param heap 堆
     * @param i 需要排序的根节点
     */
    public void MaxHeapifyNoRecursive(Heap heap, int i){
        while(true){
            int l = left(i);
            int r = right(i);
            int heapSize = heap.getHeapSize();
            ArrayList<Integer> A = heap.getA();
            int largest;
            if(l < heapSize && A.get(l) > A.get(i)){
                largest = l;
            }else{
                largest = i;
            }
            if(r < heapSize && A.get(r) > A.get(largest)){
                largest = r;
            }
            if(largest != i){
                int temp = A.get(i);
                A.set(i, heap.getA().get(largest));
                A.set(largest, temp);
            }else{
                return;
            }
            i = largest;
        }
    }

    public void BuildMaxHeap(Heap heap){
        int heapsize = heap.getHeapSize();
        for(int i = (heapsize - 1) / 2; i >= 0; i--){
            MaxHeapify(heap, i);
        }
    }

    public void HeapSort(Heap heap){
        BuildMaxHeap(heap);
        int length = heap.getA().size(), heapSize = heap.getHeapSize();
        for(int i = length - 1; i > 0; i--){
            int temp = heap.getA().get(i);
            heap.getA().set(i, heap.getA().get(0));
            heap.getA().set(0, temp);
            heap.setHeapSize(--heapSize);
            MaxHeapify(heap, 0);
        }
    }

    @Test
    public void TestHS(){
        Heap heap = new Heap();
        ArrayList<Integer> A = new ArrayList<>();
        int[] array = new int[]{-16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
        for(int x : array){
            A.add(x);
        }
        heap.setA(A);
        heap.setHeapSize(array.length);
        HeapSort(heap);
        for(int x : heap.getA()){
            System.out.print(x + " ");
        }
    }

    @Test
    public void TestMH(){
        Heap heap = new Heap();
        ArrayList<Integer> A = new ArrayList<>();
        int[] array = new int[]{16, 4, 10, 14, 7, 9, 3, 2, 8, 1};

        for(int x : array){
            A.add(x);
        }
        heap.setA(A);
        heap.setHeapSize(array.length);

        MaxHeapify(heap, 0);
        for(int x : A){
            System.out.print(x + " ");
        }
        System.out.println();

        ArrayList<Integer> B = new ArrayList<>();
        int[] array2 = new int[]{16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
        for(int x : array2){
            B.add(x);
        }
        heap.setA(B);
        heap.setHeapSize(array2.length);
        MaxHeapifyNoRecursive(heap, 1);
        for(int x : B){
            System.out.print(x + " ");
        }
        System.out.println();

        ArrayList<Integer> C = new ArrayList<>();
        int[] array3 = new int[]{4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        for(int x : array3){
            C.add(x);
        }
        heap.setA(C);
        heap.setHeapSize(array2.length);
        MaxHeapifyNoRecursive(heap, 4);
        for(int x : C){
            System.out.print(x + " ");
        }
    }

    @Test
    public void TestBMH(){
        Heap heap = new Heap();
        ArrayList<Integer> A = new ArrayList<>();
        int[] array = new int[]{4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        for(int x : array){
            A.add(x);
        }
        heap.setA(A);
        heap.setHeapSize(array.length);

        BuildMaxHeap(heap);
        for(int x : A){
            System.out.print(x + " ");
        }
    }

}
