package jvm;

/*
 * @author:liuzhaolu
 * @createTime: 2020-05-15 17:27
 * @desc: Jvm测试类
 */
public class JvmTest {
    public static void main(String[] args) {
        System.out.println(stackOverFlow(0));
    }

    // 制造栈溢出异常
    public static int stackOverFlow(int result){
        if(result < Integer.MAX_VALUE){
            return stackOverFlow(++result);
        }
        return 0;
    }
}
