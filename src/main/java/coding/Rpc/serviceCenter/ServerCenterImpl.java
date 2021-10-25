package coding.Rpc.serviceCenter;

import coding.Rpc.rpcServer.HelloService;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/9/8 5:19 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class ServerCenterImpl implements ServiceCenter{
    private ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,10,600, TimeUnit.SECONDS,
            new LinkedBlockingDeque<>());

    public static final List<RemoteServiceInfo> remoteServices = null;

    @Override
    public void register(RemoteServiceInfo remoteService) {
        Method[] methods = HelloService.class.getDeclaredMethods();
        Arrays.stream(methods).forEach(method -> {
            remoteServices.add(RemoteServiceInfo.builder()
                    .ip("localhost")
                    .port(8080)
                    .clazz(HelloService.class)
                    .method(method)
                    .build());
        });
    }

    @Override
    public void serviceRemove(RemoteServiceInfo remoteServiceInfo) {
        remoteServices.remove(remoteServiceInfo);
    }


}
