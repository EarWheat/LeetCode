package coding.ChainBase;

import io.vavr.control.Either;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

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

    public Boolean ruleCheck(TaskContext context) {
        return true;
    }

    public Either<ErrorCodeEnum, Boolean> bizHandler(TaskContext context) {
        System.out.println("biz handler start");

        return Either.left(ErrorCodeEnum.UPDATE_ERROR);
    }

    public Either<ErrorCodeEnum, Boolean> bizHandler2(TaskContext context) {
        System.out.println("biz2 handler start");

        return Either.left(ErrorCodeEnum.PARAM_ERROR);
    }


    public static class TaskContext {

    }

    public void test() {
        TaskContext context = new TaskContext();
        ChainHandler<TaskContext> result = ChainHandler.process(context)
                .handler(this::paramCheck, ErrorCodeEnum.PARAM_ERROR)
                .handler(this::ruleCheck, ErrorCodeEnum.PARAM_ERROR)
                .handler(this::bizHandler)
                .handler(this::bizHandler2)
                .result();
        System.out.println(result.getErrMsg());
    }
}
