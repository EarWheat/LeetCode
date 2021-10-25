package coding.Rpc.serviceCenter;

import java.util.List;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/9/8 3:23 下午
 * @desc 服务注册者
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public interface RpcRegister {
    /**
     * 发送通知
     */
    void notice(List<RemoteServiceInfo> remoteServiceInfoList);
}
