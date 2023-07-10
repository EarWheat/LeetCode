package coding.ChainBase;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2023/7/7 4:24 PM
 * @Version: 1.initial version; 2023/7/7 4:24 PM
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;
import java.util.function.Function;

/**
 * @Desc: 链式处理器
 * @Author: 泽露
 * @Date: 2023/6/29 4:32 PM
 * @Version: 1.initial version; 2023/6/29 4:32 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChainHandler<T> implements Serializable {

    private static final long serialVersionUID = 4051147964888421099L;

    private static final String SUCCESS_ERR_MSG = "SUCCESS";

    private String errMsg;

    private T result;

    public static <T> Processor<T> process(T t) {
        return new Processor<>();
    }

    @Data
    public static class Processor<T> {
        private T value;

        private boolean block = false;

        private String errMsg = SUCCESS_ERR_MSG;

        public Processor<T> handler(Function<T, Boolean> mapper, String errMsg) {
            Objects.requireNonNull(mapper, "mapper is null");
            return block ? this : (mapper.apply(value) ? this : this.block(errMsg));
        }

        public Processor<T> block(String errMsg) {
            this.errMsg = errMsg;
            this.block = true;
            return this;
        }

        public ChainHandler<T> result() {
            ChainHandler<T> result = new ChainHandler<>();
            result.setErrMsg(this.getErrMsg());
            result.setResult(this.getValue());
            return result;
        }
    }

}
