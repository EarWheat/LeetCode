package coding.Sort;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/3/19 下午2:50
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class MainSort {
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,3,2,7,8,9,1,2,5,4};
//        MyQuickSort myQuickSort = new MyQuickSort();
//        System.out.println(JSONObject.toJSONString(myQuickSort.QuickSort(nums)));
        PopSort popSort = new PopSort();
        System.out.println(JSONObject.toJSONString(popSort.sort(nums)));
    }
}
