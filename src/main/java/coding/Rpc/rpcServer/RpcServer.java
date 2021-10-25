package coding.Rpc.rpcServer;

import coding.Rpc.serviceCenter.RemoteServiceInfo;
import coding.Rpc.serviceCenter.ServiceCenter;

import javax.annotation.Resource;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/9/8 3:43 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public abstract class RpcServer {

    @Resource
    private ServiceCenter serviceCenter;
    /**
     * 服务注册
     */
   public final void register(){
       RemoteServiceInfo remoteServiceInfo = RemoteServiceInfo.builder()
               .ip("127.0.0.1")
               .port(8088)
               .build();
       serviceCenter.register(remoteServiceInfo);
   }
}
