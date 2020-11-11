package coding.work;

import org.apache.commons.lang.StringUtils;

import java.util.List;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-11-11 10:56
 * @desc StringArray转String
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class StringArray2String {
    public String StringArray2String(List<String> stringArray, String intervalChar){
        String result = "";
        if(StringUtils.isBlank(intervalChar)){
            for(String str : stringArray){
                result.concat(str);
            }
        } else {
            for(String str : stringArray){
                result.concat(str).concat(intervalChar);
            }
        }
        return result;
    }
}
