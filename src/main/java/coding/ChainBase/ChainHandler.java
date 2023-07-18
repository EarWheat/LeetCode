package coding.ChainBase;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2023/7/7 4:24 PM
 * @Version: 1.initial version; 2023/7/7 4:24 PM
 */

import io.vavr.control.Either;
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

    private static final ErrorCodeEnum SUCCESS_ERR_MSG = ErrorCodeEnum.SUCCESS;

    private String errCode;

    private String errMsg;

    private T value;

    public static <T> Processor<T> process(T t) {
        return new Processor<>(t);
    }

    @Data
    public static class Processor<T> {
        private T value;

        private boolean block = false;

        private ErrorCodeEnum errorCodeEnum = SUCCESS_ERR_MSG;

        public Processor(T value) {
            this.value = value;
        }

        public Processor<T> handler(Function<T, Boolean> mapper, ErrorCodeEnum errorCodeEnum) {
            Objects.requireNonNull(mapper, "mapper is null");
            return block ? this : (mapper.apply(value) ? this : this.block(errorCodeEnum));
        }

        public Processor<T> handler(Function<T, Either<ErrorCodeEnum, Boolean>> mapper) {
            Objects.requireNonNull(mapper, "mapper is null");
            if (block) {
                return this;
            } else {
                Either<ErrorCodeEnum, Boolean> apply = mapper.apply(value);
                return apply.isRight() ? this : this.block(apply.getLeft());
            }
        }

        public Processor<T> block(ErrorCodeEnum errorCodeEnum) {
            this.errorCodeEnum = errorCodeEnum;
            this.block = true;
            return this;
        }

        public ChainHandler<T> result() {
            ChainHandler<T> result = new ChainHandler<>();
            result.setErrCode(errorCodeEnum.getErrCode());
            result.setErrMsg(errorCodeEnum.getErrMsg());
            result.setValue(value);
            return result;
        }
    }

}

