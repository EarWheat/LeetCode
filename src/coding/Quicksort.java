package coding;

/**
 * @author liuzhaolu
 * @version create_time：2018/8/1 类说明:快速排序
 */
public class Quicksort {

    public Integer[] QuickSort(Integer[] array){

    }

    public void showArray(Integer[] array){
        for(int i = 0;i<array.length;i++){
            System.out.print(array[i]);
            System.out.print(" ");
        }
    }

    public static void main(String[] args){
        Integer array[] = {23,45,11,18,45,66,78};
        Quicksort quicksort = new Quicksort();
        quicksort.showArray(array);
        System.out.println();
        quicksort.showArray(quicksort.QuickSort(array));
    }
}
