package coding.Rpc.rpcClient;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/9/8 6:50 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class rpcClient {
    public static void main(String[] args) throws IOException {
        Socket socket = null;
        ObjectOutputStream outputStream = null;
        ObjectInputStream input = null;
        try {
            socket = new Socket();
            socket.connect(new InetSocketAddress(8090));
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeUTF("SayHelloService");
            outputStream.writeUTF("say");
            input = new ObjectInputStream(socket.getInputStream());
            System.out.println(input.readObject());
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (socket != null) socket.close();
            if (outputStream != null) outputStream.close();
            if (input != null) input.close();
        }
    }
}
