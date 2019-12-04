package utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author NieLin
 * @version 1.0
 * @date 2019/11/30 23:31
 */
public class a {
    public static void main(String[] args) {
        InetAddress addr = null;
        try {
            addr = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String ip=addr.getHostAddress();

        System.out.println(ip);
    }
}
