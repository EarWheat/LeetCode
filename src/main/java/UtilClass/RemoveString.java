package UtilClass;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/5/15 上午10:24
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class RemoveString {
    public static void main(String[] args) {

    }

    public String[] removeStringFromStringArray(String str, String[] array){
        List<String> list = Arrays.stream(array).collect(Collectors.toList());
        list.remove(str);
        return (String[]) list.toArray();
    }

    public List<String> removeStringFromStringArray(List<String> array, String str){
        array.remove(str);
        return array;
    }
}
