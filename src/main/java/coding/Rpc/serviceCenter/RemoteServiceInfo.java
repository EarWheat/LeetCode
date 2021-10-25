package coding.Rpc.serviceCenter;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/9/8 3:29 下午
 * @desc 远程服务内容
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
@Data
@Builder
public class RemoteServiceInfo implements Serializable {

    private static final long serialVersionUID = 860860012881364604L;
    /**
     * ip
     */
    private String ip;

    /**
     * 端口
     */
    private int port;

    /**
     * 远程调用的类
     */
    private Class<?> clazz;

    /**
     * 远程调用的方法
     */
    private Method method;
}
