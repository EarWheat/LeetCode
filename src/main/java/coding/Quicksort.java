package coding;

/**
 * @author liuzhaolu
 * @version create_time：2018/8/1 类说明:快速排序
 */
public class Quicksort {

    public static void sort(Integer[] array,int low ,int high){
        int start = low;
        int end = high;
        int key = array[low];
        while (end > start){
            while (end > start && array[end] >= key)
                end--;
            if(array[end] <= key){
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }
            while (end > start && array[start] <= key)
                start++;
            if(array[start] >= key){
                int temp = array[end];
                array[end] = array[start];
                array[start] = temp;
            }
        }
        if(start>low) sort(array,low,start);
        if(end<high) sort(array,end+1,high);
    }

    private static void showArray(Integer[] array){
        for(int i = 0;i<array.length;i++){
            System.out.print(array[i]);
            System.out.print(" ");
        }
    }

    public static void main(String[] args){
        Integer array[] = {23,45,11,18,45,66,78};
        showArray(array);
        System.out.println();
        sort(array,0,array.length-1);
        showArray(array);
    }
}
