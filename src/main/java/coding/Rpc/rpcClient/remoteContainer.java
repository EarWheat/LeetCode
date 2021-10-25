package coding.Rpc.rpcClient;

import coding.Rpc.serviceCenter.RemoteServiceInfo;
import coding.Rpc.serviceCenter.RpcRegister;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/9/8 3:19 下午
 * @desc remote远程调用列表
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class remoteContainer implements RpcRegister {
    /**
     * 远程服务的列表
     */
    List<RemoteServiceInfo> remoteServers = new ArrayList<>();

    @Override
    public void notice(List<RemoteServiceInfo>  remoteServers) {
       this.remoteServers = remoteServers;
    }
}
