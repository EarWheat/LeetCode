package coding;

import org.apache.commons.lang.StringUtils;

/**
 * @author liuzhaolu
 * @version create_time：2018/8/29 类说明:
 */
public class StringTest {

    public static void modified(String s){
        s += "World!";
    }

    public static void main(String[] args){
        String s = new String("Hello");     //声明了两个对象，s为一个String对象。new了一个新的String对象，然后将new的String对象赋值给s
        modified(s);        //修改但并无返回，修改的并不是声明的String s对象
        System.out.println(s);
    }

    public String getStringSplitFirst(String str, String split){
        if(StringUtils.isBlank(str)){
            return "";
        }
        return str.split(split)[0];
    }
}
