import org.junit.Test;

/**
 * Created by Administrator on 2016/8/22.
 */
public class Sort {

    public int[] InsertionSort(int[] A){
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
        return null;
    }

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

    @Test
    public void TestIS(){
        int[] A = new int[]{4, 2, 3};
        InsertionSort(A);
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
