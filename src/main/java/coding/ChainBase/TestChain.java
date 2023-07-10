package coding.ChainBase;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc: 测试链式处理
 * @Author: 泽露
 * @Date: 2023/7/7 5:30 PM
 * @Version: 1.initial version; 2023/7/7 5:30 PM
 */
public class TestChain {
    public static void main(String[] args) {
        TestChain testChain = new TestChain();
        testChain.test();
    }

    public Boolean paramCheck(TaskContext context) {
        return true;
    }

    public Boolean bizHandler(TaskContext context) {
        return false;
    }

    public static class TaskContext {

    }

    public void test() {
        TaskContext context = new TaskContext();
        ChainHandler<TaskContext> result = ChainHandler.process(context)
                .handler(this::paramCheck, "参数错误")
                .handler(this::bizHandler, "业务逻辑出错")
                .result();
        System.out.println(result.getErrMsg());
    }
}
