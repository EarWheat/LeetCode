package coding.Exception;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/9/9 10:20 上午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class ExceptionDemo {

    public String sayHello(String name){
        try {
            String a = getStringFromSplitArray(new ArrayList<>());
            System.out.println("我能执行吗");
        } catch (Exception e){
            System.out.println("ex");
            throw e;
        }
        return "hello, " + name;
    }

    public String getStringFromSplitArray(List<String> list){
        throw new NullPointerException();
//        StringBuilder stringBuilder = new StringBuilder();
//        list.stream().forEach(s -> {
//            stringBuilder.append(s);
//            stringBuilder.append(",");
//        });
//        return stringBuilder.substring(0,stringBuilder.length() - 1).toString();
    }



    public static void main(String[] args) {
        ExceptionDemo exceptionDemo = new ExceptionDemo();
        System.out.println(exceptionDemo.sayHello("zero"));
    }
}
