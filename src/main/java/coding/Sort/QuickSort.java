package coding.Sort;

/*
 * @author:liuzhaolu
 * @createTime: 2020-03-23 14:04
 * @desc:
 */
public class QuickSort {
    public static void main(String[] args){

    }

    public static void sort(int[] a, int low, int high){
        if(low >= high){
            return;
        }

        int left = low;
        int right = high;

        // 保存基准值
        int index = a[left];
        while (left < right){
            // 从后向前找比基准小的元素
            while (left < right && a[right] >= index){
                right--;
            }
            a[left] = a[right];
            // 从前往后找比基准大的元素
            while (left < right && a[left] <= index){
                left++;
            }
            a[right] = a[left];
        }
        a[left] = index;
        sort(a, low, left - 1);
        sort(a, left + 1, high);
    }
}
