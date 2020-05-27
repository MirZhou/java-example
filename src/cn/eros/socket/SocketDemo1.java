package cn.eros.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * <p>Create time: 2020/5/27 23:07</p>
 *
 * @author 周光兵
 */
public class SocketDemo1 {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getByName("www.geekbang.com");

        System.out.println(inetAddress.getHostName());
        System.out.println(inetAddress.getHostAddress());
    }
}
