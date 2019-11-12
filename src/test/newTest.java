package test;

import java.io.IOException;
import java.net.Socket;

/*
 * @author:liuzhaolu
 * @createTime: 2019-11-06 15:37
 * @desc:
 */
public class newTest {
    public static void main(String[] args) throws IOException {
        System.out.println("------");
        System.out.println(checkOrderExtraType(49664,10));
        Socket socket = new Socket("127.0.0.1",8080);
    }

    public static boolean checkOrderExtraType(long extraType, long index) {
        long moveIndex = Math.round(Math.pow(2,index - 1));
        long airportBit = extraType & moveIndex;

        if(airportBit == moveIndex){
            return true;
        }else{
            return false;
        }
    }

}
