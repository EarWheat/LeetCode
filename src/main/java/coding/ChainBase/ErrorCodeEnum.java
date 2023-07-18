package coding.ChainBase;

/**
 * @Desc: 错误码枚举
 * @Author: 泽露
 * @Date: 2023/7/10 4:09 PM
 * @Version: 1.initial version; 2023/7/10 4:09 PM
 */
public enum ErrorCodeEnum {
    // 通用错误
    SUCCESS("SUCCESS", "成功"),
    PARAM_ERROR("PARAM_ERROR","参数错误"),
    UPDATE_ERROR("UPDATE_ERROR","更新失败"),

    ;
    private String errCode;
    private String errMsg;

    ErrorCodeEnum(String errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }
}
