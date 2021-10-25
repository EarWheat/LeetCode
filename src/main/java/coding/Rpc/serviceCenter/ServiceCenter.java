package coding.Rpc.serviceCenter;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/9/8 3:38 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public interface ServiceCenter {
    /**
     * 服务注册
     * @param remoteService
     */
    void register(RemoteServiceInfo remoteService);

    /**
     * 服务摘除
     * @param remoteServiceInfo
     */
    void serviceRemove(RemoteServiceInfo remoteServiceInfo);
}
