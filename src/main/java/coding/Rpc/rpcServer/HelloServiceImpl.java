package coding.Rpc.rpcServer;

import coding.Rpc.serviceCenter.ServiceCenter;

import javax.annotation.Resource;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/9/8 3:52 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class HelloServiceImpl implements HelloService{

    @Override
    public String sayHello(String name) {
        return "hello!" + name;
    }
}
