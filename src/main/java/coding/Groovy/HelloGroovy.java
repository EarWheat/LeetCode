package coding.Groovy;

import com.ruban.pangu.Groovy.GroovyUtil;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-12-11 10:57
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class HelloGroovy {
    public static void main(String[] args) {
        String test = "public static String SayHello(String name){\n" +
                "    return \"Hello, \" + name;\n" +
                "}\n" +
                "SayHello(name);";
        Map<String, String> map = new HashMap<>();
        map.put("name","zero");
        String result = (String)GroovyUtil.runGroovyClass(test,map);
        System.out.println(result);
    }
}
